import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Problem: Stack
 * Implement a Stack class with the following methods:
 * + void push (Object object)
 * + Object pop()
 * Stack should throw an exception if popped when empty
 */

public class Stack {

    private List<Object> stack = new ArrayList();

    public Object pop() {
        if (stack.isEmpty())
            throw new EmptyStackException();

        return stack.remove(stack.size() - 1);
    }

    public void push(Object object) {
        stack.add(object);
    }
}
