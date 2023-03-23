package Arrays;
// https://leetcode.com/problems/sort-colors/description/
public class DnfSort {

    /*
     * 
     * idea is to keep 0s at left of low,
     * 1s at low-mid
     * 2 at hign to end
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n-1;
        
        while(mid<=high){
            switch(nums[mid]){
                case 0 :
                    swap(nums,low,mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                    
                case 2:
                    swap(nums,mid,high);
                    high--;
            }
        
        }
    }
    
    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
}
