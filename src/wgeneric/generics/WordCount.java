package wgeneric.generics;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String... args) throws IOException {
        String str = "The big brown Fox fell into the big brown hole";
        List<String> strs = new ArrayList<>();
        strs.add("The big brown Fox fell into the big brown hole");
        strs.add("The red dog barks to the big red postman");

        Map<String, Integer> sss = strs.stream()
                .flatMap(v -> Arrays.stream(v.split(" ")))
                //.collect(Collectors.toList())
               // .stream()
                .collect(Collectors.toMap( w -> w.toLowerCase(), w -> 1, Integer::sum ));
        System.out.println();
    }
}
