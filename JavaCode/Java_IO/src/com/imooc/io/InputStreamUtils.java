package com.imooc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamUtils {
	/**
	 * 读取文件内容,按照16进制输出到控制台
	 * 单字节读取小文件是比批量读取效率要高
	 * @param fileName
	 * @throws IOException
	 */
	public void printHex(File fileName)throws IOException{
		FileInputStream in = new FileInputStream(fileName);
		int index;
		int count = 1;
		while((index = in.read()) != -1){
			if(index <= 0x7f)
				System.out.print("0");
			System.out.print(Integer.toBinaryString(index) + "   ");
			if(count%10==0)
				System.out.println();
			count++;
		}
		in.close();
	}
	
	/**
	 * 批量读取大型文件是效率会比单字节好
	 * @param file
	 * @throws IOException
	 */
	public void printHexByByteArray(File file)throws IOException {
		FileInputStream in = new FileInputStream(file);
		
		/**
		 * 从in中批量读取字节数,放入到buf的字节数组中
		 * ,从第0个位置开始,总共读取buf.length个
		 * 返回值为读取到的位置
		 * 此读法可能会出现1,读取的个数<buf.length 2.读取的个数>buf.length
		 */
		byte[] buf = new byte[5];
		int point ;
		while((point = in.read(buf, 0, buf.length)) != -1) {
			for (int i = 0; i < point; i++) {
				if(buf[i]>0x0) {
					if(buf[i] <= 0x7f)
						System.out.print("0");
					System.out.print(Integer.toBinaryString(buf[i]) + "   ");
				}
				if((i+1)%5 == 0) 
					System.out.println();
			}
		}
		
//		int start = 0;
//		while(start != -1) {
//			start = read(in, start);
//		}
		in.close();
	}
	
	public int read(FileInputStream in, int start)throws IOException {
		byte[] buf = new byte[5];
		int length = buf.length;
		if(length > in.getChannel().size() - start) {
			length = (int)in.getChannel().size() - buf.length;
		}
		int readPoint = in.read(buf, 0,length);
		for (byte b : buf) {
			if(b>0x0) {
				if(b <= 0x7f)
					System.out.print("0");
				System.out.print(Integer.toBinaryString(b) + "   ");
			}
		}
		System.out.println();
		return readPoint;
	}
}
