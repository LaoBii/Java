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
 * Dom方式解析,解析会把这个xml加载到内存中解析
  * @title DomCompiler
  * @author Administrator
  * @date 2016年8月2日 下午9:46:59
 */
public class DomCompiler {
	/**
	 * Dom 方式解析
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void domCompile() throws SAXException, IOException, ParserConfigurationException {
		//创建一个DocumentBuilderFactory的对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//创建一个DocumentBuilder对象
		DocumentBuilder db = dbf.newDocumentBuilder();
		//创建Document对象
		Document doc = db.parse(new File("file\\book.xml"));
		//获取所有的book节点
		NodeList bookNodes = doc.getElementsByTagName("book");
		
		//遍历属性
		{
			/**
			 * Type 1
			 * 不知道属性名的情况下一个个的遍历
			 */
			/*for (int i = 0; i < bookNodes.getLength(); i++) {
			Node book = bookNodes.item(i);
			if(null != book) {
				//获取book节点中的所有属性
				NamedNodeMap attrs = book.getAttributes();
				for (int j = 0; j < attrs.getLength(); j++) {
					//获取属性
					Node item = attrs.item(j);
					String name = item.getNodeName();
					String value = item.getNodeValue();
					System.out.println("第" + (i+1) + "本书第" + (j+1) + "个属性名:" + name + ",属性值:" + value);
				}
			} else {
				continue;
			}
		}*/
			
			/**
			 * Type 2
			 * 知道属性名的情况下进行遍历
			 */
			for (int i = 0; i < bookNodes.getLength(); i++) {
				Element book = (Element)bookNodes.item(i);
				String value = book.getAttribute("id");
				System.out.println("第" + (i+1) + "本书的属性id为:" + value);
			}
		}
		
		//遍历子节点
		{
			for (int i = 0; i < bookNodes.getLength(); i++) {
				Node book = bookNodes.item(i);
				NodeList childNodes = book.getChildNodes();
				for (int j = 0; j < childNodes.getLength(); j++) {
					Node node = childNodes.item(j);
					if(node.getNodeType() == Node.ELEMENT_NODE) {
						String nodeName = node.getNodeName();
						//String nodeValue = node.getNodeValue(); Element类型节点的nodeValue为null,所以不能使用这个方法获取值
						/**
						 * 应当通过node.getFirstChild().getNodeValue()来获取值,
						 * 或者使用node.getTextContend()
						 * 注意两种方式的区别
						 *  解析器会默认把节点里面的内容当做这个节点的子节点
						 */
						String nodeValue = node.getFirstChild().getNodeValue();//node.getTextContent();
						System.out.println("book子节点名称:" + nodeName + ",值:" + nodeValue);
					}
				}
			}
		}
	}
}
