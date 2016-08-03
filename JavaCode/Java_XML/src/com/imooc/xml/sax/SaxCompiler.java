package com.imooc.xml.sax;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.imooc.xml.Book;

/**
 * Sax解析
 * 原理:sax会创建一个Handler进行逐行顺序解析
  * @title SaxCompiler
  * @author Administrator
  * @date 2016年8月2日 下午9:47:49
 */
public class SaxCompiler {
	public void saxCompiler() throws ParserConfigurationException, SAXException, IOException {
		//首先通过SAXParserFactory创建实例
		SAXParserFactory sf = SAXParserFactory.newInstance();
		//通过SaxParserFactory实例获取SaxParser实例
		SAXParser sp = sf.newSAXParser();
		//创建Sax默认的handler,此handler继承于DefaultHandler
		SaxHandler handler = new SaxHandler();
		sp.parse("file\\book.xml", handler);
		List<Book> bookList = handler.getBookList();
		for (Book object : bookList) {
			System.out.println(object);
		}
	}
}
