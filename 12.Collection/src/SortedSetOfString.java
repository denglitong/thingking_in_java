import java.util.Set;
import java.util.TreeSet;

/**
 * @autor denglitong
 * @date 2019/8/18
 */
public class SortedSetOfString {
    public static void main(String[] args) {
        Set<String> colors = new TreeSet<>();
        for (int i = 0; i < 100; i++) {
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Red");
            colors.add("Red");
            colors.add("Orange");
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Purple");
        }
        // TreeSet sorted elements
        System.out.println(colors);
    }
}
