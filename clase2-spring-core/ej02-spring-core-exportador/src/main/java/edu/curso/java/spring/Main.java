package edu.curso.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.curso.java.spring.service.Exportador;

public class Main {

	public static void main(String[] args) {

		Persona persona = new Persona("Victoria", 37, "Lugones 4402");
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(SpringConfigurador.class);
		applicationContext.refresh();
		GeneradorDeDocumento generadorDeDocumento = (GeneradorDeDocumento) applicationContext
				.getBean("generadorDeDocumento");
		generadorDeDocumento.exportarDatos(persona);
		
	}
}
