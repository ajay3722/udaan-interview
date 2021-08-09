package com.quiz.udaan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import com.quiz.udaan.model.Question;
import com.quiz.udaan.model.Quiz;
import com.quiz.udaan.model.User;

public class QuizService {

	Map<String, Quiz> quizMap = new HashMap<>();
	IScoringService scroingService = ScroingService.getInstance();
	private static QuizService single_instance = null;

	private QuizService() {
	}

	public static QuizService getInstance() {
		if (single_instance == null)
			single_instance = new QuizService();
		return single_instance;
	}

	public Quiz createQuiz(String id, Map<Question, List<String>> quizQuestions) {
		if (quizMap.containsKey(id)) {
			return quizMap.get(id);
		}
		Quiz quiz = new Quiz(id);
		quiz.setQuizQuestions(quizQuestions);
		quizMap.put(id, quiz);
		return quiz;
	}

	public Map<String, Quiz> getQuizMap() {
		return quizMap;
	}

	public void setQuizMap(Map<String, Quiz> quizMap) {
		this.quizMap = quizMap;
	}

	public Map<Question, List<String>> showQuiz(User user, String id) {

		if (!quizMap.containsKey(id)) {
			// exception
			return null;
		}
		return quizMap.get(id).getQuizQuestions();

	}

	public int startQuiz(User user, String id) {
		if (!quizMap.containsKey(id)) {
			// exception

		}
		Map<Question, List<String>> questions = showQuiz(user, id);
		Scanner sc = new Scanner(System.in);
		Map<Question, String> submition = new HashMap<>();

		for (Entry<Question, List<String>> q : questions.entrySet()) {
			System.out.println("Q.1 " + q.getKey().getQuestionStm());
			q.getValue().stream().forEach(item -> {
				System.out.print(item + " ");
			});
			System.out.println();
			System.out.println("Sumbit your ans :");
			submition.put(q.getKey(), sc.nextLine());
		}

		return scroingService.calculateScore(submition, id, user);

	}
}
