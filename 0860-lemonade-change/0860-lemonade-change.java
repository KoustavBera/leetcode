class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives=0, tens=0;
        for(int bill : bills){
            if(bill == 5){
                fives+=1;
            }
            else if(bill==10){
                if(fives>0){
                    fives -= 1;
                    tens += 1;
                }else return false;
            }
            else{
                //20
                if(fives>0 && tens>0){
                    fives -= 1;
                    tens -= 1;
                }
                else if(fives >=3){
                    fives-=3;
                }
                else{
                    return false;
                }
            }
        }
            return true;

    }
}