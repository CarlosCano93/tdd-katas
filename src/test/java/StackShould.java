import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class StackShould {

    private final Stack stack = new Stack();

    @Test
    void throw_an_exception_if_stack_is_empty() {
        assertThrows(EmptyStackException.class,
                stack::pop);
    }

    @Test
    void pop_the_last_element_pushed() {
        Object elementOne = "element one";
        Object elementTwo = "element two";

        stack.push(elementOne);
        stack.push(elementTwo);

        assertThat(stack.pop()).isEqualTo(elementTwo);
        assertThat(stack.pop()).isEqualTo(elementOne);
    }

}
