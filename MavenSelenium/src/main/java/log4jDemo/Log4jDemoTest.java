package log4jDemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemoTest {
	
	private static Logger logger = LogManager.getLogger(Log4jDemoTest.class);
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\n Hello World..! \n");
		logger.info("This is a information message");
		logger.error("This is an error message");
		logger.warn("This is warning message");
		logger.fatal("This is a fatal message");
		
		System.out.println("\n Completed");

	}

}
