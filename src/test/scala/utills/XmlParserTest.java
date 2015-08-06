package test.scala.utills;

import main.scala.il.ac.shenkar.scaleCurrencies.utills.XmlParser;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Golan on 19/07/2015.
 */
public class XmlParserTest {
    @Test
    public void checkBankUrl(){
        Assert.assertNotNull(XmlParser.loadFile());
    }

    @Test
    public void checkParse(){
        Assert.assertNotNull(XmlParser.parseFile());
    }
}
