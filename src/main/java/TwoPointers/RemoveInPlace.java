package TwoPointers;
/*Given arrays with integers, and int value, we need to remove all occurrences of value in place
* Without new array, what left beyond our k is doesn't matter;
* We take two pointers - fast - current index, slow - actual pointer where we need to copy element
* @return actual pointer with elements not equals value */
public class RemoveInPlace {
    public int removeElement(int[] nums, int val) {

        int k=0;
        int curr=0;
        while(curr<nums.length){
            if(nums[curr]!=val){
                nums[k]=nums[curr];
                k++;
            }
            curr++;
        }
    return k;
    }
}
