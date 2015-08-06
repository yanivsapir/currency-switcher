package test.java;

import main.java.il.ac.shenkar.scaleCurrencies.utills.ClassLogger;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Golan on 19/07/2015.
 */
public class ClassLoggerTest {

    @Test
    public void checkClassLoggerCtor(){
        ClassLogger classLogger=new ClassLogger("ClassLoggerTest");
        Assert.assertNotNull(classLogger);
    }
}
