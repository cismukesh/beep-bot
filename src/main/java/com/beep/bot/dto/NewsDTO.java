package com.beep.bot.dto;

import java.io.Serializable;
import java.util.List;

public class NewsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2568577041509849714L;
	private String status;
	private String totalResults;
	private List<ArticlesDTO> articles;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the totalResults
	 */
	public String getTotalResults() {
		return totalResults;
	}

	/**
	 * @param totalResults the totalResults to set
	 */
	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}

	/**
	 * @return the articles
	 */
	public List<ArticlesDTO> getArticles() {
		return articles;
	}

	/**
	 * @param articles the articles to set
	 */
	public void setArticles(List<ArticlesDTO> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NewsDTO [status=");
		builder.append(status);
		builder.append(", totalResults=");
		builder.append(totalResults);
		builder.append(", articles=");
		builder.append(articles);
		builder.append("]");
		return builder.toString();
	}

}
