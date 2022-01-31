package gen;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

/**
 * Usage
 chain()
 .enlist(
 forInteger()
 .add(addIntProperty(() -> "k1", () -> 122))
 .add(addIntProperty(() -> "k2", () -> 123))
 .add(addIntProperty(() -> "k3", () -> 124))
 .add(addIntProperty(() -> "k3", () -> 125)))
 .enlist(
 forString()
 .add(addStringProperty(() -> "k1-2", () -> "122-111"))
 .add(addStringProperty(() -> "k2-2", () -> "123-111"))
 .add(addStringProperty(() -> "k3-2", () -> "124-111"))
 .add(addStringProperty(() -> "k3-2", () -> "125-111")))
 .enlist(forCollection().add(addCollectionProperty(() -> "dddd", () -> Arrays.asList(new String[]{"aa", "bb"}))))
 .get()
 */
public abstract class ChainedProperty {

    /**
     * Usage import static ChainedProperty.chain;
     */
    public static Chain chain() {
        return Chain.init();
    }
    /**
     * Usage import static ChainedProperty.forInteger;
     */


    public static ChainBuilder<LocalDateTime> foLocalDateTime() {
        return forType(LocalDateTime.class);
    }
    public static ChainBuilder<Integer> forInteger() {
        return forType(Integer.class);
    }
    public static ChainBuilder<String> forString() {
        return forType(String.class);
    }
    public static ChainBuilder<Long> forLong() {
        return forType(Long.class);
    }
    public static ChainBuilder<Collection> forCollection() {
        return forType(Collection.class);
    }
    private static <T> ChainBuilder<T> forType(final Class<T> type) {
        return new ChainBuilder<T>() {
            @Override
            protected Class<T> getType() {
                return type;
            }
        };
    }

    public static abstract class ChainBuilder<T> {
        private ChainBuilder() {
            super();
        }

        private List<SspDynamicProperty<T>> properties = new ArrayList<SspDynamicProperty<T>>();

        public ChainBuilder<T> add(SspDynamicProperty<T> property) {
            properties.add(property);
            return this;
        }
        public List<SspDynamicProperty<T>> getProps () {return properties;};

        protected abstract Class<T> getType();
    }

    public static abstract class Chain {
        private List<ChainBuilder> properties = new ArrayList();
        private Chain() {}
        public Chain enlist(ChainBuilder builder) {
            properties.add(builder);
            return this;
        }
        public List<ChainBuilder> get() {
            return properties;
        }
        public static Chain init() {
            return new Chain() {};
        }
    }


    public static class Util {
        /**
         * Usage Usage addIntProperty(() -> "k1", () -> 122)
         * @param name
         * @param val
         * @return
         */
        public static SspDynamicProperty addIntProperty(Supplier<String> name, Supplier<Integer> val) {
            return new SspIntegerProperty() {
                @Override
                public String getName() {
                    return name.get();
                }

                @Override
                public Integer getValue() {
                    return val.get();
                }
            };
        }
        /**
         * Usage Usage addStringProperty(() -> "k1", () -> "122")
         * @param name
         * @param val
         * @return
         */
        public static SspDynamicProperty addStringProperty(Supplier<String> name, Supplier<String> val) {
            return new SspStringProperty() {
                @Override
                public String getName() {
                    return name.get();
                }

                @Override
                public String getValue() {
                    return val.get();
                }
            };
        }

        public static SspDynamicProperty<Collection> addCollectionProperty(Supplier<String> name, Supplier<Collection> val) {
            return new SspCollectionProperty() {

                @Override
                public String getName() {
                    return name.get();
                }

                @Override
                public Collection getValue() {
                    return val.get();
                }
            };
        }

        public static SspDynamicProperty<LocalDateTime> addLocalDateTimeProperty(Supplier<String> name, Supplier<LocalDateTime> val) {
            return new SspCollectionProperty() {

                @Override
                public String getName() {
                    return name.get();
                }

                @Override
                public LocalDateTime getValue() {
                    return val.get();
                }
            };
        }
    }

}
