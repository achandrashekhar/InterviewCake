/**
 * Created by ashi on 9/10/17.
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.
 Algorith must run in linear time and use constant extra space
 */
class MissingNumber {
    public int missingNumber(int[] nums) {
        for(int i = 1; i<nums.length;i++){
            if(nums[i] - nums[i-1] > 1){
                return (nums[i] - 1);
            }
        }
        return nums.length; // if the entire loop ran successfully, that means only n is missing from [0,1...n]
    }
}