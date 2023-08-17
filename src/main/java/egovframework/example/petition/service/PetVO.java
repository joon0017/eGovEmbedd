package egovframework.example.petition.service;

import java.math.BigDecimal;

public class PetVO {
	
	private double article_id;
	
	private String start;
	
	private String end;
	
	private int answered;
	
	private int votes;
	
	private String category;
	
	private String title;
	
	private String content;
	
	public double getArticle_id() {
		return article_id;
	}
	
	public void setArticle_id(double article_id) {
		this.article_id = article_id;
	}
	
	public String getStart() {
		return start;
	}
	
	public void setStart(String start) {
		this.start = start;
	}
	
	public String getEnd() {
		return end;
	}
	
	public void setEnd(String end) {
		this.end = end;
	}
	
	public int getAnswered() {
		return answered;
	}
	
	public void setAnswered(int answered) {
		this.answered = answered;
	}
	
	public int getVotes() {
		return votes;
	}
	
	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}