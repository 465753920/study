package org.xiaomao.study.anotation_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunctionService {

	@Autowired
	private FunctionService fs;

	public void sayHello() {
		fs.sayHello();
	}

}
