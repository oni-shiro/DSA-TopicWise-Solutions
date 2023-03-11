package Arrays;


// https://leetcode.com/problems/next-permutation/
public class NextPermuation {
    public void nextPermutation(int[] A) {
        if(A == null || A.length <= 1) return;
        int i = A.length - 2;
        //find the element before the pick
        while(i >= 0 && A[i] >= A[i + 1]) i--; 
        //if exists, swap it with the element which is bigger than that
        //and also appears first from the end of arr
        if(i >= 0) {                           
            int j = A.length - 1;              
            while(A[j] <= A[i]) j--;      
            swap(A, i, j);                     
        }
        //reverse the i+1 to end to get the lexiographically next permutation
        reverse(A, i + 1, A.length - 1);      
    }
    
    public void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
    }
    
    public void reverse(int[] A, int i, int j) {
    while(i < j) swap(A, i++, j--);
    }
    
}
