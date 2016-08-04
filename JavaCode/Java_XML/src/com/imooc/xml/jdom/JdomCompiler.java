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
 * Jdom方式解析
  * @title JdomCompiler
  * @author Administrator
  * @date 2016年8月2日 下午10:33:07
 */
public class JdomCompiler {
	
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
