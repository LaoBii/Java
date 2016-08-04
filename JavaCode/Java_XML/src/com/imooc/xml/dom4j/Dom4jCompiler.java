package com.imooc.xml.dom4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;


import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.jdom.input.SAXBuilder;

public class Dom4jCompiler {
	
	public void createXMl() throws IOException{
		Document doc = DocumentHelper.createDocument();
		Element bookstore = doc.addElement("bookstore");
		Element book = bookstore.addElement("book");
		book.addAttribute("id", "1");
		Element name = book.addElement("name");
		name.setText("<书籍1");
		XMLWriter xw = new XMLWriter(new FileOutputStream(new File("file\\dom4jbook.xml")));
		xw.setEscapeText(false);
		xw.write(doc);
		xw.close();
	}
	
	public void dom4JCompiler() throws DocumentException{
		//创建对象
		SAXReader sr = new SAXReader();
		Document doc = sr.read(new File("file\\book.xml"));
		Element rootEle = doc.getRootElement();
		Iterator ei = rootEle.elementIterator();
		while (ei.hasNext()) {
			Element book = (Element)ei.next();
			List<Attribute> attributes = book.attributes();
			for (Attribute attribute : attributes) {
				System.out.println("属性名" + attribute.getName() + ",属性值:" + attribute.getValue());
			}
			Iterator elementIterator = book.elementIterator();
			while (elementIterator.hasNext()) {
				Element e = (Element) elementIterator.next();
				String name = e.getName();
				String value = e.getStringValue();
				System.out.println("属性名" + name + ",属性值:" + value);
			}
		}
	}
}
