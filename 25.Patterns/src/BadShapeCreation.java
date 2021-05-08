/**
 * 工厂模式
 * 当需要添加新类型到系统中时，合理的第一步是使用多态为这些新类型创建一个通用接口；
 * 这看起来需要更改的唯一地方就是你继承新类型的地方，但这并不完全正确，
 * 你仍然必须创建新类型的对象并且需要指定要使用的确切构造器；
 * 因此如果创建对象的代码分布在整个应用程序中，你仍然必须追查你代码中新类型碍事的所有地方；
 * <p>
 * 新类型的创建可能会引起问题，而不是类型的使用（通过多态处理）
 * 工厂模式就是解决这个问题的，通过将类型对象的创建归集到工厂类中，在需要添加新类型时修改工厂类即可
 * <p>
 * 每个面向对象的程序都会创建对象，并通过添加新类型来扩展程序，因此工厂模式是最通用的模式之一
 *
 * @author litong.deng@foxmail.com
 * @date 2021/5/7
 */
public class BadShapeCreation extends RuntimeException {
    public BadShapeCreation(String message) {
        super(message);
    }
}
