package il.ac.shenkar.scaleCurrencies

import java.util.{Date, HashMap}

import main.java.il.ac.shenkar.scaleCurrencies.gui.Gui
import main.java.il.ac.shenkar.scaleCurrencies.utills.ClassLogger
import main.scala.il.ac.shenkar.scaleCurrencies.model.Coin
import main.scala.il.ac.shenkar.scaleCurrencies.utills.{DataAdaptor, XmlParser}


/**
 * @author Golan & Yaniv
 */
class GuiInit extends Thread
{
  val cl: ClassLogger = new ClassLogger("GuiInit")
  cl.info("Preparing params for gui...")
  private val dataAdaptor:DataAdaptor=new DataAdaptor()
  private var coin:HashMap[String,Coin]=_
  private var data:Array[Array[String]]=_
  private var countries:Array[String]=_

  coin = XmlParser.parseFile()
  data=dataAdaptor.getCoinsDataFromFile(coin)
  countries=dataAdaptor.getCountriesFromFile(coin)
  cl.info("Params are ready")
  cl.info("Initializing GUI...")
  private val gui:Gui=new Gui(coin,data,countries)
  cl.info("GUI is ready for action")
  
  this.setDaemon(true)
  Thread.sleep(180000)
  this.run()

  override def run()={
    while(true)
    {
      cl.info("Updating currencies...")
      coin=XmlParser.parseFile()
      data=dataAdaptor.getCoinsDataFromFile(coin)
      countries=dataAdaptor.getCountriesFromFile(coin)
      gui.updateData(coin,data)
      println("Update at: "+new Date().toString())
      cl.info("Currencies were updated")
      Thread.sleep(180000)
    }
  }
}