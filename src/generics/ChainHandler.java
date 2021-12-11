package generics;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.*;

public abstract class ChainHandler<T> {
    private List<DynamicProperty<T>> properties =
            new ArrayList ();
    abstract Class<T> getType();
    public ChainHandler add (String name, T defaultValue) {
        return this;
    }
}
