/**
 * 
 */
package com.mWebsite.bean;

import java.sql.Timestamp;

/**
 * @author lxynox
 *
 */
public class Article {
	private int id;
	private String title;
	private String tag;
	private String paragraph;
	private Timestamp timestamp;
	
	public Article() {}
	public Article(int id, String title, String tag, String paragraph,
			Timestamp timestamp) {
		super();
		this.setId(id);
		this.title = title;
		this.tag = tag;
		this.paragraph = paragraph;
		this.timestamp = timestamp;
	}
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
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * @return the paragraph
	 */
	public String getParagraph() {
		return paragraph;
	}
	/**
	 * @param paragraph the paragraph to set
	 */
	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}
	/**
	 * @return the timestamp
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", tag=" + tag + ", paragraph="
				+ paragraph + ", timestamp=" + timestamp + "]";
	}
	
	
}
