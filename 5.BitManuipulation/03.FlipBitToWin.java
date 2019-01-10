class Solution {
    static boolean isBitSet(int num){
        return ((num & 1) ==1)?true:false;
    }
    static int FlipBitToWin(int num){
        int longSeq = 1; // At least one flip from 0 to 1
        int count = 0;
        int subcount = 0;
        int zeroes = 0;

        if(num == 0) { // Corner case 1- All Zeroes
            return longSeq;
        }
        if(~num == 0){ // Corner case 2- All Ones
            return Integer.BYTES*8;
        }
        while(num > 0){
            count = 0;
            while(isBitSet(num)){
                count++;
                num = num >>> 1; // use logical operator
            }
            if(zeroes == 1) {
                longSeq = Math.max(longSeq, count+subcount+1);
            }
            if(num == 0) {
                break;
            }
            zeroes = 0;
            while(!isBitSet(num)){
                zeroes++;
                num = num >>> 1; // use logical operator
            }
            if(zeroes > 1){
                longSeq = Math.max(longSeq, count+1);
                subcount = 0;
            }
            else {
                subcount = count;
            }
        }
        return longSeq;
    }
    static int FlipBitToWinSimplified(int num) {
        int longSeq = 1;
        int count = 0;
        int prev_count = 0;

        if(num == 0)
            return longSeq;
        if(~num == 0)
            return Integer.BYTES*8;

        while(num != 0){
            if((num & 1) == 1)
                count++;
            else {
                if((num & 2) == 2){
                    // single zero in between 1's
                    prev_count = count;
                    count = 0;
                }
                else {
                    // more than single zero in between 1's
                    prev_count = 0;
                    count = 0;
                    num = num >>> 1;
                }
            }
            longSeq = Math.max(longSeq, count+prev_count+1);
            num = num >>> 1;
        }

        return longSeq;
    }
    public static void main(String args[]) {
        System.out.println("Longest Sequence of 1s: "+ FlipBitToWin(1775));
        System.out.println("Longest Sequence of 1s: "+ FlipBitToWinSimplified(1775));
    }
}