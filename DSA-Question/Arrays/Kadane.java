package Arrays;


// https://leetcode.com/problems/maximum-subarray/description/
public class Kadane {
    public int kadane(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int max = nums[0];/// setting max as first el
        for(int i = 0; i<n;i++){
            sum += nums[i];
            if(max<sum){
                max = sum;
            }
            
            if(sum<0){
                sum = 0;
            }
            
        }
        return max;
            
    }
}
