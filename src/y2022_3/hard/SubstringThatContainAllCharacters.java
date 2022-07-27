package y2022_3.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubstringThatContainAllCharacters {
    public static void main(String... args) {
        SubstringThatContainAllCharacters app = new SubstringThatContainAllCharacters();
        System.out.println(app.find("ttrstrrtrsr"));
    }

    String find(String str) {

        Map<Integer, Integer> map = new HashMap<>();

        char[] sa = str.toCharArray();

        for (char c:sa) {
            map.computeIfAbsent((int)c, v -> 1);
        }
        int total = map.size();
        int[] allChars = new int[256];

        for (int i = 0; i<= str.length()-total; i++) {
            Arrays.fill(allChars, 0);
            int count = 0;
            for (int j=i; j<i+total; j++ ) {
                if(allChars[str.charAt(j)] == 0) {
                    count++;
                    allChars[str.charAt(j)]++;
                }
                if(count ==total) {
                   return str.substring(i, i+total);
                }
            }

        }
        return "";
    }
}
