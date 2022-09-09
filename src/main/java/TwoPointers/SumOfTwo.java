package TwoPointers;

public class SumOfTwo {

    /*We have an array sorted non-decreasing, and target number;
    Need to find two number that in add give us target;
    Solution with two cycles give us O(n2), that is too much
    With two pointers we start with left - in the beginning and right - in the end;
    After adding two numbers we check - if sum larger than target - we need to move right pointer to left,
    else if sum less than target - we need to move left pointer.
    @return int[] indexes of that number in our array, with added 1 (index+1);
* */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left=0;
        int right=numbers.length-1;
        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum==target){
                result[0]=left+1;
                result[1]=right+1;
                break;
            }
            else if(sum<target){
                left++;
            }
            else{
                right--;
            }
        }
        return result;
    }
}
