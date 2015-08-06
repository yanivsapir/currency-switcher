package main.java.il.ac.shenkar.scaleCurrencies.contract;

import main.scala.il.ac.shenkar.scaleCurrencies.model.Coin;

/**
 * 
 * @author Golan Sabo and Yaniv Sapir
 *
 */
public interface UpdateData {
	/**
	 * interface for updating data for gui
	 */
	public void updateData(Coin[] coin,String[][] data);
}
