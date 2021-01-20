/**
 * 利用继承机制实现更长的元组
 * 有了泛型，可以很容易地创建元组，令其返回一组任意类型的对象
 *
 * @author denglitong
 * @date 2021/1/17
 */
public class Tuple3<A, B, C> extends Tuple2<A, B> {
    public final C a3;

    public Tuple3(A a1, B a2, C a3) {
        super(a1, a2);
        this.a3 = a3;
    }

    @Override
    public String rep() {
        return super.rep() + ", " + a3;
    }
}
