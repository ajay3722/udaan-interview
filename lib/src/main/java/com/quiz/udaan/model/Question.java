package com.quiz.udaan.model;

public class Question {
	String id;
	String ans;
	String questionStm;
	
	public Question(String id, String ans, String questionStm) {
		super();
		this.id = id;
		this.ans = ans;
		this.questionStm = questionStm;
	}

	public String getId() {
		return id;
	}

	public String getAns() {
		return ans;
	}

	public String getQuestionStm() {
		return questionStm;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public void setQuestionStm(String questionStm) {
		this.questionStm = questionStm;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", ans=" + ans + ", questionStm=" + questionStm + "]";
	}
	
	
	
	
}
