package com.imooc.xml.sax;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.imooc.xml.Book;

/**
 * Sax����
 * ԭ��:sax�ᴴ��һ��Handler��������˳�����
  * @title SaxCompiler
  * @author Administrator
  * @date 2016��8��2�� ����9:47:49
 */
public class SaxCompiler {
	public void saxCompiler() throws ParserConfigurationException, SAXException, IOException {
		//����ͨ��SAXParserFactory����ʵ��
		SAXParserFactory sf = SAXParserFactory.newInstance();
		//ͨ��SaxParserFactoryʵ����ȡSaxParserʵ��
		SAXParser sp = sf.newSAXParser();
		//����SaxĬ�ϵ�handler,��handler�̳���DefaultHandler
		SaxHandler handler = new SaxHandler();
		sp.parse("file\\book.xml", handler);
		List<Book> bookList = handler.getBookList();
		for (Book object : bookList) {
			System.out.println(object);
		}
	}
}
