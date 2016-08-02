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
	 * ��������xml�ļ��Ŀ�ʼ��ǩ
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if(qName.equals("book")) {
			book = new Book();
			//��֪��������
			String value = attributes.getValue("id");
			book.setId(value);
			System.out.println("book������ֵ:" + value);
			//δ֪��������
			//����forѭ��
			/*for (int i = 0; i < attributes.getLength(); i++) {
				String name = attributes.getQName(i);
				String value = attributes.getValue(i);
			}*/
		} else if(!qName.equals("bookstore")){
			System.out.println("�ڵ���:" + qName);
		}
		
	}
	
	/**
	 * ��������xml�ļ��Ľ�����ǩ
	 * ������б�����������ǩʱ�Ĳ���д�����
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
	 * ������ǽ�����ʼ
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("sax������ʼ");
	}
	
	/**
	 * ������ǽ�������
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("sax��������");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		value = new String(ch, start, length);
		if(!value.trim().equals("")) {
			System.out.println("����ֵ:" + value);
		}
	}

	public List<Book> getBookList() {
		return bookList;
	}
}
