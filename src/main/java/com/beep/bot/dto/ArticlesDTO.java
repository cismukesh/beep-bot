/**
 * 
 */
package com.beep.bot.dto;

import com.beep.bot.dto.SourceDTO;

/**
 * @author cis
 *
 */
public class ArticlesDTO {

	private String title;
	private String author;
	private String description;
	private String content;
	private SourceDTO source;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the source
	 */
	public SourceDTO getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(SourceDTO source) {
		this.source = source;
	}
	
	

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticlesDTO [title=");
		builder.append(title);
		builder.append(", author=");
		builder.append(author);
		builder.append(", description=");
		builder.append(description);
		builder.append(", content=");
		builder.append(content);
		builder.append(", source=");
		builder.append(source);
		builder.append("]");
		return builder.toString();
	}
	

}
