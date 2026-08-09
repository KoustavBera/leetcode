class Solution {
    public int[] validSequence(String word1, String word2) {
       int i=0, j=0, k = 0, used = 0;
       int[] arr = new int[word2.length()];
       int[] rightHandSideMatch = new int[word1.length()+1];
       i = word1.length()-1;
       j = word2.length()-1;
       int rightMatched = 0;
       while(i>=0){
        if(j>=0 && word1.charAt(i) == word2.charAt(j)){
            rightMatched +=1;
            j--;
        }
        rightHandSideMatch[i] = rightMatched;
        i--;
       }
        i=0; j=0;
        while(i<word1.length() && j<word2.length()){
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(j);
            if(c1 == c2){
                arr[k++]=i;
                i++;
                j++;
            }
            if(c1!=c2){
                //check if we can transform
                if(used==0 &&  rightHandSideMatch[i+1] >= word2.length()-j-1){
                    used = 1;
                    arr[k++] = i;
                    i++;
                    j++;
                }
                else{
                    //used already so just move the word1 pointer
                    i++;
                }
            }
        }
        return j==word2.length() ? arr : new int[0];
    }
}