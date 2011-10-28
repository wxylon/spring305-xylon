package com.xylon.propertyEditor.spring;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("PersonEditor.xml", Test.class);
        ApplicationContext context;
		try {
			context = new FileSystemXmlApplicationContext(resource.getFile().getPath());
	        Company c=(Company)context.getBean("company");
	        c=(Company)context.getBean("company");
	        System.out.println(c.getDirector().getName()+"*"+c.getDirector().getAge());
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
