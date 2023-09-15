package sorting_techniques;

import java.util.Arrays;


//question link : https://leetcode.com/problems/put-marbles-in-bags/
public class PutMarbels {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        //create the arr of consecutive some a[i] + a[i+1],a[i+1], a[i+2]
        long[] consecutiveSumArr = new long[n-1]; // if there ar n elements consecutve sums will be n-1
        for(int i = 0;i<n-1;i++){
            consecutiveSumArr[i] = weights[i] + weights[i+1];
        }
        System.out.println(Arrays.toString(consecutiveSumArr));
        //sort the arr
        Arrays.sort(consecutiveSumArr);
        //for every distribution first and last element will always be added
        long maxSum = weights[0]+ weights[n-1];
        long minSum = weights[0]+ weights[n-1];
        int m = consecutiveSumArr.length; // which is n-1 
        //for k partitions we need to pick k-1 combined sum
        for(int i=0;i<k-1;i++){
            minSum += consecutiveSumArr[i]; //min possible k sum lies at 0...k in the arr, as it is sorted
            maxSum += consecutiveSumArr[m-1-i]; // vice-versa, lies at the end positions
        }
        return maxSum-minSum;
    }
}
