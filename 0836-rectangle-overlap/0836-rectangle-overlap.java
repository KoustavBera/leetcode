class Solution {
    public boolean isRectangleOverlap(int[] r1, int[] r2) {
        //  x1 y1 x2 y2
        // [ 1  2  3  4]
        // r2 is left of r1
        if(r2[2] <= r1[0]) return false;
        //r1 is left of r2
        if(r1[2] <= r2[0]) return false;
        //r2 is below r1
        if(r2[3] <= r1[1]) return false;
        //r1 is below r2
        if(r1[3] <= r2[1]) return false;
        //else it overlaps
        return true;
    }
}