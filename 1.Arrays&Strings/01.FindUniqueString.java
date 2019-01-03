import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Test {
    static boolean isUniqueString(String str) {
        long nonalphabet = 0;
        long alphabet = 0;
        for(int i=0;i<str.length();i++) {
            int ch = str.charAt(i)-'A';
            if(ch >= 0) {
                if((alphabet & (1<<ch)) > 0)
                    return false;
                alphabet |= (1<<ch);
            }
            else {
                ch = str.charAt(i);
                if((nonalphabet & (1<<ch)) > 0)
                    return false;
                nonalphabet |= (1<<ch);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try{
            int index = 0;
            System.out.println("Enter the String: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            if(isUniqueString(str)){
                System.out.println("Given string has all unique characters");
            }
            else {
                System.out.println("Given String has duplicate characters");
            }

            /* //using data structure
            HashMap<Character,Integer> hashMap = new HashMap<>();
            int i;
            for(i=0; i<str.length(); i++){
                char ch = str.charAt(i);
                if(hashMap.containsKey(ch)) {
                    System.out.println(" Given string \""+ str+ "\" has duplicate at " + i);
                    break;
                }
              hashMap.put(ch,1);
            }
            if(i == str.length()){
                System.out.println(" Given string \""+ str+ "\" has all unique characters ");
            }
            */
            //without using data structure
            /*boolean []exists = new boolean[128];
            int i;
            for(i=0;i<exists.length;i++) {
                exists[i] = false;
            }
            System.out.println(exists.length);
            for(i =0;i<str.length();i++) {
                if(exists[str.charAt(i)]) {
                    System.out.println(" Given string \""+ str+ "\" has duplicate at " + i);
                    break;
                }
                exists[str.charAt(i)] = true;
            }
            if(i == str.length()){
                System.out.println(" Given string \""+ str+ "\" has all unique characters ");
            }*/

        }
        catch(IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}
