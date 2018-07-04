package org.xiaomao.springboot_study;

public class UseFunctionService {

	FunctionService functionService;

	public FunctionService getFunctionService() { return functionService; }

	public void setFunctionService(FunctionService functionService) { this.functionService = functionService; }

	public String sayHello(String word){
		return functionService.sayHello(word);
	}
}
