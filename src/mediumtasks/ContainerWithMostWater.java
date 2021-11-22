package mediumtasks;

//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    public static void main(String... args) {
        ContainerWithMostWater app = new ContainerWithMostWater();
        System.out.println(app.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(app.maxArea(new int[]{1,1}));
        System.out.println(app.maxArea(new int[]{4,3,2,1,4}));

    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = Integer.MIN_VALUE;
        while(l<r) {
            int area = (r-l) * (height[l]>height[r]?height[r]:height[l])/*Math.min(height[l], height[r])*/;
            max = max>area ? max : area;//Math.max(max, area);
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }

        return max;
    }
}
