import java.util.ArrayList;
import java.util.List;

/**
 * Objective
 * ● Naming convention
 * ● Create production code from test
 * ● Start from assertion
 * <p>
 * Problem: Stack
 * Implement a Stack class with the following methods:
 * + void push (Object object)
 * + Object pop()
 * Stack should throw an exception if popped when empty
 */

public class Stack {

    private final List<Object> stack = new ArrayList<>();

    public Object pop() {
        Object object = stack.get(stack.size() - 1);
        stack.remove(object);

        return object;
    }

    public List<Object> getStack() {
        return stack;
    }

    public void push(Object o) {
        stack.add(o);
    }
}
