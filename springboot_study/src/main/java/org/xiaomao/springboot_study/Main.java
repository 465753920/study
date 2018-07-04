package org.xiaomao.springboot_study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		UseFunctionService useFunctionService = ctx.getBean(UseFunctionService.class);
		System.out.println(useFunctionService.sayHello("Shen QiuS"));
		ctx.close();
	}
}
