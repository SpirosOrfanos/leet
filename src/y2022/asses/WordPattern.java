package y2022.asses;

import java.util.*;
public class WordPattern {
    public static void main(String[] args) {
        WordPattern app = new WordPattern();

    }
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> mapping = new HashMap<>();
        Map<Character, List<Integer>> patternMap = new HashMap<>();
        Map<String, List<Integer>> sMap = new HashMap<>();
        String[] sArray = s.split(" ");
        if(pattern.length()!=sArray.length) return false;
        int count = 0;
        for (char c : pattern.toCharArray()) {
            mapping.putIfAbsent(c, sArray[count]);
            patternMap.putIfAbsent(c, new LinkedList<>());
            patternMap.get(c).add(count);
            sMap.putIfAbsent(sArray[count], new LinkedList<>());
            sMap.get(sArray[count]).add(count);
            count++;
        }

        for (Map.Entry<Character, String> entry: mapping.entrySet()) {
            if(!patternMap.get(entry.getKey()).equals(sMap.get(entry.getValue()))) {
                return false;
            }
        }
        return true;
    }

}
