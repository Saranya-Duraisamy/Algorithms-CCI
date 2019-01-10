// Find count of bit flips required to convert num1 to num2
class Solution {
    //Using XOR and Logical Right Shift operator
    static int NumConvertFlipBitCount(int num1, int num2) {
        int result = num1 ^ num2;
        int count = 0;
        while(result != 0) {
            count += result & 1;
            result = result >>> 1;
        }
        return count;
    }
    //Using XOR and clear least significant bit in result(n & n-1)
    static int NumConvertFlipBitCountSimplified(int num1, int num2) {
        int count = 0;
        for(int result = num1 ^ num2; result != 0; result = result & (result-1)) {
            count++;
        }
        return count;
    }
    public static void main(String args[]) {
        System.out.println("#Bit Flip Count: " + NumConvertFlipBitCount(29, 15));
        System.out.println("#Bit Flip Count Simplified: " + NumConvertFlipBitCountSimplified(29, 15));
    }
}