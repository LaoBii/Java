package com.imooc.xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.imooc.xml.dom.DomCompiler;
import com.imooc.xml.sax.SaxCompiler;

public class XmlCompile {
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		System.out.println("dom����-----------------");
		DomCompiler dc = new DomCompiler();
		dc.domCompile();
		System.out.println("sax����-----------------");
		SaxCompiler sc = new SaxCompiler();
		sc.saxCompiler();
	}
}
