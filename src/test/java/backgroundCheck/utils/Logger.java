package backgroundCheck.utils;

import org.apache.log4j.BasicConfigurator;

/**
 * Logger library various implementations
 * 
 * @author Rodrigo Moran
 *
 */
public class Logger {
	
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class);

	/**
	 * Do Logger configuration reset
	 * Do Logger configuration
	 * Log message
	 */
	public static void logStep(String message) {
		BasicConfigurator.resetConfiguration();
		BasicConfigurator.configure();
		logger.info(message);
	}
	
	/**
	 * Do Logger configuration reset
	 * Do Logger configuration
	 * Log formatted message
	 */
	public static void comparingLogStep(String actual, String expected) {
		BasicConfigurator.resetConfiguration();
		BasicConfigurator.configure();
		logger.info(String.format("Comparing [%s] to [%s]", actual, expected));
	}
	
	/**
	 * Do Logger configuration reset
	 * Do Logger configuration
	 * Log formatted message
	 */
	public static void comparingLogStep(boolean actual, boolean expected) {
		BasicConfigurator.resetConfiguration();
		BasicConfigurator.configure();
		logger.info(String.format("Comparing [%s] to [%s]", actual, expected));
	}
	
}
