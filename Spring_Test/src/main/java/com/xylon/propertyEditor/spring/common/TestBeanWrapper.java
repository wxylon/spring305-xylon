package com.xylon.propertyEditor.spring.common;

import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.util.Date;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;

import com.xylon.propertyEditor.DatePropertyEditor;
import com.xylon.propertyEditor.spring.Company;
import com.xylon.propertyEditor.spring.Person;
import com.xylon.propertyEditor.spring.PersonEditor;

public class TestBeanWrapper {

	public static void main(String[] args) {
		try {
			Object obj = Class.forName("com.xylon.propertyEditor.spring.Company").newInstance();
			BeanWrapper bw = new BeanWrapperImpl(obj);
			bw.registerCustomEditor(Date.class, new DatePropertyEditor());
			bw.setPropertyValue("director", "gaoxiang-26");
			System.out.println("name=>" + bw.getPropertyValue("director.name").toString());
			System.out.println(" age=>" + bw.getPropertyValue("director.age").toString());
			
			System.out.println("name=>" + ((Company)obj).getDirector().getName());
			System.out.println(" age=>" + ((Company)obj).getDirector().getAge());
		
			
//			String[] pes = PropertyEditorManager.getEditorSearchPath();
//			for(String s : pes){
//				System.out.println(s);
//			}
//			
//			PropertyDescriptor[] pds = bw.getPropertyDescriptors();
//			for(PropertyDescriptor pd : pds){
//				System.out.println(pd.getClass().getName());
//			}
		
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
}
