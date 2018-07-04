package org.xiaomao.springboot_study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		DemoMethodService demoMethodService = ctx.getBean(DemoMethodService.class);
		demoMethodService.add();
		DemoAnnotationService demoAnnotationService = ctx.getBean(DemoAnnotationService.class);
		demoAnnotationService.add();
		ctx.close();
	}
}
