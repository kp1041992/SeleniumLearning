package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j {

	private static Logger logger = LogManager.getLogger(Log4j.class);
	public static void main(String[] args) {
		
		System.out.println("Hello Log4j");
		logger.trace("This is a trace message");
		logger.error("This is a error message");
		logger.fatal("This is a fatal message");
		logger.warn("This is a warn message");
		logger.info("This is a info message");
		
		
		System.out.println("Completed");
	}

}
