import ArraysTasks.DiagonalOrderTwoDimensional;
import ArraysTasks.PascalTriangle;
import ArraysTasks.SpiralArray;
import StringTasks.SumBinary;

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
        SumBinary sumBinary = new SumBinary();

        System.out.println(sumBinary.addBinary("1010","1011"));


    }
}
