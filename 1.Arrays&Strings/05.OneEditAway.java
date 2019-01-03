public class Test {
   static boolean isOneEditAway(String str1, String str2) {
       int len1 = str1.length();
       int len2 = str2.length();
       if(Math.abs(len1-len2) > 1) {
           return false;
       }
       if( (len1 == len2) && (str1.equals(str2))) {
           //Zero edit away
           return true;
       }
       boolean foundDifference = false;
       for(int i=0, j=0; i<len1 && j<len2; i++, j++) {
           if(str1.charAt(i) != str2.charAt(j)){
               if(foundDifference) {
                   // return when second difference is found
                   return false;
               }
               foundDifference = true;
               if(len1 > len2){
                   //Don't move 'j' pointer
                   j--;
               }
               if(len2 > len1) {
                   //Don't move 'i' pointer
                   i--;
               }
           }
       }
       return true;
   }

    public static void main(String[] args) {
        String str1 = "pale";
        String str2 = "bake";//"bale";//"ple";//"pales";//"bales";
        if(isOneEditAway(str1, str2)){
            System.out.print(" Given strings are one(zero) edit away");
        }
        else{
            System.out.print(" Given strings are not one(zero) edit away");
        }
    }
}
