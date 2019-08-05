package TroubleLeetCode;

public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergeNums=new int[m+n];
        int index=0;
        int i=0;
        int j=0;
        while (i<m&&j<n) {
            if (nums1[i] <= nums2[j])
                mergeNums[index++] = nums1[i++];
            else
                mergeNums[index++] = nums2[j++];
        }
        if(i<m)
            while (i<m)
                mergeNums[index++]=nums1[i++];
        if(j<n)
            while (j<n)
                mergeNums[index++]=nums2[j++];

        System.arraycopy(mergeNums,0,nums1,0,mergeNums.length);
    }
}
