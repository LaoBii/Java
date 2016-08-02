package com.imooc.io;

import java.io.Serializable;

public class ObjectSerializabal extends FatOfObjectSerializabal implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String name;
	
	private boolean isFalme;
	
	private transient int age;

	public ObjectSerializabal() {
		super();
		System.out.println("ObjectSerializabal ���췽��");
	}
	
	public ObjectSerializabal(String name, boolean isFalme, int age) {
		super();
		this.name = name;
		this.isFalme = isFalme;
		this.age = age;
		System.out.println("ObjectSerializabal ���췽��");
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "ObjectSerializabal [name=" + name + ", isFalme=" + isFalme + ", age=" + age + "]";
	}

	/**
	 * Java�����Ĭ�ϵ����л��ļ��ķ���
	 * @param s
	 * @throws java.io.IOException
	 */
	private void writeObject(java.io.ObjectOutputStream s)
	        throws java.io.IOException{
		s.defaultWriteObject();
		if(isFalme)
			s.writeInt(age);
	}
	
	/**
	 * Java�����Ĭ�ϵķ����л��ļ���������Ҫʵ�ָ÷���
	 * @param s
	 * @throws java.io.IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(java.io.ObjectInputStream s)
	        throws java.io.IOException, ClassNotFoundException {
		s.defaultReadObject();
		if(isFalme)
			this.age = s.readInt();
	}
}
