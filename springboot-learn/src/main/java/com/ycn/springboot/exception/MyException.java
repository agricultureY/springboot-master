package com.ycn.springboot.exception;
/**
 * 自定义异常
 * 
 * @Package: com.ycn.springboot.exception
 * @author: ycn
 * @date: 2018年5月17日 下午5:32:16
 */
public class MyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyException() {
		super();
	}
	
	public MyException(String message) {
		super(message);
	}
	
}
