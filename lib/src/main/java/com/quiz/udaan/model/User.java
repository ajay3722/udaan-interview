package com.quiz.udaan.model;

public class User {
	String id;
	String userName;
	int userScore;

	public User(String id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

	public String getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public int getUserScore() {
		return userScore;
	}

	public void setUserScore(int userScore) {
		this.userScore = userScore;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userScore=" + userScore + "]";
	}
	
	

}
