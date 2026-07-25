class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int d = 0, s = 0;
        int[] time = new int[dist.length];
        for(int i=0; i<dist.length; i++){
            time[i] = (dist[i] + speed[i] - 1) / speed[i];
        }
        Arrays.sort(time);
    //     int count = 0;
    //    for(int t=0; t<time.length; t++){
    //     if(time[t]<=0) return count;
    //     if(time[t]>0) count++;
    //     for(int x=t+1; x<time.length; x++) time[x] -= 1;
    //    }
    //    return count;


    for(int minute = 0; minute<time.length; minute++){
        if(time[minute]<=minute) return minute;
   
    }
    return time.length;
    }
}