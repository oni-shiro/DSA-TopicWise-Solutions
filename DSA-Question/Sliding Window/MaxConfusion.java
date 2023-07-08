public class MaxConfusion{
    private int getMaxLenForOneType(String s,int k, char type){
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int cntOfOpposite = 0;

        while(j<n){
            //when type is t we check if character is f and vice versa
            if(s.charAt(j)!= type){
                cntOfOpposite++;
            }
            while(cntOfOpposite>k){
                if(s.charAt(i)!=type){
                    cntOfOpposite--;
                }
                i++;
            }
            maxLen = Math.max(maxLen,j-i+1);

            j++;
        }
        return maxLen;
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxLenForT = getMaxLenForOneType(answerKey,k,'T');
        int maxLenForF = getMaxLenForOneType(answerKey,k,'F');
        return Math.max(maxLenForT,maxLenForF);
    }
}