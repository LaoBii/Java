package com.imooc.xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.dom4j.DocumentException;
import org.jdom.JDOMException;
import org.xml.sax.SAXException;

import com.imooc.xml.dom.DomCompiler;
import com.imooc.xml.dom4j.Dom4jCompiler;
import com.imooc.xml.jdom.JdomCompiler;
import com.imooc.xml.sax.SaxCompiler;

public class XmlCompile {
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, JDOMException, DocumentException, TransformerException {
		/*long start_dc = System.currentTimeMillis();
		System.out.println("dom解析-----------------");
		DomCompiler dc = new DomCompiler();
		//解析xml
		dc.domCompile();
		//创建xml
		dc.createDocByObject();
		long end_dc = System.currentTimeMillis();
		System.out.println(start_dc-end_dc);//耗时28*/
		
		/*long start_sc = System.currentTimeMillis();
		System.out.println("sax解析-----------------");
		SaxCompiler sc = new SaxCompiler();
		sc.saxCompiler();
		sc.createXml();
		long end_sc = System.currentTimeMillis();
		System.out.println(start_sc-end_sc);//耗时6*/
		
		long start_jc = System.currentTimeMillis();
		JdomCompiler jc = new JdomCompiler();
//		jc.jdomCompiler();
		jc.createXml();
		long end_jc = System.currentTimeMillis();
		System.out.println(start_jc-end_jc);//耗时32
		
		/*long start_d4c = System.currentTimeMillis();
		Dom4jCompiler d4c = new Dom4jCompiler();
//		d4c.dom4JCompiler();
		d4c.createXMl();
		long end_d4c = System.currentTimeMillis();
		System.out.println(start_d4c-end_d4c);//耗时30*/
	}
}
