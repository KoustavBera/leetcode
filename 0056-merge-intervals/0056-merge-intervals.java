class Solution {
    public int[][] merge(int[][] intervals) {
        //sort intervals based on their start time
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));

        //Initialise merge list
        List<int[]> merge = new ArrayList<>();

        //traverse and check the overlapping condition
        for(int[] current : intervals){
            //1. not overlap / merge empty -> merge curr
            if(merge.size()==0 || merge.get(merge.size()-1)[1] < current[0])
            merge.add(current);
            //2. if they overlap, update merge.get(merge.length-1)[1] to the Max(merge,  curr[1])
            else
            merge.get(merge.size()-1)[1] = Math.max(merge.get(merge.size()-1)[1],current[1]);
        }
        return merge.toArray(new int[merge.size()][]);
    }
}