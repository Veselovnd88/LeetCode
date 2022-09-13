package TwoPointers;
/*Given arrays with 0 and 1, we need to find maximum consecutive ov ones
* We need to find windows as zeros and count ones between
* We're going through array and when find next 0 - calculate distance between, and save in to max
* @return maximum of ones together*/
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int window=-1;
        int curr=0;
        int max=0;

        while(curr<nums.length){
            if(nums[curr]==0){
                window=curr;
            }else{
                int diff = curr-window;
                if(diff>max){
                    max=diff;
                }
            }
            curr++;
        }
    return max;
    }
}
