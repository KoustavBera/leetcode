
class Solution {
    public int minInsertions(String s) {
      int count = 0;
      int result = 0; //insertions
      int i = 0;
      int n = s.length();

      while(i < n){
        char c = s.charAt(i);
        if(c == '('){
            count++;
            i++;
        }
        else{ // ')')
            //check if is ')'
                //then check if ( was present before by checking count
                if(count > 0){
                    //( present so, consume count
                    count--;
                }
                else{
                    //if ( not present then we need one insertion
                    result++;
                }

            //check if next is )
            if(i+1<n && s.charAt(i+1)== ')'){
                i+=2; //jump to that index
            }else{
                result++; //insert ) at this
                i++;
            }
        }
      }
        return result + 2* count;

    }    
}
