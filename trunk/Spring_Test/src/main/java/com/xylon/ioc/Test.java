package com.xylon.ioc;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {
	
	public static void main(String[] args) {
		
		//LOG4J
		PropertyConfigurator.configureAndWatch("E:\\maven-work\\xylon-spring\\Spring_Test\\src\\main\\resources\\config\\log4j.properties");
		
		
		Resource resource = new ClassPathResource("spring/applicationContext.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		IHello iHello = (IHello)beanFactory.getBean("iHello");
		iHello.sayHi();
	}

}
