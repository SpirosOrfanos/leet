package utils;

public class MyOtherBuilder {


    private static <T> MyBuilder<T> forType(final Class<T> type) {
        return new MyBuilder<T>() {
            @Override
            protected Class<T> getType() {
                return type;
            }
        };
    }

    public static MyBuilder<String> forString() {
        return forType(String.class);
    }
    public static MyBuilder<Integer> forInteger() {
        return forType(Integer.class);
    }
}
