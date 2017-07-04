package org.xiaomao.study.anotation_injection;

import org.springframework.stereotype.Service;

@Service
public class FunctionService {

	public void sayHello() {
		System.out.println("hello");
	}

}
