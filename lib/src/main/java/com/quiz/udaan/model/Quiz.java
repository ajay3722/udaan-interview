package com.quiz.udaan.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz {
	String Id;
	Map<Question, List<String>> quizQuestions;

	public Quiz(String id) {
		super();
		Id = id;
		this.quizQuestions = new HashMap<>();
	}

	public String getId() {
		return Id;
	}

	public Map<Question, List<String>> getQuizQuestions() {
		return quizQuestions;
	}

	public void setQuizQuestions(Map<Question, List<String>> quizQuestions) {
		this.quizQuestions = quizQuestions;
	}

}
