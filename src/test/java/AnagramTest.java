import org.junit.Test;
import org.mockito.Mock;

import java.io.Console;
import java.util.List;


public class AnagramTest {

    @Mock
    Console console;

    private final List<String> biroList = List.of(
            "biro", "bior", "brio", "broi", "boir", "bori",
            "ibro", "ibor", "irbo", "irob", "iobr", "iorb",
            "rbio", "rboi", "ribo", "riob", "roib", "robi",
            "obir", "obri", "oibr", "oirb", "orbi", "orib");

    @Test
    public void return_all_possible_anagrams() {
        assert Anagram.of("ab").containsAll(List.of("ab", "ba"));
        assert Anagram.of("ABC").containsAll(List.of(
                "ABC",
                "ACB",
                "BAC",
                "BCA",
                "CAB",
                "CBA"));

        assert Anagram.of("biro").containsAll(biroList);
    }
}