package TwoPointers;
/*Given an array of positive integers and target value
* We need to find shortest subArray with will give in sum our target;
* What we do: we have fast point to iterate from left to right, and slow pointer for giving us left border
* When we found right border - we start to move left border to check what will be sum if we will delete values from the left
* I used flag to check - is min value changed or not
* @return minimum size of subArray*/
public class MinimumSizeSubArray {

    public int minSubArrayLen(int target, int[] nums){

        int fast=0;
        int slow=-1;
        int sum=0;
        int min=Integer.MAX_VALUE;
        boolean flag=false;
        while(fast<nums.length){
            sum+=nums[fast];
            if(sum>=target){
                int diff = fast-slow;
                if(diff<min){
                    min=diff;
                    flag=true;
                }
                sum-=nums[slow+1];
                slow++;
                sum-=nums[fast];
                fast--;
            }
            fast++;
        }
    if(flag) {
        return min;}
    else{
        return 0;
    }
    }
}
