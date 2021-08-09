package com.quiz.udaan.service;

import java.util.Map;

import com.quiz.udaan.model.Question;
import com.quiz.udaan.model.User;

public interface IScoringService {

	int calculateScore(Map<Question, String> questions, String id, User user);

	int getScore(String id);

}