package com.exception;

public class GenericException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public GenericException(){
		super();
	}
		
public GenericException(String classname, String message, Throwable thr){
	
	super(classname+" : "+message,thr);
		
	}
		

public GenericException(String classname, String message){
	
	super(classname+" : "+message);
		
	}

public GenericException(String className,Throwable th){
	
	super(className,th);
		
	}
		
		



}
