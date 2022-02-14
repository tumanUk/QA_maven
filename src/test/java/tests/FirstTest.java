package tests;

import org.junit.Assert;
import org.junit.Test;

public class FirstTest {
    @Test
    public void CalculatorTest(){
        Assert.assertEquals(475, 400 + 75);
    }
}
