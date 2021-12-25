package mediumtasks;

public class SearchInRotatedSortedArray {
    public static void main(String... args) {
        SearchInRotatedSortedArray app = new SearchInRotatedSortedArray();
        System.out.println(app.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
    public int search(int[] nums, int target) {

        if(nums.length ==1 && nums[0] == target) return 0;
        if(nums.length ==1 && nums[0] != target) return -1;


        int l = 0;
        int r = nums.length-1;
        int mid ;

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

    /*public int search(int[] nums, int target) {

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
    }*/
}
