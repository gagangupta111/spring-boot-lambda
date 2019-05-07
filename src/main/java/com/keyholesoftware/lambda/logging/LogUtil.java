package com.keyholesoftware.lambda.logging;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

public class LogUtil {
	
	public static Logger getInstance() {

		String callingClassName = Thread.currentThread().getStackTrace()[2].getClassName();
		Logger logger = Logger.getLogger(callingClassName);

		try {
			UtilsManager utilsManager = new UtilsManager();
			LogManager.getLogManager().readConfiguration(new FileInputStream(utilsManager.loadFileAndReturn("mylogging", ".properties")));
		} catch (SecurityException | IOException e1) {
			e1.printStackTrace();
			return null;
		}
		logger.setLevel(Level.FINE);
		logger.addHandler(new ConsoleHandler());
		//adding custom handler
		logger.addHandler(new MyHandler());
		try {
			//FileHandler file name with max size and number of log files limit
			Handler fileHandler = new FileHandler("/Users/gagangupta/logger.log", 800000000, 1);
			fileHandler.setFormatter(new MyFormatter());
			//setting custom filter for FileHandler
			fileHandler.setFilter(new MyFilter());
			logger.addHandler(fileHandler);
			return logger;
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}