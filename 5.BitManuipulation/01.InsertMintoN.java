class Solution {

    static int insertMintoN(int N, int M, int i, int j){
        //int clearMask = ~((1<<i)-1)^((1<<(j+1))-1); // Method 1
        int clearMask = (~0 << (j+1))|((1<<i)-1); // Method 2
        System.out.println("clearMask:"+ Integer.toBinaryString(clearMask));
        N = (N & clearMask);
        N = N | (M <<i);
        System.out.println("N:"+ Integer.toBinaryString(N));
        return N;
    }

    public static void main(String args[]) {
        int N = 1024;
        int M = 19;
        int i = 2;
        int j = 6;
        System.out.println("N:"+ Integer.toBinaryString(N));
        System.out.println("M:"+ Integer.toBinaryString(M));
        System.out.println("Result:"+ insertMintoN(N, M, i, j));
    }
}