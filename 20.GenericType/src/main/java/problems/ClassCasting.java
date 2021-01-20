package problems;

import apple.laf.JRSUIConstants;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author denglitong
 * @date 2021/1/20
 */
public class ClassCasting {
    @SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(args[0]));
        // List<JRSUIConstants.Widget> lw1 = List<>.class.cast(in.readObject());
        List<JRSUIConstants.Widget> lw2 = List.class.cast(in.readObject());
        // List<JRSUIConstants.Widget> lw3 =
        //         List<JRSUIConstants.Widget>.class.cast(in.readObject());
    }
}
