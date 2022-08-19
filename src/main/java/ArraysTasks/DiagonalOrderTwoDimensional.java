package ArraysTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalOrderTwoDimensional {
/*Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.*/
    public static int[] findDiagonalOrder(int[][] matrix){

        int[] newArr= new int[matrix.length*matrix[matrix.length-1].length];//задание массива на все элементы двумерного
        int i=0;
        int j=1;//первый и последние элементы сразу включаем
        int pos=1;//задание позиции с которой начинаем обход
        boolean flag=true;//флаг который указываем вверх или вниз будем идти
        if(matrix.length==1){// два условия на одномерные матрицы
            newArr= Arrays.copyOf(matrix[0],newArr.length);
            return newArr;
        }
        else if(matrix[i].length==1){
            for(int k=0; k<matrix.length;k++){
                newArr[k]=matrix[k][0];
            }
            return newArr;
        }
        newArr[0]= matrix[0][0];
        newArr[newArr.length-1]=matrix[matrix.length-1][matrix[matrix.length-1].length-1];
        while (pos< newArr.length-1){
            if(flag){
                while(j>=0&&i< matrix.length){//пока не коснулись края
                    newArr[pos++] = matrix[i++][j--];//идем вниз по диагонали
                }
                if((i+1)> matrix.length){//условие перехода - если внизу места уже нет - то сдвигаемся вправо
                    i--;
                    j+=2;
                }
                else{//если внизу есть место - то обнуляем индекс столбца ( i инкрементировался  в цикле вайл
                    j=0;}
                flag=false;//фол = идум вверх
            }
            else{
                //по аналогии только движемся снизу вверх и проверяем другие границы
                while(j< matrix[0].length&&i>=0){
                    newArr[pos++]=matrix[i--][j++];
                }
                if((j+1)>matrix[0].length){
                    j--;
                    i+=2;
                }else{

                    i=0;}
                flag=true;
        }
        } return newArr;
    }




        private static int[] down(int[][] matrix, int i, int j){
            List<Integer> list = new ArrayList<>();
            while(j>=0&&i< matrix.length){
                list.add(matrix[i++][j--]);
            }
            int[] arr = new int[list.size()];
            for(int k=0; k<list.size(); k++){
                arr[k] = list.get(k);
            }
            return arr;
    }
        private static int[] up(int[][] matrix, int i, int j){
            List<Integer> list = new ArrayList<>();
            while(j< matrix.length&&i>=0){
                list.add(matrix[i--][j++]);
            }
            int[] arr = new int[list.size()];
            for(int k=0; k<list.size(); k++){
                arr[k] = list.get(k);
            }
            return arr;
        }


}
