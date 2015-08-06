package main.scala.il.ac.shenkar.scaleCurrencies.utills

import java.net._
import java.util.Date

import main.java.il.ac.shenkar.scaleCurrencies.contract.FileParser
import main.java.il.ac.shenkar.scaleCurrencies.utills.ClassLogger
import main.scala.il.ac.shenkar.scaleCurrencies.model.Coin
import java.util.HashMap
import scala.xml.{Elem, XML}

/**
 * @author Golan
 * @author Yaniv
 */
object XmlParser extends FileParser{
  val cl = new ClassLogger("XmlParser")
  private var doc:Elem=null;
  private var saveFlag:Boolean=true


  /**
   * loads xml file from a certain url
   * @return
   */
  def loadFile():Elem={
    try{
      val url = new URL("http://www.boi.org.il/currency.xml")
      val conn = url.openConnection
      cl.info("Connectiong to BOI's site...")
      doc = XML.load(conn.getInputStream)
      if(saveFlag)
      {
        XML.save("Currencies.xml", doc, "UTF-8", false, null)
        saveFlag=false
        println("File Updated at: "+new Date())
      }
      cl.info("Currencies file was downloaded from BOI's site")
    }
    catch{
      case e:Exception=>{
        cl.info("internet connection problem loading old version of Currency file")
        doc = XML.load("./Currencies.xml")
        cl.info("Currencies file was loaded from a locale file")
      }
    }
    doc
  }

  /**
   * parses a certain file to an hashmap of coins
   * @return
   */
  def parseFile():HashMap[String,Coin]=
  {
    cl.info("Parsing file...")
    this.loadFile()
    //var currenciesAmount:Int=(doc\\"CURRENCY").length
    var coins:HashMap[String,Coin]=new HashMap[String,Coin]
    //currenciesAmount=0
    for(ob<-(doc\\"CURRENCY"))
    {
      var name:String=(ob\\"NAME").text
      var unit:String=(ob\\"UNIT").text
      var currencyCode:String=(ob\\"CURRENCYCODE").text
      var country:String=(ob\\"COUNTRY").text
      var rate:String=(ob\\"RATE").text
      var change:String=(ob\\"CHANGE").text
      coins.put(country,new Coin(name,unit,currencyCode,country,rate,change))
      //currenciesAmount+=1
    }
    coins.put("Israel",new Coin("NIS","1","ISL","Israel","1","0"))
    cl.info("File parsed, coins data is ready")
    coins
  }
}