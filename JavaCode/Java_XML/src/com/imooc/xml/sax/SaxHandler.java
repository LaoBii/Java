package com.imooc.xml.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.imooc.xml.Book;

public class SaxHandler extends DefaultHandler{
	private String value ;
	private Book book;
	private List<Book> bookList = new ArrayList<Book>();
	/**
	 * 用来遍历xml文件的开始标签
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if(qName.equals("book")) {
			book = new Book();
			//已知属性名称
			String value = attributes.getValue("id");
			book.setId(value);
			System.out.println("book的属性值:" + value);
			//未知属性名称
			//利用for循环
			/*for (int i = 0; i < attributes.getLength(); i++) {
				String name = attributes.getQName(i);
				String value = attributes.getValue(i);
			}*/
		} else if(!qName.equals("bookstore")){
			System.out.println("节点名:" + qName);
		}
		
	}
	
	/**
	 * 用来遍历xml文件的结束标签
	 * 里面进行遍历到结束标签时的操作写在这块
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		if(qName.equals("book")) {
			bookList.add(book);
			book = null;
		}
		if(qName.equals("name")) {
			book.setName(value);
		} else if(qName.equals("author")) {
			book.setAuthor(value);
		} else if(qName.equals("price")) {
			book.setPrice(value);
		} else if(qName.equals("language")) {
			book.setLanguage(value);
		} else if(qName.equals("year")) {
			book.setYear(value);
		} 
	}
	
	/**
	 * 用来标记解析开始
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("sax解析开始");
	}
	
	/**
	 * 用来标记解析结束
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("sax解析结束");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		value = new String(ch, start, length);
		if(!value.trim().equals("")) {
			System.out.println("属性值:" + value);
		}
	}

	public List<Book> getBookList() {
		return bookList;
	}
}
