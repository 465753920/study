package org.xiaomao.springboot_study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.xiaomao.springboot_study")
@EnableAspectJAutoProxy
public class Config {

	@Bean
	public FunctionService functionService(){
		return new FunctionService();
	}

//	@Bean
//	public UseFunctionService useFunctionService(){
//		UseFunctionService useFunctionService = new UseFunctionService();
//		useFunctionService.setFunctionService(functionService());
//		return useFunctionService;
//	}

	@Bean
	public UseFunctionService useFunctionService(FunctionService functionService){
		UseFunctionService useFunctionService = new UseFunctionService();
		useFunctionService.setFunctionService(functionService);
		return useFunctionService;
	}
}
