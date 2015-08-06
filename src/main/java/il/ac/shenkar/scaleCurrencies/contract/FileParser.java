package main.java.il.ac.shenkar.scaleCurrencies.contract;

import main.scala.il.ac.shenkar.scaleCurrencies.model.Coin;
import scala.xml.Elem;

import java.util.HashMap;

/**
 * @author Golan Sabo and Yaniv Sapir
 */
public interface FileParser {
	/**
	 * interface for Coin parsing from a file
	 */
	/**
	 * checks if the file available
	 */
	public Elem loadFile();

	public HashMap<String,Coin> parseFile();

}
