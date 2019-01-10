// Draw Horizontal Line from (x1,y) to(x2,y) on monochrome screen
class Solution {
    //startMask: Set i bits from LSB: 0xFF >>> i
    //endMask: Set i bits from MSB: ~(0xFF >>> (i+1))
    //start and end remains the same byte: startMask & endMask
    static void DrawLine(byte[] screen, int width, int x1, int x2, int y) {
        int height = (8*screen.length)/width;
        if(y > height || x1 > width || x2 > width ) {
            return;
        }
        int start = y*(width/8) + x1/8;
        int startBitIndex = x1%8;
        int end = y*(width/8) + x2/8;
        int endBitIndex = x2%8;
        byte startMask = (byte) (0xFF >>> startBitIndex);
        byte endMask = (byte) (~(0xFF >>> (endBitIndex+1)));
        if(start != end) {
            for (int loop = start + 1; loop < end; loop++) {
                screen[loop] = (byte) 0xFF;
            }
            screen[start] = startMask;
            screen[end] = endMask;
        }
        else{
            screen[start] = (byte) (startMask & endMask);
        }
    }

    public static void main(String args[]) {
        byte[] screen = {0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0};
        int width = 64;
        int height = (8*screen.length)/width;
        System.out.println("Height X Width: "+height+ " x "+ width);
        //DrawLine(screen, 64, 8,32,1);
        //DrawLine(screen, 64, 7,33,1);
        //DrawLine(screen, 64, 0,7,1);
        DrawLine(screen, 64, 2,6,1);
        for(int loop = 0; loop < height; loop++){
            for(int inner = loop*(width/8); inner < (loop+1)*(width/8); inner++){
                System.out.print(Byte.toUnsignedInt(screen[inner]));
                System.out.print(',');
            }
            System.out.print("\n");
        }
    }
}