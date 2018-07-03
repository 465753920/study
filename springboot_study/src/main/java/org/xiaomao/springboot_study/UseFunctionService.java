package org.xiaomao.springboot_study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UseFunctionService {

	@Autowired
	FunctionService functionService;

	public String sayHello(String word){
		return functionService.sayHello(word);
	}
}
