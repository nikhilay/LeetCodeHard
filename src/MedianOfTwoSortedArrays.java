/**
 * Created by Nikhil on 12/26/16.
 */

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        if(m==0){
            if(n==1) return nums2[0];
            if(n%2==1){
                return nums2[n/2];
            }else{
                return (double)(nums2[n/2]+nums2[(n/2)-1])/2;
            }
        }

        int left = 0;
        int right = m;
        while (left <= right) {

            int cut1 = left + (right - left) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;

            int a1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int a2 = cut1 == m ? Integer.MAX_VALUE : nums1[cut1];

            int b1 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int b2 = cut2 == n ? Integer.MAX_VALUE : nums2[cut2];

            if (a1 <= b2 && b1 <= a2) {
                if ((m + n) % 2 == 0) {
                    return (double) (Math.max(a1, b1) + Math.min(a2, b2)) / 2.0;
                } else {
                    return Math.max(a1, b1);
                }

            } else if (a1 > b2) {
                right = cut1 - 1;
            } else {
                left = cut1+1;
            }
        }
        return 0;

    }
}
