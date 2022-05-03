package y2022_2.medium;

public class SearchInRotatedSortedArray {
    public static void main(String... args) {

    }

    public int search23(int[] nums, int target) {

        if(nums.length ==1 && nums[0] == target) return 0;
        if(nums.length ==1 && nums[0] != target) return -1;


        int l = 0;
        int r = nums.length-1;
        int mid = mid(l, r);
        if(target == nums[mid]) return mid;
        if(target == nums[l]) return l;
        if(target == nums[r]) return r;
        while ((l<r)) {
            mid = mid(l, r);
            if(target == nums[mid]) return mid;
            if(target == nums[l]) return l;
            if(target == nums[r]) return r;
            if (nums[l]<nums[mid]) {
                if (target>nums[l] && target<=nums[mid]) {
                    r = mid-1;
                } else {
                    l= mid+1;
                }
            } else {
                if (target>nums[mid] && target<=nums[r]) {
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }
        }
        return -1;
    }
    int mid(int l, int r) {
        return  l+((r-l/2));
    }
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        while (left<right) {
            mid = left + ((right-left)/2);
            if(target == nums[mid]) return mid;
            if(target == nums[left]) return left;
            if(target == nums[right]) return right;
            if (nums[left]<nums[mid]) {
                if (nums[left]<target && target<=nums[mid]) {
                    right = mid-1;
                } else {
                   left = mid+1;
                }
            } else {
                if (nums[right]<target && target>=nums[mid]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }


        return mid;
    }

    public boolean search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid = 0;

        while (left<right) {
            mid = left + (right-left)/2;

            if (nums[left]<nums[mid]) {
                if (nums[left]<target && target<=nums[mid]) {
                    right = mid+1;
                } else {
                    left = mid-1;
                }
            } else {
                if (nums[right]<target && target>=nums[mid]) {
                    left = mid-1;
                } else {
                    right = mid+1;
                }
            }
        }


        return mid!=-1;
    }
}
