package com.imooc.io;

import java.io.File;
import java.io.IOException;

public class FileUtils {
	/**
	 * �г��ƶ�Ŀ¼�µ������ļ���Ŀ¼(һ��)
	 * @throws IOException
	 */
	public void listOneDirectory(File dir) throws IOException{
		if(!dir.exists())
			throw new IllegalArgumentException("Ŀ¼:"+dir+"������");
		if(!dir.isDirectory())
			throw new IllegalArgumentException(dir + "������ЧĿ¼");
		String[] names = dir.list();
		for (String string : names) {
			System.out.println(string);
		}
	}
	
	/**
	 * �г��ļ��µ������ļ���Ŀ¼
	 * @param dir
	 * @throws IOException
	 */
	public void listAllDirectory(File dir)throws IOException {
		if(!dir.exists())
			throw new IllegalArgumentException("Ŀ¼:"+dir+"������");
		if(!dir.isDirectory())
			throw new IllegalArgumentException(dir + "������ЧĿ¼");
		File[] files = dir.listFiles();
		for (File file : files) {
			if(!file.isFile())
				listAllDirectory(file);
			else
				System.out.println(file);
		}
			
	}
	
	/**
	 * ����File����
	 * @return
	 * @throws IOException
	 */
	public File createFile(String path, String fileName) throws IOException{
		File file = new File(path, fileName);
		//����ļ�����,��ֱ�ӷ���
		if(file.exists()) {
			file.delete();
			file.createNewFile();			
			return file;
		}
		//����ļ�������,�򴴽�Ŀ¼
		if(!file.isDirectory())
			file.mkdirs();
		//��������ļ�����,��ɾ�����ļ�����Ŀ¼���½��ļ�
		if(!file.isFile()) {
			file.delete();
			file.createNewFile();
		}
		return file;
	}
}
