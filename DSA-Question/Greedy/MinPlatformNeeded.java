package Greedy;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#
public class MinPlatformNeeded {

    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
       //we are pre calculating that first arr train is at station and
       //a starts at 1 also platform req is 1
        int a = 1; 
        int d = 0;
        int currPlatform = 1;
        int maxPlatform = 1;
        while(a<n && d<n){
            if(dep[d]<arr[a]){
                //first dep happening before the second arrival
                currPlatform--;
                //we move to next departure
                d++;
            }else{
                currPlatform++;
                a++;
            }
            
            maxPlatform = Math.max(maxPlatform,currPlatform);
        }
        return maxPlatform;
    }
    
}
