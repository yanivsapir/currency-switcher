package main.java.il.ac.shenkar.scaleCurrencies;

import il.ac.shenkar.scaleCurrencies.GuiInit;
import main.java.il.ac.shenkar.scaleCurrencies.utills.ClassLogger;

import java.io.File;

/**
 *
 * @author Golan Sabo and Yaniv Sapir
 *
 */
public class AppInit {
	/**
	 * Main app
	 * @param args
	 */
	public static void main(String[] args) {

		File logFile = new File("./Currencies-ScalaRunLog.log");
		if(logFile.exists())
			logFile.delete();

		ClassLogger cl = new ClassLogger("AppInit");

		cl.info("Previous log file was removed...");
		cl.info("Starting App...");
		GuiInit model=new GuiInit();
		cl.info("App is ready...");
	}
}