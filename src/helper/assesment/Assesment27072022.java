package helper.assesment;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Assesment27072022 {
    public static void main(String[] args) {
        List<List<String>> list = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"));
        System.out.println(list);
        System.out.println(list
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
        String dd = list
                .stream()
                .flatMap(Collection::stream)
                .reduce((s, s2) -> ""+s+"-"+s2)
                .get();
    System.out.println(dd);
        System.out.println(list
                .stream()
                .flatMap(Collection::stream)
                .limit(1)
                .collect(Collectors.toList()));

    }
}
enum TrafficLight {
    RED, YELLOW, GREEN;
}

interface  I1 {
    interface a2{}
}
class P {
    private int var = 100;
    class Q {
        String var = "Java";
        void print() {
            System.out.println(var);
        }
    }
}

class MyResource implements AutoCloseable {
    @Override
    public void close() throws IOException {
        throw new IOException("IOException");
    }

    public void execute() throws SQLException {
        throw new SQLException("SQLException");
    }


}

class On {
    String s;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        On on = (On) o;
        return Objects.equals(s, on.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s);
    }
}
