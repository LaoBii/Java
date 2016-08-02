package com.imooc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * <p>Title:ObjectInputStreamUtils </p>
 * <p>Description:序列化对象 </p>
 * @author liubing
 * @date 2016年8月2日 上午11:54:02
 */
public class ObjectStreamUtils {
	/**
	 * 从IO流中读取被序列化的对象
	 * @param file
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Object serializableIOToObj(File file)throws IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(file));
		
		Object obj = ois.readObject();
		System.out.println(obj);
		ois.close();
		return obj;
	}
	
	/**
	 * 将对象序列化成流，持久化存入文件
	 * @param file
	 * @throws IOException
	 */
	public void serializableObjToIO(File file)throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(file));
		
//		oos.writeObject(new ObjectSerializabal("Tom", true ,13));
//		oos.writeObject(new ObjectSerializabal("Shaly", false ,14));
		oos.writeObject(new SonOfObjectSerializabal());
		oos.close();
	}
}
