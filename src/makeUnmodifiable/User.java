package makeUnmodifiable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//public class User {
public final class User {
//    private String name;
    private final String name;
//    private List<Integer> integers;
    private final List<Integer> integers;

    public User(String name, List<Integer> integers) {
        this.name = name;
        this.integers = Collections.unmodifiableList(integers);
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public List<Integer> getIntegers() {
        return integers;
    }

//    public void setIntegers(List<Integer> integers) {
//        this.integers = integers;
//    }
}
