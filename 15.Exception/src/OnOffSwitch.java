/**
 * @autor denglitong
 * @date 2019/9/13
 */
public class OnOffSwitch {
    private static Switch sw = new Switch();
    public static void f() throws OnOffException1, OnOffException2 {}

    public static void main(String[] args) {
        try {
            sw.on();
            // code that can throw exceptions...
            f();
            sw.off();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
            // sw.off();
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
            // sw.off();
        } finally {
            sw.off();
        }
    }
}
