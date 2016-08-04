package com.imooc.xml.jdom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.CDATA;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.EscapeStrategy;
import org.jdom.output.Format;
import org.jdom.output.Format.TextMode;
import org.jdom.output.XMLOutputter;

/**
 * Jdom��ʽ����
  * @title JdomCompiler
  * @author Administrator
  * @date 2016��8��2�� ����10:33:07
 */
public class JdomCompiler {
	
	public void createXml() throws IOException{
		Document document = new Document(new Element("bookstore"));
		Element rootElement = document.getRootElement();
		Element book = new Element("book");
		book.setAttribute("id", "1");
		rootElement.addContent(book);
		Element name = new Element("name");
		CDATA cd = new CDATA("<�鼮1");
		name.addContent(cd);
		book.addContent(name);
//		rootElement.
		
		XMLOutputter outputer = new XMLOutputter();
		Format f = Format.getCompactFormat();
		f.setIndent("");
		f.setIgnoreTrAXEscapingPIs(true);
		outputer.setFormat(f);
		
		outputer.output(document, new FileOutputStream(new File("file\\jdombook.xml")));
	}
	
	public void jdomCompiler() throws JDOMException, IOException {
		SAXBuilder sb = new SAXBuilder();
		Document doc = sb.build(new File("file\\book.xml"));
		//��ȡ���ڵ�
		Element rootEle = doc.getRootElement();
		List<Element> bookList = rootEle.getChildren();
		
		for (Element book : bookList) {
			System.out.println("��ʼ������" + (bookList.indexOf(book)+1) + "����");
			List<Attribute> attributes = book.getAttributes();
			for (Attribute attribute : attributes) {
				String name = attribute.getName();
				String value = attribute.getValue();
				System.out.println("��" + (attributes.indexOf(attribute) + 1) + "��������:" + name + "����ֵ:" + value);
			}
			List<Element> childrenList = book.getChildren();
			for (Element element : childrenList) {
				System.out.println("�ڵ���:" + element.getName() + "�ڵ�ֵ:" + element.getValue());
			}
			System.out.println("����������" + (bookList.indexOf(book)+1) + "����");
			System.out.println();
		}
	}
}
