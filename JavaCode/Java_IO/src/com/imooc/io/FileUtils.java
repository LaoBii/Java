package com.imooc.io;

import java.io.File;
import java.io.IOException;

public class FileUtils {
	/**
	 * 列出制定目录下的所有文件及目录(一级)
	 * @throws IOException
	 */
	public void listOneDirectory(File dir) throws IOException{
		if(!dir.exists())
			throw new IllegalArgumentException("目录:"+dir+"不存在");
		if(!dir.isDirectory())
			throw new IllegalArgumentException(dir + "不是有效目录");
		String[] names = dir.list();
		for (String string : names) {
			System.out.println(string);
		}
	}
	
	/**
	 * 列出文件下的所有文件及目录
	 * @param dir
	 * @throws IOException
	 */
	public void listAllDirectory(File dir)throws IOException {
		if(!dir.exists())
			throw new IllegalArgumentException("目录:"+dir+"不存在");
		if(!dir.isDirectory())
			throw new IllegalArgumentException(dir + "不是有效目录");
		File[] files = dir.listFiles();
		for (File file : files) {
			if(!file.isFile())
				listAllDirectory(file);
			else
				System.out.println(file);
		}
			
	}
	
	/**
	 * 创建File对象
	 * @return
	 * @throws IOException
	 */
	public File createFile(String path, String fileName) throws IOException{
		File file = new File(path, fileName);
		//如果文件存在,则直接返回
		if(file.exists()) {
			file.delete();
			file.createNewFile();			
			return file;
		}
		//如果文件不存在,则创建目录
		if(!file.isDirectory())
			file.mkdirs();
		//如果不是文件类型,则删除非文件类型目录且新建文件
		if(!file.isFile()) {
			file.delete();
			file.createNewFile();
		}
		return file;
	}
}
