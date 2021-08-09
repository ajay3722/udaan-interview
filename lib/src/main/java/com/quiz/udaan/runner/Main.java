package com.quiz.udaan.runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.quiz.udaan.model.Question;
import com.quiz.udaan.model.Quiz;
import com.quiz.udaan.model.User;
import com.quiz.udaan.service.IScoringService;
import com.quiz.udaan.service.QuizService;
import com.quiz.udaan.service.ScroingService;

public class Main {

	
	public static void main(String [] arg) {
		//(String id, String ans, String questionStm)
		
		Question q1 = new Question("1","2","what is 1+1");
		Question q2 = new Question("2","4","what is 2+2");
		Question q3 = new Question("3","6","what is 3+3");
		
		
		//(String id,  Map<Question, List<String>> quizQuestionsp)
		
		List<String> ansList1= new ArrayList<>();
		ansList1.add("1");
		ansList1.add("2");
		ansList1.add("3");
		ansList1.add("4");
		
		List<String> ansList2= new ArrayList<>();
		ansList2.add("1");
		ansList2.add("2");
		ansList2.add("3");
		ansList2.add("4");
		
		List<String> ansList3= new ArrayList<>();
		ansList3.add("1");
		ansList3.add("2");
		ansList3.add("3");
		ansList3.add("6");
		Map<Question, List<String>> quizQuestionsp= new HashMap<>();
		
		quizQuestionsp.put(q1, ansList1);
		quizQuestionsp.put(q2, ansList2);
		quizQuestionsp.put(q3, ansList3);
		
		//Quiz quiz = new Quiz("1",quizQuestionsp);
		
		QuizService quizService= QuizService.getInstance();
		quizService.createQuiz("1", quizQuestionsp);
		//user 1
		
		User user1= new User("1","a");
		
		User user2= new User("2","b");
		int score = quizService.startQuiz(user2, "1");
		 System.out.println("score is :"+score);
		
	System.out.println("Get score for :"+user2.getId());
	IScoringService scroingService=ScroingService.getInstance();
		int score2 =scroingService.getScore(user2.getId()) ;
		if(score2==-1) {
			System.out.println("User has not attended the test");
		} else {
			System.out.println("User score is :"+score2);
		}
		
	}
}
