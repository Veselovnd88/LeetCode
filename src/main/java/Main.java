import TwoPointers.ArrayPartition;
import TwoPointers.RemoveInPlace;
import TwoPointers.ReverseTwoPointers;
import TwoPointers.SumOfTwo;

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
        RemoveInPlace removeInPlace = new RemoveInPlace();

        int[] ints = {1, 2, 3, 4, 4, 4, 5, 6, 7};
        System.out.println(removeInPlace.removeElement(ints,4));
        System.out.println(Arrays.toString(ints));

    }
}
