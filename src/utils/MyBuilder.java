package utils;

import java.util.ArrayList;
import java.util.List;

public abstract class MyBuilder<T> {
    abstract Class<T> getType();
    private List<Proe<T>> properties = new ArrayList<Proe<T>>();
    public MyBuilder<T> add(String name, T defaultValue) {
        properties.add(getDynamicProperty(name, defaultValue, getType()));
        return this;
    }
    private static <T> Proe<T> getDynamicProperty(String propName, T defaultValue, Class<T> type) {
        HystrixDynamicProperties properties = HystrixPlugins.getInstance().getDynamicProperties();
        Proe<T> p =
                HystrixDynamicProperties.Util.getProperty(properties, propName, defaultValue, type);
        return p;
    }
}
