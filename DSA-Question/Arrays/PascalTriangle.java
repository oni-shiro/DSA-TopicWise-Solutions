package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * if it is asked to get the number at given r,c
 * formula is nCr = n*(n-1)*(n-2)...../r(r-1)(r-2).
 * 
 * n is row and r is col
*/
//in code we can get that by
/* 

fact(r)/ (fact(c)* fact(r-c))
}

*/
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> row,prevRow = null;
        ArrayList<Integer> row,prevRow = null;
        for(int i=0;i<numRows;i++) {
            row = new ArrayList<Integer>();
            for(int j = 0; j<=i;j++){
                // as number of rows = col in pascal triange
                if(j == 0 || j == i){
                    row.add(1); // as first and last element of every row is 1
                }else{
                    row.add(prevRow.get(j-1) + prevRow.get(j));
                }
            }
            prevRow = row;
            ans.add(prevRow);
        }
        return ans;
    }
    
}
