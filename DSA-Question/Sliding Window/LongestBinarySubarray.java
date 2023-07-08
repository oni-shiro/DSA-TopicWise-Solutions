package Sliding Window;

public class LongestBinarySubarray {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int i =0,j=0, cntOfZeroes = 0, maxOnes= Integer.MIN_VALUE;

        while(j<n){
            if(nums[j]==0){
                cntOfZeroes++;
            }
            while(cntOfZeroes>1){
                if(nums[i]==0){
                    cntOfZeroes--;
                }
                i++;
            }
            //get the current number of 1
            //num of 1 = window size - 1
            maxOnes = Math.max(maxOnes, j-i);
            j++;
        }
        return maxOnes;
           
    }
}
