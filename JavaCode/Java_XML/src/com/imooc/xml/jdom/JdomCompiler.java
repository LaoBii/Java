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
 * Jdom方式解析
  * @title JdomCompiler
  * @author Administrator
  * @date 2016年8月2日 下午10:33:07
 */
public class JdomCompiler {
	
	public void createXml() throws IOException{
		Document document = new Document(new Element("bookstore"));
		Element rootElement = document.getRootElement();
		Element book = new Element("book");
		book.setAttribute("id", "1");
		rootElement.addContent(book);
		Element name = new Element("name");
		CDATA cd = new CDATA("<书籍1");
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
		//获取根节点
		Element rootEle = doc.getRootElement();
		List<Element> bookList = rootEle.getChildren();
		
		for (Element book : bookList) {
			System.out.println("开始遍历第" + (bookList.indexOf(book)+1) + "本书");
			List<Attribute> attributes = book.getAttributes();
			for (Attribute attribute : attributes) {
				String name = attribute.getName();
				String value = attribute.getValue();
				System.out.println("第" + (attributes.indexOf(attribute) + 1) + "个属性名:" + name + "属性值:" + value);
			}
			List<Element> childrenList = book.getChildren();
			for (Element element : childrenList) {
				System.out.println("节点名:" + element.getName() + "节点值:" + element.getValue());
			}
			System.out.println("结束遍历第" + (bookList.indexOf(book)+1) + "本书");
			System.out.println();
		}
	}
}
