package test.java.gui;

import main.java.il.ac.shenkar.scaleCurrencies.gui.BackgroundPanel;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Golan on 19/07/2015.
 */
public class BackgroundPanelTest {
    BackgroundPanel bp =null;
    @Test
    public void checkBackgroundPanelCtor(){
        try {
            bp=new BackgroundPanel("src/main/resources/Flags/Australia.gif");
            Assert.assertNotNull(bp);
        }
        catch(java.io.IOException e){}
    }
    @Test
    public void checkSetBackgroundImage(){
        try{
            bp=new BackgroundPanel("src/main/resources/Flags/Australia.gif");
            bp.setBackgroundImage("src/main/resources/Flags/Israel.gif");

            Assert.assertNotNull(bp);
            bp.setBackgroundImage("zjxkbkjb");

        }
        catch(java.io.IOException e){
            Assert.assertNotNull(bp);
        }
    }
}
