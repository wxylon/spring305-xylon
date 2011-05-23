package com.xylon.ioc;

public class HelloImpl implements IHello {

	private String msg;
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void sayHi() {
		System.out.println("Hello World!---> " + msg);
	}

}
