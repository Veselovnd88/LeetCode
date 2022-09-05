package ArraysTasks;

import java.util.ArrayList;
import java.util.List;

/*Немного перемудрил с начальным решением*/
public class SpiralArray {

    public List<Integer> solve(int[][] matrix){
        List<Integer> result = new ArrayList<>();

        int boundR= matrix[0].length-1;
        int boundL = 0;
        int boundUp = 0;
        int boundDown = matrix.length-1;
        // int x=0;
        //int max = matrix.length*matrix[0].length;
        while(true){

            for(int i=boundL; i<=boundR; i++){//идет слева направо, меняется второй индекс
                result.add(matrix[boundUp][i]);
                //x++;
            }
           // if((boundR==boundL && boundUp==boundDown)||(x==max)){
            boundUp++;
            if(boundUp>boundDown){
                break;
            }
         /*   if(boundUp!=boundDown){
                    boundUp++;}*/

            for(int j=boundUp;j<=boundDown;j++){//идет сверху вниз, меняется первый индекс
                result.add(matrix[j][boundR]);
               // x++;
            }
            boundR--;
            if(boundR<boundL){
           // if((boundR==boundL && boundUp==boundDown)||(x==max)){
                break;
            }
          /*  if(boundR!=boundL){
                    boundR--;}
*/
            for(int k=boundR;k>=boundL;k--){//идет справа налево, меняется второй индекс
                result.add(matrix[boundDown][k]);
              //  x++;
            }
           // if((boundR==boundL && boundUp==boundDown)||(x==max)){
            boundDown--;
            if(boundDown<boundUp){
                break;
            }
/*            if(boundDown!=boundUp){
                    boundDown--;}*/
            for (int l=boundDown; l>=boundUp;l--){//идет снизу вверх, меняется первый индекс
                result.add(matrix[l][boundL]);
                  //x++;
            }
            boundL++;
           // if((boundR==boundL && boundUp==boundDown)||(x==max)){
            if(boundL>boundR){
                break;
            }
/*            if(boundR!=boundL){
                    boundL++;
            }*/
        }
        return result;
    }




}
