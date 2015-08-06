package main.java.il.ac.shenkar.scaleCurrencies.utills;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Date;

public class ClassLogger {

	private String className;
	static Logger logger;
	
	public ClassLogger(String className){
		
		this.className = "ClassLogger";
		logger = Logger.getLogger(className);
		PropertyConfigurator.configure("src/main/resources/Log4j.properties");
		info("new Logger for class:\t\"" + className + "\"");
		this.className = className;
	}

	/**
	 * logs Info messages
	 * @param msg
	 */
	public void info(String msg){
		this.logger.info(new Date() +"\t" + this.className
				+ ":[INFO]("+ Thread.currentThread().getStackTrace()[2].getLineNumber()
				+"):\t\t" + msg);
	}


	/**
	 * logs debug messages
	 * @param msg
	 */
	public void debug(String msg) {
		this.logger.debug(new Date() + "\t" + this.className
				+ ":[DEBUG](" + Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ "):\t\t" + msg);
	}


	/**
	 * logs error messages
	 * @param msg
	 */
	public void error(String msg){
		this.logger.error(new Date() + "\t" + this.className
				+ ":[ERROR](" + Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ "):\t\t" + msg);
	}
}
