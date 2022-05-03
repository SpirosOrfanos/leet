package y2022_2.medium;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String... args) {
        BoatsToSavePeople app = new BoatsToSavePeople();
    System.out.println(app.numRescueBoats(new int[]{1,1,1,1,1}, 5));
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int l = 0; int r = people.length-1;
        int ans = 0;
        while(l <= r) {
            if (people[r] + people[l] <= limit) {
                l++; r--;
            } else {

                r--;
            }
            ans++;
        }
        return ans;
    }
}
