class Solution {
    public boolean stoneGameIX(int[] stones) {
        int c0=0, c1=0, c2=0;
        for(int stone : stones){
            if(stone % 3 == 0)  c0++;
            if(stone % 3 == 1)  c1++;
            if(stone % 3 == 2)  c2++;
        }

        if(c0 % 2 ==0){
            //if no of 0s is even, they act as passes and give advantage to both players.
            //so what really matters is who starts the game.
            //Alice starts the game.
            //now Alice has full advantage
            //Alice just needs to have c1 and c2 > 0, then accordingly she can make the trap for Bob to loose
            return c1 > 0 && c2 > 0;
        }
        else{
            //if no of 0s is odd,
            //then only one player has the advantage
            //then we check who will be the last person to make the move
            //if abs diff of c1 and c2 > 2,
            return Math.abs(c1 - c2) > 2;
        }
    }
}