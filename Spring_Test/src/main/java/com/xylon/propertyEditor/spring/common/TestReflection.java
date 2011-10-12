package com.xylon.propertyEditor.spring.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.xylon.propertyEditor.spring.Person;

public class TestReflection {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			
			Class cls = Class.forName("com.xylon.propertyEditor.spring.Person");
			Method mtd = cls.getMethod("setAll",new Class[]{String.class, int.class});
			Object obj = (Object)cls.newInstance();
			mtd.invoke(obj,new Object[]{"²âÊÔ",1});
			System.out.println(((Person)obj).getName());
			System.out.println(((Person)obj).getAge());
			
			Method setName = cls.getMethod("setName",String.class);
			setName.invoke(obj,"ÍÛ¹þ¹þ");
			System.out.println(((Person)obj).getName());
			System.out.println(((Person)obj).getAge());
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
