class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return ;

        int i=0, j=0;
         while(i<m && j<n){
            if(nums1[i]>nums2[j]){
                for(int p=m-1; p>=i;p--){
                    nums1[p+1]=nums1[p];
                }
                    nums1[i]=nums2[j];
                    j++;
                    i++;
                    m++;
            }
            else{
                i++;
            }
         }
         while(j<n) nums1[i++]=nums2[j++];
         
    }
}