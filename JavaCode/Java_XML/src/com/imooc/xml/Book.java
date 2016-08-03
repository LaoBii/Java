package com.imooc.xml;

/**
 * xml保存成book对象
  * @title Book
  * @author Administrator
  * @date 2016年8月2日 下午10:21:18
 */
public class Book {
	private String id;
	private String name;
	private String price;
	private String author;
	private String year;
	private String language;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", author=" + author + ", year=" + year
				+ ", language=" + language + "]";
	}
}
