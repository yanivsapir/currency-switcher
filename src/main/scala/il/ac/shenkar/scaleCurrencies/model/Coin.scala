package main.scala.il.ac.shenkar.scaleCurrencies.model

import main.java.il.ac.shenkar.scaleCurrencies.utills.ClassLogger

/**
 * @author Golan 
 */
class Coin(coinName:String,unit:String, currencyCode:String, country:String, rate:String,change:String){
  val cl: ClassLogger = new ClassLogger("Coin")
 // protected [Coin]

  /**
   * prepares coin object data to the Currencies Table
   * @return
   */
  def toTable():Array[String]=
  {
    var str:Array[String]=new Array[String](6)
    str(0)=this.country
    str(1)=this.coinName
    str(2)=this.unit
    str(3)=this.currencyCode
    str(4)=this.rate
    str(5)=this.change
    str
  }
  def getCountry():String=
  {
    this.country
  }
  def getRate():Double=
  {
    rate.toDouble
  }
  def getUnit():Int=
  {
    unit.toInt
  }

  def getName():String=
  {
    coinName
  }

  /**
   * calculates the ration of the conversion from one coin to another
   * @param to
   * @return
   */
  def calculateCurrencies(to:Coin):Double=
  {
    cl.info("The ratio between " + country + " " + coinName + " and " + to.getCountry() + " " + to.getName()
      + " is: " + (to.getRate/to.getUnit)/(getRate/getUnit))
    (to.getRate/to.getUnit)/(getRate/getUnit)
  }
}