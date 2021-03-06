/**
 * @autor denglitong
 * @date 2019/7/28
 */

class Useful {
    public void f() {}
    public void g() {}
}

class MoreUseful extends Useful {
    @Override
    public void f() {
        super.f();
    }

    @Override
    public void g() {
        super.g();
    }

    public void u() {}
    public void v() {}
    public void w() {}
}

public class RTTI {
    public static void main(String[] args) {
        Useful[] x = {
                new Useful(),
                new MoreUseful(),
        };
        x[0].f();
        x[1].g();
        // x[1].u();
        ((MoreUseful) x[1]).u(); // Downcast
        ((MoreUseful) x[0]).u(); // ClassCastException thrown
    }
}
