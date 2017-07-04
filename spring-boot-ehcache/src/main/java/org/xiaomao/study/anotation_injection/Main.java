package org.xiaomao.study.anotation_injection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);

		UseFunctionService ufs = context.getBean(UseFunctionService.class);

		ufs.sayHello();

	}

}
