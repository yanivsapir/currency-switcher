package test.scala.utills;

import main.scala.il.ac.shenkar.scaleCurrencies.model.Coin;
import main.scala.il.ac.shenkar.scaleCurrencies.utills.DataAdaptor;
import main.scala.il.ac.shenkar.scaleCurrencies.utills.XmlParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by Golan on 19/07/2015.
 */
public class DataAdaptorTest {
    private Coin c1 = new Coin("peso","1","PZO","Argentina","1,2","0.01");
    private Coin c2 = new Coin("dinar","1000","DNR","Turkey","1","0.23");
    private HashMap<String,Coin> map = new HashMap<String,Coin>();


    @Test
    public void checkGetCountries(){
        map.put("Argentina",c1);
        map.put("Turkey",c2);
        DataAdaptor dataAdaptor=new DataAdaptor();
        String[] countries=dataAdaptor.getCountriesFromFile(map);
        Assert.assertNotNull(countries);
    }

    @Test
    public void checkGetCoinsData(){
        map.put("Argentina",c1);
        map.put("Turkey",c2);
        DataAdaptor dataAdaptor=new DataAdaptor();
        String[][] countries=dataAdaptor.getCoinsDataFromFile(map);
        Assert.assertNotNull(countries);

    }
}
