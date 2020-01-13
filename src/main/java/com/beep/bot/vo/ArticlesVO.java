/**
 * 
 */
package com.beep.bot.vo;

/**
 * @author cis
 *
 */
public class ArticlesVO {

	private String title;
	private String author;
	private String description;
	private SourceVO source;

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
	 * @return the sourceVO
	 */
	public SourceVO getSourceVO() {
		return source;
	}

	/**
	 * @param source the sourceVO to set
	 */
	public void setSourceVO(SourceVO source) {
		this.source = source;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticlesVO [title=");
		builder.append(title);
		builder.append(", author=");
		builder.append(author);
		builder.append(", description=");
		builder.append(description);
		builder.append(", sourceVO=");
		builder.append(source);
		builder.append("]");
		return builder.toString();
	}

}
