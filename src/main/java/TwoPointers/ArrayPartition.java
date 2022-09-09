package TwoPointers;

import java.util.Arrays;

/*Дан массив чисел, сгруппировать по парам таким образом чтобы сумма минимальных пар была максимальная
@return максимальная сумма
Отсортировать массив и сложить все левые (минимальные) числа
* */
public class ArrayPartition {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result=0;
        for(int i=0; i<nums.length;i+=2){
            result+=nums[i];
        } return result;
    }
}
