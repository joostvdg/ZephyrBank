package net.byonder.zephyrbank.service;

import java.io.File;

import javax.interceptor.InvocationContext;

public class Auditor {

	private static final String LOGFILE_LOCATION = "/home/jvdgriendt";
	
	public Object logMethodCalls(final InvocationContext context){
		File file = new File(LOGFILE_LOCATION);
		
		
		return context.proceed();
	}
}
