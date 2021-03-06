package problems;

/**
 * 自限定
 * 自限定的参数意义：可以保证类型参数必须与正在被定义的类相同
 * 自限定只能强制作用于继承关系
 * 如果使用自限定，就应该了解这个类所用的类型参数将于使用这个参数的类具有相同的基类型
 *
 * @author denglitong
 * @date 2021/1/20
 */
class SelfBounded2<T extends SelfBounded2<T>> {
    T element;
    SelfBounded2<T> set(T arg) {
        element = arg;
        return this;
    }
    T get() { return element; }
}

class A extends SelfBounded2<A> {}
class B extends SelfBounded2<B> {}

class C extends SelfBounded2<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}

class D {}

// Type parameter 'problems.D' is not within its bound;
// should extend 'problems.SelfBounded2<problems.D>'
// class E extends SelfBounded2<D> {}

class F extends SelfBounded2 {}

public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();
        C c = new C();
        c = c.setAndGet(new C());
    }
}
