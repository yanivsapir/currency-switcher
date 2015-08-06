package main.scala.il.ac.shenkar.scaleCurrencies.utills

import java.util.HashMap;
import java.util.Set;

import main.java.il.ac.shenkar.scaleCurrencies.utills.ClassLogger
import main.scala.il.ac.shenkar.scaleCurrencies.model.Coin

/**
 * @author ysapir
 */
class DataAdaptor {
  val cl: ClassLogger = new ClassLogger("DataAdaptor")
  /**
   * extracts the countries name from a Coin array into String array
   * and returns it sorted by name. 
   * @param Coin[] coin
   * @return String[] countries
   */
  def getCountriesFromFile(coins: HashMap[String, Coin]): Array[String] =
  {
    cl.info("Building Countries array...")
    var countries: Array[String] = coins.keySet().toArray(new Array[String](coins.size))

    scala.util.Sorting.quickSort(countries)
    cl.info("Countries array was built")
    countries;
  }
  /**
   * get the data of the coins from the Coin array
   * and returns the data suitable for table
   * @param coin
   * @return String[][] data
   */
  def getCoinsDataFromFile(coins:HashMap[String, Coin]): Array[Array[String]] =
  {
    cl.info("Building coins data...")
    var data: Array[Array[String]] = new Array[Array[String]](coins.size())
    var i = 0
    var keys: Array[String] = coins.keySet().toArray(new Array[String](coins.size))
    for(key <- keys) {
      data(i) = coins.get(key).toTable()
      i = i + 1
    }
    cl.info("Coins Data was built")
    data
  }
}