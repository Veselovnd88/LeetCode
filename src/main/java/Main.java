import TwoPointers.ArrayPartition;
import TwoPointers.ReverseTwoPointers;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        int x=1;
        for(int i=0; i< matrix.length; i++){
            for (int j=0; j< matrix[i].length; j++){
                matrix[i][j]=x;
                x++;
            }
            //System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println("-------------------");
        ArrayPartition arrayPartition = new ArrayPartition();
        System.out.println(arrayPartition.arrayPairSum(new int[]{6,2,6,5,1,2}));


    }
}
