package com.sanchezih.di.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sanchezih.di.spring.service.Converter;
import com.sanchezih.di.spring.service.impl.ARSToUSDConverter;

public class Main {

	public static void main(String[] args) {

		double cantidad = 100;
		BeanFactory applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Converter c = (Converter) applicationContext.getBean("ARSToGBPConverter");
		System.out.println(c.convert(cantidad));

	}
}
