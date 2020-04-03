package gameLoadingTest;

import org.junit.Assert;
import org.junit.Test;
import theGame.gameLoading.Loading;


public class switchToStringTest {
    @Test
    public void checkSwitchToString(){
        String temp="1234";
        String actual=Loading.switchToString("src/test/resources/test.txt");
        System.out.println();
        Assert.assertArrayEquals(new String[]{temp}, new String[]{actual});
    }
}
