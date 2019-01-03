
public class Test {
    public enum Zero{
        NONE, ROW, COLUMN, BOTH;
    }
    static void getZeroMatrix(int matrix[][]) {
        Zero entry = Zero.NONE;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if( i==0 ) {
                        entry = Zero.COLUMN;
                    }
                    if( j==0 ) {
                        entry = Zero.ROW;
                    }
                    if( i==0 && j==0 ) {
                        entry = Zero.BOTH;
                    }
                }
            }
        }
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[i].length; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(entry == Zero.ROW || entry == Zero.BOTH) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if(entry == Zero.COLUMN || entry == Zero.BOTH){
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,0,3},{4,5,6},{7,8,9}};//{{1,2,3},{4,0,6},{7,8,9}};//{{0,2,3},{4,5,6},{7,8,9}};//{{1,2,0},{4,5,6},{7,8,9}};
        System.out.println("Given Matrix:");
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        getZeroMatrix(matrix);
        System.out.println("Zero Matrix:");
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
