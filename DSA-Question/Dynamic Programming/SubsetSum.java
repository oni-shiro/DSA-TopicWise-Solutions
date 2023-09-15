class SubsetSum {
    /**
     * 1. Get the total sum
     * 2. Check if odd then half is not possible
     * 3. check if even then check if that sum/2 can be formded using a subset
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        for (int it : nums) {
            totalSum += it;
        }
        if ((totalSum & 1) == 1) {
            return false; // odd;
        }
        return subsetSum(nums, totalSum / 2);

    }

    private boolean subsetSum(int[] nums, int sum) {
        return helper(nums, nums.length - 1, sum);
    }
// recurision
    private boolean helper(int[] nums, int id, int remainingSum) {

        if(remainingSum==0){
            return true;
        }
        if (id == 0) {
            if (remainingSum - nums[id] == 0) {
                return true;
            } else {
                return false;
            }
        }

        // choices
        int currNum = nums[id];
        if (currNum <= remainingSum) {
            // either pick or not
            return helper(nums, id - 1, remainingSum - currNum) || helper(nums, id - 1, remainingSum);
        } else {
            return helper(nums, id - 1, remainingSum);
        }

    }
// memoization
    private boolean helper2(int[] nums, int id, int remainingSum,int[][] dp) {
        if(remainingSum==0){
            return true;
        }
        if (id == 0) {
            if (remainingSum - nums[id] == 0) {
                return true;
            } else {
                return false;
            }
        }
        if(dp[id][remainingSum]!=-1){
            return dp[id][remainingSum] == 1? true:false;
        }
        // choices
        int currNum = nums[id];
        if (currNum <= remainingSum) {
            // either pick or not
            if(helper(nums, id - 1, remainingSum - currNum) || helper(nums, id - 1, remainingSum)){
                dp[id][remainingSum] = 1;
            }else{
                dp[id][remainingSum] = 0;
            }
        } else {
            if(helper(nums, id - 1, remainingSum)){
                dp[id][remainingSum] = 1;
            }else{
                dp[id][remainingSum] = 0;
            }
        }
        return dp[id][remainingSum] ==1?true:false;

    }
    private boolean helper3(int[] nums, int remainingSum){
        boolean[][] dp = new boolean[nums.length+1][remainingSum+1];
        int n = nums.length;
        for(int i = 0;i<n;i++){
            dp[i][0] = true;
        }
        if(remainingSum-nums[0]==0){
            dp[0][nums[0]] = true; //for index 0 possible sum is nums[0]
        }
        for(int i = 1;i<n;i++){
            for(int j = 1;j<=remainingSum;j++){
                if(nums[i]<=j){
                    
                    dp[i][j] = dp[i-1][j-nums[i]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        } 
        return dp[n-1][remainingSum];
    }
}