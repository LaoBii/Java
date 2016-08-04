package com.imooc.xml.jdom;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * Jdom��ʽ����
  * @title JdomCompiler
  * @author Administrator
  * @date 2016��8��2�� ����10:33:07
 */
public class JdomCompiler {
	
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
