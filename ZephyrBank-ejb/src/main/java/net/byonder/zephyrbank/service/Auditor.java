package net.byonder.zephyrbank.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Auditor voor het bij houden van Usage Logs.
 * 
 * @author jvdgriendt
 *
 */
public class Auditor {

	private static final String LOGFILE_LOCATION = "/home/jvdgriendt/usage_zephyr_bank.log";
	
	@AroundInvoke
	public Object logMethodCalls(final InvocationContext context) throws Exception{
		File file = new File(LOGFILE_LOCATION);
		FileOutputStream fos = new FileOutputStream(file, true);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		try{
			String usageRegel = String.format("[Type: %s, Class: %s, Method: %s, Timestamp: [%4$te-%4$tm-%4$tY %4$tT %4$tZ]]%n", context.getClass().getSimpleName(), context.getTarget().getClass().getSimpleName(), context.getMethod().getName(), new Date());			
			bos.write(usageRegel.getBytes());
			
			return context.proceed();
		} finally {
			bos.close();
			fos.close();
		}
	}
}
