package y2022.mid;

public class ContaimerWithMostWater {
    public static void main(String[] args) {
        ContaimerWithMostWater app = new ContaimerWithMostWater();

    System.out.println(app.maxArea(new int []{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l<r) {
            int top = Math.min(height[l], height[r]);
            max = Math.max(max, (r-l)*top);
            if (height[l]<height[r]) l++; else r--;
        }
        return max;
    }
}
