package gameLoadingTest;

import image.Assets;
import org.junit.Assert;
import org.junit.Test;
import theGame.gameLoading.Loading;



public class switchToStringTest {
    /*
This test using to check. If the function SwitchToString() can success to switch the information in txt file into string.
 */
    String actual=Loading.switchToString("src/test/resources/test.txt");
    @Test
    public void checkSwitchToString(){
        StringBuilder temp=new StringBuilder();
        temp.append("1 2");
        temp.append("\n");
        temp.append("3 4");
        temp.append("\n");
        Assert.assertEquals(temp.toString(), actual);
    }
    /*
    The below test use to check The String can correctly contain the correct map information and can switch to a number. The number means each tile's Id.
     */
   @Test
    public void checkSwitchToInt(){
       String[] test =actual.split("\\s+");
       for(int x =0; x<4; x=x+1) {
           int num = Loading.switchToInt(test[x]);
           Assert.assertEquals(x+1, num);
       }
    }
}
