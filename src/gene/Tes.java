package gene;

import java.util.*;
import java.util.stream.Collectors;

public class Tes {



    public static void main(String[] args) {
        List<MyOb> l = new ArrayList<>();
        l.add(new MyOb("2", "A"));
        l.add(new MyOb("q", "A"));
        l.add(new MyOb("2", "B"));
        l.add(new MyOb("2", "A"));
        Optional<MyOb> o = l.stream().filter(v -> v.getType().equalsIgnoreCase("A")).findFirst();
        if(o.isPresent()) {
            System.out.println(o.get().getId());
        }
        Map<String, List<MyOb>> hh = new HashMap<>();
        hh.put(null, new ArrayList<>());
        Map<String, List<MyOb>> hh2 = hh.entrySet().stream().filter(e -> e.getKey()!=null)
        .collect(Collectors.toMap(item -> item.getKey(), item -> item.getValue()));
    System.out.println(hh2);
    /*    String s =
                l.stream().filter(v -> v.getType().equalsIgnoreCase("F"))
                .findAny()
                .get()
                .getId();
    System.out.println(s);*/
    }
}
