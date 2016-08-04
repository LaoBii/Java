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
 * Sax����
 * ԭ��:sax�ᴴ��һ��Handler��������˳�����
  * @title SaxCompiler
  * @author Administrator
  * @date 2016��8��2�� ����9:47:49
 */
public class SaxCompiler {
	private List<Book> bookList ;
	public void saxCompiler() throws ParserConfigurationException, SAXException, IOException {
		//����ͨ��SAXParserFactory����ʵ��
		SAXParserFactory sf = SAXParserFactory.newInstance();
		//ͨ��SaxParserFactoryʵ����ȡSaxParserʵ��
		SAXParser sp = sf.newSAXParser();
		//����SaxĬ�ϵ�handler,��handler�̳���DefaultHandler
		SaxHandler handler = new SaxHandler();
		sp.parse("file\\book.xml", handler);
		bookList = handler.getBookList();
		for (Book object : bookList) {
			System.out.println(object);
		}
	}
	
	/**
	 * Sax����xml
	 * @throws TransformerConfigurationException
	 * @throws FileNotFoundException
	 * @throws SAXException
	 */
	public void createXml() throws TransformerConfigurationException, FileNotFoundException, SAXException {
		SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory.newInstance(); 
		TransformerHandler handler = tff.newTransformerHandler();
		Transformer tf = handler.getTransformer();
		//���ñ���
		tf.setOutputProperty(OutputKeys.ENCODING,	"UTF-8");
		//�����Ƿ���
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
