package ArraysTasks;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    /*Треугольник Паскаля: каждый элемент списка является суммой двух прилегающих чисел сверху(кроме крайних)
    * Идем в цикле от 1(номер ряда=количество элементов) до n;
    * Для каждого ряда создаем список и в цикле начинаем заполнять маленький список элементами:
    * если индекс первый или последний - ставим единицы
    * если нет, то проверяем, что ряд больше 2(3 и более), так как первые 2 ряда заполняются единицами
    * далее забираем предыдущий список - и складываем элементы - с индексом j-1 и j из предыдущего списка*/

    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1; i<=numRows; i++){
            List<Integer> myRow = new ArrayList<>();
            for(int j=0; j<i;j++){
                if(j==0 ||(j==i-1)){
                    myRow.add(1);
                }
                else{
                    if(i>2){
                        List<Integer> previous = result.get(i-2);
                        myRow.add(previous.get(j-1)+previous.get(j));
                    }
                }
            }result.add(myRow);
        }
        return result;
    }
}
