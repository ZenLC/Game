package theGame.gameLoading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Loading {
    public static  String switchToString(String path){
        StringBuilder string = new StringBuilder();
        try{
            BufferedReader read= new BufferedReader(new FileReader(path));
            String line;
            while((line = read.readLine()) !=null)
                string.append(line+"\n");
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string.toString();
        }

        public static int switchToInt(String num){
        try{
                return Integer.parseInt(num);
        }catch (NegativeArraySizeException e){
            e.printStackTrace();
            return 0;
        }
        }
}
