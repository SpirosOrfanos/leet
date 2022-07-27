package y2022_3.medium;

import java.io.IOException;
import java.sql.SQLException;
import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public  static void main(String... args) {
        int [] arr = {3,1,2,5,6,4};
        KthLargestElementInArray app = new KthLargestElementInArray();
        app.findKthLargest(arr, 2);
    }

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue();

        int i = 0;
        for (;i<k; i++) {
            pq.add(nums[i]);
        }
        if (nums.length<=k) return pq.peek();
        for (;i<nums.length; i++) {
            if (pq.peek()<nums[i]) {
                pq.remove();
                pq.add(nums[i]);

            }
        }

        return pq.peek();
    }

}


