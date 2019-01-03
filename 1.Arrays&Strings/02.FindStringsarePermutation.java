import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Test {
    static boolean isStringPermutation(String str1, String str2) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        if(str1.length() != str2.length())
            return false;
        int i;
        char ch;
        int value;
        for(i=0;i<str1.length();i++) {
            ch = str1.charAt(i);
            value = 1;
            if(hashMap.containsKey(ch))
                value += hashMap.get(ch);
            hashMap.put(ch, value);
        }
        for(i=0;i<str2.length();i++){
            ch = str2.charAt(i);
            if(hashMap.containsKey(ch)) {
                value = hashMap.get(ch)-1;
                if(value > 0)
                    hashMap.put(ch, value);
                else
                    hashMap.remove(ch);
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try{
            System.out.println("Enter the first String: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str1 = br.readLine();
            System.out.println("Enter the second String: ");
            String str2 = br.readLine();
            if(isStringPermutation(str1,str2)){
                System.out.println("Given strings are permutation");
            }
            else {
                System.out.println("Given strings are not permutation");
            }
        }
        catch(IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}
