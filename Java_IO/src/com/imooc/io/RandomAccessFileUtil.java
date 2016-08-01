package com.imooc.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * RandomAccessFile�ļ��������ʹ��,����2�ֶ�д��ʽ,һ����rw(��д), ��һ����r(ֻ��)
 * RandomAccessFile.write()����,һ��ֻ��д��һ���ֽ�,����int������Ҫд4��
  * @title RandomAccessFileUtil
  * @author Administrator
  * @date 2016��8��1�� ����9:55:20
 */
public class RandomAccessFileUtil {
	private RandomAccessFile raf ;
	public RandomAccessFileUtil(){
		
	}
	
	/**
	 * RandomAccessFile������,ʵ�ֶ��ļ��Ķ�д
	 * @param file
	 * @param opsModel
	 * @throws IOException
	 */
	public void randomAccessWrite(File file, String opsModel)throws IOException{
		raf = new RandomAccessFile(file, opsModel);
		System.out.println(raf.getFilePointer());
		//һ��int����������Ҫд���Ĵ�
		raf.write(1 >>> 24);
		raf.write(1 >>> 16);
		raf.write(1 >>> 8);
		raf.write(1);
		raf.writeInt(1);
		System.out.println(raf.getFilePointer());
	
		byte[] bytes = new byte[(int) raf.length()];
		int k ;
		raf.seek(0);
		while((k = raf.read(bytes)) != -1){
			
		}
		System.out.println(Arrays.toString(bytes));
		raf.close();
	}
}
