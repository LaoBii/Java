package com.imooc.io;

import java.io.File;
import java.io.IOException;

import sun.reflect.*;

/**
 * 
  * @title IO
  * @author Administrator
  * @date 2016��8��1�� ����9:13:13
 */
public class IO {
	public static void main(String[] args)throws IOException, ClassNotFoundException {
		FileUtils util = new FileUtils();
		File file = util.createFile("imooc","IO.txt");
		
		/*RandomAccessFileUtil rafUtil = new RandomAccessFileUtil();
		rafUtil.randomAccessWrite(file, "rw");*/
		//���л�����
		ObjectStreamUtils osu = new ObjectStreamUtils();
		osu.serializableObjToIO(file);
		
		//�����л�����
		@SuppressWarnings("unused")
		Object obj = osu.serializableIOToObj(file);
		/*InputStreamUtils isu = new InputStreamUtils();
		isu.printHex(file);
		isu.printHexByByteArray(file);*/
		
		
	}
}
