package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	private static final Logger myLog = LogManager.getLogger(Log.class.getName());

	public static void debug(String sMessage) {
		myLog.debug(sMessage);
	}
	public static void info (String sMessage) {
		myLog.info(sMessage);
	}
	public static void warn (String sMessage) {
		myLog.warn(sMessage);
	}
	public static void error (String sMessage) {
		myLog.error(sMessage);
	}
	public static void fatal (String sMessage) {
		myLog.fatal(sMessage);
	}
	public static void startTest(String sTestName){
		myLog.info("-----Start test case " + sTestName+" -----");
	}
	public static void endTest(String sTestName){
		myLog.info("-----End test case " + sTestName+" -----");
	}

	

}
