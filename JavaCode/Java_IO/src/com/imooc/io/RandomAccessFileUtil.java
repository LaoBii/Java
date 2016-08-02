package com.imooc.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * RandomAccessFile文件操作类的使用,他有2种读写方式,一种是rw(读写), 另一种是r(只读)
 * RandomAccessFile.write()方法,一次只能写入一个字节,例如int类型则要写4次
  * @title RandomAccessFileUtil
  * @author Administrator
  * @date 2016年8月1日 下午9:55:20
 */
public class RandomAccessFileUtil {
	private RandomAccessFile raf ;
	public RandomAccessFileUtil(){
		
	}
	
	/**
	 * RandomAccessFile工具类,实现对文件的读写
	 * @param file
	 * @param opsModel
	 * @throws IOException
	 */
	public void randomAccessWrite(File file, String opsModel)throws IOException{
		raf = new RandomAccessFile(file, opsModel);
		System.out.println(raf.getFilePointer());
		//一个int类型数字需要写入四次
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
