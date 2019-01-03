public class Test {
    static String compressedString(String str) {
        int len = str.length();
        StringBuilder compressedStr = new StringBuilder(len);

        for(int i=0; i<len; ) {
            int j = i+1;
            char ch = str.charAt(i);
            while( j<len && ch == str.charAt(j) ) {
                j++;
            }
            compressedStr.append(ch);
            compressedStr.append(j-i);
            i = j;
        }

        if(len <= compressedStr.length()){
            return str;
        }
        return compressedStr.toString();
    }

    public static void main(String[] args) {
        String str = "aabbbbc";//"abc";//"aabcccccaaa";
        System.out.println("Compressed String: " + compressedString(str));
    }
}
