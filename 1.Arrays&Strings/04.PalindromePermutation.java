import java.util.HashMap;
import java.util.Set;

public class Test {
    /* //Using HashMap
    static boolean isPermutationPalindrome(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int loop=0; loop<str.length(); loop++) {
            char ch = Character.toLowerCase(str.charAt(loop));
            if(Character.isAlphabetic(ch)) {
                if (hashMap.containsKey(ch)) {
                    hashMap.put(ch, hashMap.get(ch) + 1);
                } else {
                    hashMap.put(ch, 1);
                }
            }
        }
        System.out.println(hashMap);
        int count = 0;
        Set<Character> set = hashMap.keySet();
        for(Character ch: set){
            if((hashMap.get(ch)%2) != 0 ){
                count++;
            }
        }
        System.out.println("Count: "+count+" Len: "+str.length());
        if(count > 1) {
            return false;
        }
        if(count == 1 && (str.length()%2 == 0)) {
            return false;
        }
        return true;
    }*/
    static boolean isSingleBitExactlySet(int bitVector){
        if((bitVector & (bitVector-1)) == 0) {
            return true;
        }
        return false;
    }
    static int toggleBit(int bitVector, int index) {
        int mask = 1 << index;
        /*if((bitVector & mask) == 0) { //Check whether its set or not
            // set bit if clear
            bitVector |= mask;
        }
        else {
            // clear bit if set
            bitVector ^= mask;
        }
        return bitVector;*/
        bitVector ^=mask;
        return bitVector;
    }

    static boolean isPermutationPalindrome(String str) {
        int bitVector = 0;
        for(int loop = 0; loop<str.length(); loop++) {
            char ch = str.charAt(loop);
            if(Character.isAlphabetic(ch)){
                ch = Character.toLowerCase(ch);
                bitVector = toggleBit(bitVector, ch-'a');
            }
        }
        return isSingleBitExactlySet(bitVector);
    }

    public static void main(String[] args) {
        String str = "tact coa";
        System.out.println("Given strings: "+ str );
        if(isPermutationPalindrome(str)){
            System.out.print(" is permutation palindrome");
        }
        else{
            System.out.print(" is not permutation palindrome");
        }
    }
}
