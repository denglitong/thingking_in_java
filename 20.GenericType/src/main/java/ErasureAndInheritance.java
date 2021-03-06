/**
 * @author denglitong
 * @date 2021/1/18
 */
class GenericBase<T> {
    private T element;

    public void set(T element) {
        this.element = element;
    }

    public T get() {
        return element;
    }
}

class Derived1<T> extends GenericBase<T> {}
class Derived2 extends GenericBase {} // No warning
// class Derived3 extends GenericBase<?> {}

public class ErasureAndInheritance {
    // @SuppressWarnings("unchecked") // 关闭告警
    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj); // warning here
    }
}
