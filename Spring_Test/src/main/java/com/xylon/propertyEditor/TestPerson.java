package com.xylon.propertyEditor;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;

public class TestPerson {
	public static void test() {
		try {
			Object obj = Class.forName("com.xylon.propertyEditor.Person").newInstance();
			BeanWrapper bw = new BeanWrapperImpl(obj);
			bw.registerCustomEditor(Date.class, new DatePropertyEditor());
			bw.setPropertyValue("birthday", new Date());
			bw.setPropertyValue("date", "2011-01-01");
//			PropertyValue value = new PropertyValue("birthday", new Date());   
//			bw.setPropertyValue(value);   
//			System.out.println("User name=>" + bw.getPropertyValue("name"));
			System.out.println("User birthday=>" + bw.getPropertyValue("birthday").toString());
			System.out.println("User date=>" + bw.getPropertyValue("date").toString());
//			System.out.println("User name=>" + ((Person)obj).getBirthday());
//			System.out.println("User birthday=>" + bw.getPropertyValue("birthday"));
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		test();
	}
}
