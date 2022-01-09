package y2021.wgeneric.generics;

public interface DynamicProperty<T> extends GenericProperty<T>{
    String getName();
    void addCallback(Runnable r);
}
