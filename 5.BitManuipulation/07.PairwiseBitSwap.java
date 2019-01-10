// Pairwise Swap bits(even and odd) swap bit 0-bit 1; bit2-bit3; and so on.
class Solution {
    // Use Even Bit mask(0xAAAAAAAA) & Odd Bit mask(0x55555555)
    static int PairwiseBitSwap(int num) {
        if(num == 0 || num == -1){
            return num;
        }
        int evenBits = num & 0xAAAAAAAA;
        int oddBits = num & 0x55555555;
        evenBits = evenBits >>> 1;
        oddBits = oddBits << 1;
        return evenBits|oddBits;
    }
    static int PairwiseBitSwapSimplified(int num) {
        if(num == 0 || num == -1){
            return num;
        }
        return ((num & 0xAAAAAAAA) >>> 1)|((num & 0x55555555) << 1);
    }
    public static void main(String args[]) {
        System.out.println("#Bit Flip Count: " + Integer.toBinaryString(PairwiseBitSwap(29)));
        System.out.println("#Bit Flip Count: " + Integer.toBinaryString(PairwiseBitSwapSimplified(29)));
    }
}