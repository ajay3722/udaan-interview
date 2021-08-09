package com.quiz.udaan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.quiz.udaan.model.Question;
import com.quiz.udaan.model.User;

public class ScroingService implements IScoringService   {

	Map<String, User> userHistory = new HashMap<>();
	private static IScoringService single_instance = null;

	private ScroingService() {
	}

	public static IScoringService getInstance() {
		if (single_instance == null)
			single_instance = new ScroingService();
		return single_instance;
	}

	@Override
	public int calculateScore(Map<Question, String> questions, String id, User user) {
		int score = 0;
		for (Entry<Question, String> q : questions.entrySet()) {
			if (q.getKey().getAns().equals(q.getValue())) {
				score=	q.getFactor()*score;
			}
				score++;
			else
				score--;
		}
		
		user.setUserScore(score);
		userHistory.put(user.getId(), user);
		return score;
	}

	@Override
	public int getScore(String id) {
		if (!userHistory.containsKey(id)) {
			return -1;

		}
		return userHistory.get(id).getUserScore();
	}
}
