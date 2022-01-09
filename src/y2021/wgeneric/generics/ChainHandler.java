package y2021.wgeneric.generics;

import java.util.*;

public abstract class ChainHandler<T> {
    private List<DynamicProperty<T>> properties =
            new ArrayList ();
    abstract Class<T> getType();
    public ChainHandler add (String name, T defaultValue) {
        return this;
    }
}
