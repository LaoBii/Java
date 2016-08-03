package com.imooc.xml.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Dom��ʽ����,����������xml���ص��ڴ��н���
  * @title DomCompiler
  * @author Administrator
  * @date 2016��8��2�� ����9:46:59
 */
public class DomCompiler {
	/**
	 * Dom ��ʽ����
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void domCompile() throws SAXException, IOException, ParserConfigurationException {
		//����һ��DocumentBuilderFactory�Ķ���
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//����һ��DocumentBuilder����
		DocumentBuilder db = dbf.newDocumentBuilder();
		//����Document����
		Document doc = db.parse(new File("file\\book.xml"));
		//��ȡ���е�book�ڵ�
		NodeList bookNodes = doc.getElementsByTagName("book");
		
		//��������
		{
			/**
			 * Type 1
			 * ��֪���������������һ�����ı���
			 */
			/*for (int i = 0; i < bookNodes.getLength(); i++) {
			Node book = bookNodes.item(i);
			if(null != book) {
				//��ȡbook�ڵ��е���������
				NamedNodeMap attrs = book.getAttributes();
				for (int j = 0; j < attrs.getLength(); j++) {
					//��ȡ����
					Node item = attrs.item(j);
					String name = item.getNodeName();
					String value = item.getNodeValue();
					System.out.println("��" + (i+1) + "�����" + (j+1) + "��������:" + name + ",����ֵ:" + value);
				}
			} else {
				continue;
			}
		}*/
			
			/**
			 * Type 2
			 * ֪��������������½��б���
			 */
			for (int i = 0; i < bookNodes.getLength(); i++) {
				Element book = (Element)bookNodes.item(i);
				String value = book.getAttribute("id");
				System.out.println("��" + (i+1) + "���������idΪ:" + value);
			}
		}
		
		//�����ӽڵ�
		{
			for (int i = 0; i < bookNodes.getLength(); i++) {
				Node book = bookNodes.item(i);
				NodeList childNodes = book.getChildNodes();
				for (int j = 0; j < childNodes.getLength(); j++) {
					Node node = childNodes.item(j);
					if(node.getNodeType() == Node.ELEMENT_NODE) {
						String nodeName = node.getNodeName();
						//String nodeValue = node.getNodeValue(); Element���ͽڵ��nodeValueΪnull,���Բ���ʹ�����������ȡֵ
						/**
						 * Ӧ��ͨ��node.getFirstChild().getNodeValue()����ȡֵ,
						 * ����ʹ��node.getTextContend()
						 * ע�����ַ�ʽ������
						 *  ��������Ĭ�ϰѽڵ���������ݵ�������ڵ���ӽڵ�
						 */
						String nodeValue = node.getFirstChild().getNodeValue();//node.getTextContent();
						System.out.println("book�ӽڵ�����:" + nodeName + ",ֵ:" + nodeValue);
					}
				}
			}
		}
	}
}
