import TwoPointers.*;

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
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();

        int[] ints = {1, 1, 0, 1};
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes(ints));


    }
}
