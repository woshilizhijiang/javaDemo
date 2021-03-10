package mycom.stream.lambda.analyse;

/**
 * Created by 20013649 on 2020/6/28.
 */
@FunctionalInterface
public interface Print<T> {
    void print(T t);
    static void staticMethod() {
        System.out.println("static method");
    }
    default void print() {
        System.out.println("hello default");
    }
}
