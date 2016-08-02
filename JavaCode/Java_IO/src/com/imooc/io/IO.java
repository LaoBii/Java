package com.imooc.io;

import java.io.File;
import java.io.IOException;

import sun.reflect.*;

/**
 * 
  * @title IO
  * @author Administrator
  * @date 2016年8月1日 下午9:13:13
 */
public class IO {
	public static void main(String[] args)throws IOException, ClassNotFoundException {
		FileUtils util = new FileUtils();
		File file = util.createFile("imooc","IO.txt");
		
		/*RandomAccessFileUtil rafUtil = new RandomAccessFileUtil();
		rafUtil.randomAccessWrite(file, "rw");*/
		//序列化对象
		ObjectStreamUtils osu = new ObjectStreamUtils();
		osu.serializableObjToIO(file);
		
		//反序列化对象
		@SuppressWarnings("unused")
		Object obj = osu.serializableIOToObj(file);
		/*InputStreamUtils isu = new InputStreamUtils();
		isu.printHex(file);
		isu.printHexByByteArray(file);*/
		
		
	}
}
