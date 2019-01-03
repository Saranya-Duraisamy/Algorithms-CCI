import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Test {
    static String URLifyString(String str, int length) {
        char[] newStr = str.toCharArray();
        int total_len = newStr.length-1;
        System.out.println(total_len);

        for(int loop = length-1; loop >= 0; loop--) {
            if(newStr[loop] == ' ') {
                newStr[total_len--] = '0';
                newStr[total_len--] = '2';
                newStr[total_len--] = '%';
            }
            else {
                newStr[total_len--] = newStr[loop];
            }
        }
        return new String(newStr);
    }


    public static void main(String[] args) {
        String str = "Mr John Smith     ";
        int length = 13;
        System.out.println("Given strings: "+ str );
        System.out.println("URLified String: "+ URLifyString(str, length));
    }
}
