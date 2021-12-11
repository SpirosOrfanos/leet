package wgeneric.generics;

public abstract class PropertiesWrapper {
    private static <T>  ChainHandler<T> forType(final Class<T> type) {
        return new ChainHandler<T>() {
            @Override
            protected Class<T> getType() {
                return type;
            }
        };
    }
    public static ChainHandler<Integer> forInteger() {
        return forType(Integer.class);
    }
    public static ChainHandler<String> forString() {
        return forType(String.class);
    }
    public static ChainHandler<Boolean> forBoolean() {
        return forType(Boolean.class);
    }
/*
    private static <T> DynamicProperty<?> getDynamicProperty(String propName, T defaultValue, Class<T> type) {
       if (type == String.class) {
            return enString(propName, null);
       } else if (type == Integer.class) {

       } else {
           return null;
       }
    }*/

    private static DynamicProperty<String> enString(String propName, String defaultValue) {
        return new DynamicProperty<String>() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public void addCallback(Runnable r) {

            }

            @Override
            public String get() {
                return "ok";
            }
        };
    }

    private static DynamicProperty<Integer> enInteger(String propName, Integer defaultValue) {
        return new DynamicProperty<Integer>() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public void addCallback(Runnable r) {

            }

            @Override
            public Integer get() {
                return 12;
            }
        };
    }
}
