package jinny.app.lottery;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class SetTest {

    @Test
    public void setAddTest() {
        Set<String> target = new HashSet<>();
        target.add("A");
        target.add("A");

        Set<String> object = new HashSet<>();
        object.add("A");
        object.add("B");

        boolean a = target.contains(object);

        System.out.println(a);

        System.out.println(target);

    }

}
