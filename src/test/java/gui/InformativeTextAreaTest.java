package test.java.gui;

import org.junit.Assert;
import main.java.il.ac.shenkar.scaleCurrencies.gui.InformativeTextArea;
import org.junit.Test;



/**
 * Created by Golan on 19/07/2015.
 */
public class InformativeTextAreaTest {
    @Test
    public void checkInformativeTextAreaCtor(){
        InformativeTextArea ita=new InformativeTextArea("src/main/resources/Help.txt");
        Assert.assertNotNull(ita);
        ita=new InformativeTextArea("sahdvjas");
        Assert.assertNotNull(ita);
    }
}
