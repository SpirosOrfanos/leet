package mediumtasks;

public class SearchΙnRotatedSortedArray {
    public static void main(String... args) {

    }

    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length-1;

        while (l<r) {
            int mid = l+(r-l)/2;
            if (target == nums[mid]) return mid;
            if (target == nums[l]) return l;
            if (target == nums[r]) return r;
            if (nums[l]<=nums[mid]) {
                if (target>=nums[l] && target<=nums[mid]) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            } else {
                if (target>=nums[mid] && target<=nums[r]) {
                    l= mid+1;
                } else {
                    r = mid-1;
                }
            }

        }
        return -1;
    }
}
