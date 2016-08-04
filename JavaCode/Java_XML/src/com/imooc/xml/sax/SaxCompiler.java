package com.imooc.xml.sax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import com.imooc.xml.Book;

/**
 * Sax解析
 * 原理:sax会创建一个Handler进行逐行顺序解析
  * @title SaxCompiler
  * @author Administrator
  * @date 2016年8月2日 下午9:47:49
 */
public class SaxCompiler {
	private List<Book> bookList ;
	public void saxCompiler() throws ParserConfigurationException, SAXException, IOException {
		//首先通过SAXParserFactory创建实例
		SAXParserFactory sf = SAXParserFactory.newInstance();
		//通过SaxParserFactory实例获取SaxParser实例
		SAXParser sp = sf.newSAXParser();
		//创建Sax默认的handler,此handler继承于DefaultHandler
		SaxHandler handler = new SaxHandler();
		sp.parse("file\\book.xml", handler);
		bookList = handler.getBookList();
		for (Book object : bookList) {
			System.out.println(object);
		}
	}
	
	/**
	 * Sax创建xml
	 * @throws TransformerConfigurationException
	 * @throws FileNotFoundException
	 * @throws SAXException
	 */
	public void createXml() throws TransformerConfigurationException, FileNotFoundException, SAXException {
		SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory.newInstance(); 
		TransformerHandler handler = tff.newTransformerHandler();
		Transformer tf = handler.getTransformer();
		//设置编码
		tf.setOutputProperty(OutputKeys.ENCODING,	"UTF-8");
		//设置是否换行
		tf.setOutputProperty(OutputKeys.INDENT,	 "yes");
		
		Result sr = new StreamResult(new FileOutputStream(new File("file\\bookSax.xml")));
		handler.setResult(sr);
		handler.startDocument();
		AttributesImpl attr = new AttributesImpl();
		handler.startElement("", "", "bookstore", attr);
		for (Book book : bookList) {
			attr.clear();
			attr.addAttribute("", "", "id", "", book.getId());
			handler.startElement("", "", "book", attr);
			attr.clear();
			handler.startElement("", "", "name", attr);
			handler.characters(book.getName().toCharArray(), 0, book.getName().length());
			handler.endElement("", "", "name");
			handler.endElement("", "", "book");
		}
		handler.endElement("", "", "bookstore");
		handler.endDocument();
	}
}
