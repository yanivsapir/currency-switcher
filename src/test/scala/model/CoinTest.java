package test.scala.model;

import main.scala.il.ac.shenkar.scaleCurrencies.model.Coin;
import main.scala.il.ac.shenkar.scaleCurrencies.utills.DataAdaptor;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Golan on 19/07/2015.
 */
public class CoinTest {
    private Coin coin=new Coin("sheqel","1","NIS","Israel","1","0");
    private String coinData=null;
    @Test
    public void checkCoinCtor(){
        Assert.assertNotNull(coin);
    }
    @Test
    public void checkCoinToTable(){
        coinData=coin.toString();
        Assert.assertNotNull(coinData);
    }
    @Test
    public void checkCalculatorCurrencies(){
        double d=coin.calculateCurrencies(coin);
        Assert.assertNotNull(d);
    }


}
