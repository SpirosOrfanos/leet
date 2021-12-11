package generics;

public interface DynamicProperty<T> extends GenericProperty<T>{
    String getName();
    void addCallback(Runnable r);
}
