
public class Test {

    static void rotateMatrixClockwise(int matrix[][]) {
        int size = matrix.length;
        for(int layer = 0; layer<size/2; layer++){
            int first = layer;
            int last = size-layer-1;
            int temp;
            for(int i=first; i<last; i++) {
                int offset = last-(i-first);
                temp = matrix[first][i];
                matrix[first][i] = matrix[offset][first];
                matrix[offset][first] = matrix[last][offset];
                matrix[last][offset] = matrix[i][last];
                matrix[i][last] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};//{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};//{{1,2,3},{4,5,6},{7,8,9}};//
        System.out.println("Given Matrix:");
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        rotateMatrixClockwise(matrix);
        System.out.println("Rotate Matrix Clockwise by 90 degrees:");
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
