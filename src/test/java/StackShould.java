import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StackShould {

    private final Stack stack = new Stack();


    @Test
    void throw_exception_if_popped_when_empty() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, stack::pop);
    }

    @Test
    void add_object_when_push() {
        stack.push(new Object());
        stack.push(new Object());

        Assertions.assertEquals(2, stack.getStack().size());
    }

    @Test
    void return_and_remove_object_when_pop() {
        var object = new Object();
        stack.push(object);

        Assertions.assertEquals(1, stack.getStack().size());
        Assertions.assertEquals(object, stack.pop());
        Assertions.assertEquals(0, stack.getStack().size());
    }
}