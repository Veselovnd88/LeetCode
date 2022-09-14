package ArraysTasks;

import java.util.Arrays;

/*Given an array and quantity of steps k, need to rotate (or move from left to right each number)
* To do not create new array it is better way to see how array look after reversing
* We can divide it in two parts - part before k - need to go to the right, part after - to the beginning
* after reversing - we need additionally reverse left and right parts*/
public class RotateArray {

    public void rotate(int[] nums, int k) {

        int temp;
        int shift = k% nums.length;
        if(nums.length<2|| shift==0){
            return;
        }
        reverse(0, nums.length, nums);
        reverse(0,shift,nums);
        reverse(shift,nums.length+shift,nums);
/*        for(int i=0; i<nums.length/2;i++){
            temp=nums[i];
            nums[i]=nums[nums.length-1-i];
            nums[nums.length-1-i]=temp;
        }*/

/*        for(int i=0; i<shift/2;i++){
            temp=nums[i];
            nums[i]=nums[shift-1-i];
            nums[shift-1-i]=temp;
        }*/
/*        for(int i=shift; i< (nums.length+shift)/2;i++){
            temp=nums[i];
            nums[i]=nums[nums.length-1-i+shift];
            nums[nums.length-1-i+shift]=temp;
        }*/
    }

    private void reverse(int left, int right, int[] nums){
        int temp;
        for(int i=left; i<right/2;i++){
            temp=nums[i];
            nums[i]=nums[right-1-i];
            nums[right-1-i]=temp;
        }
    }

}
