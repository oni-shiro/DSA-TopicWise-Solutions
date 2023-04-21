package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class GfgTopArrayQuestions {

    //Peak element: https://practice.geeksforgeeks.org/problems/peak-element/1
    public int peakElement(int[] arr,int n)
    {
       //add code here.
       
       if(n==1){
           return 0;
       }
       if(n==2){
           if(arr[0]>=arr[1]) return 0;
           else if(arr[1]>=arr[0]) return 1;
       }
       for(int i = 0;i<n;i++){
           if(i==0){
               if(arr[i]>=arr[i+1]) return i;
           }
           if(i==n-1){
               if(arr[i]>=arr[i-1]) return i;
           }
           if(i!=0 && i!=n-1 && arr[i]>=arr[i-1] && arr[i]>=arr[i+1]) return i;
       }
       return -1;
    }

    //rotate right

    public void rotate(int arr[], int n)
    {
        int temp = arr[n-1];
        for(int i = n-1;i>0;i--){
           arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }


    //max prod subarr
    public int maxProduct(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        long prod = 1;
        long maxProd=Integer.MIN_VALUE;
        //check from first to last
        for(int i=0;i<n;i++){
            prod *= nums[i];
            maxProd=Math.max(maxProd,prod);
            if(prod==0 ){
                prod=1;
            }
        }
        //check from last to first
        prod = 1;
        for(int i=n-1;i>=0;i--){
            prod *= nums[i];
            maxProd=Math.max(maxProd,prod);
            if(prod==0 ){
                prod=1;
            }
        }
        
        return maxProd == Integer.MIN_VALUE ? 0 : (int)maxProd;
    }

    /** Minimise the maximum height difference */
    // https://leetcode.com/problems/smallest-range-ii/
    //explanation : https://leetcode.com/problems/smallest-range-ii/solutions/3040404/explained-with-visualization-15-languages-beginner-level/?orderBy=most_votes

    public int smallestRangeII(int[] nums, int k) {
        
        // Number of Elements
        int N  = nums.length;
      
        // Sort so that we can have partition
        Arrays.sort(nums);

        // Trivial Case, all incremented OR all decremented
        int score = nums[N-1] - nums[0];

        // To store minimum score
        int ans   = score;

        // Check all N-1 Non-Trivial partitions/walls. 
        // Both sets will be non-empty   
        for (int divider = 0; divider < N-1; divider++){

            // Compute maximum and minimum after partitioning
            // Kudos! We only have two candidates for each
            int maximumAfterDivision = Math.max(nums[divider]    + k , nums[N-1] - k);
            int minimumAfterDivision = Math.min(nums[divider+1]  - k , nums[0]  + k);

            // Score after dividing here
            score = maximumAfterDivision - minimumAfterDivision;

            // ans will be minimum score
            ans = Math.min(ans, score);
        }
        
        // return answer
        return ans;
    }

    //spiral matrix
    static ArrayList<Integer> spirallyTraverse(int m[][], int r, int c)
    {
       ArrayList<Integer> ar=new ArrayList<>();
       int top=0,bottom=r-1,left=0,right=c-1;
       while(top<=bottom&&left<=right){
           for(int i=left;i<=right;i++)
           ar.add(m[top][i]);
           top++;
           if(top>bottom) break;
           
           for(int i=top;i<=bottom;i++)
           ar.add(m[i][right]);
           right--;
           if(left>right) break;
           
           for(int i=right;i>=left;i--)
           ar.add(m[bottom][i]);
           bottom--;
           
           for(int i=bottom;i>=top;i--)
           ar.add(m[i][left]);
           left++;
       }
       return ar;
    }
}
