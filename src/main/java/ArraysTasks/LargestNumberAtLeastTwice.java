package ArraysTasks;

public class LargestNumberAtLeastTwice {
/*You are given an integer array nums where the largest integer is unique.

Determine whether the largest element in the array is at least twice as much as every other number in the array.
 If it is, return the index of the largest element, or return -1 otherwise.*/
    public static int dominantIndex(int[] nums) {
        int result =-1;
        int max=0;
        int index=-1;
        for (int i=0; i< nums.length; i++){
            if(nums[i]>=max){
                max=nums[i];
                index =i;
            }
        }
        for(int i=0; i<nums.length; i++){
           if(nums[i]!=max && (nums[i]*2<=max)){
               result=index;
           }
           else if(nums[i]!=max){
               return -1;
           }
        } return result;
    }
}
