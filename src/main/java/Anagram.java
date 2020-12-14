import java.util.ArrayList;
import java.util.List;

public class Anagram {

    public static List<String> of(String someString) {

        if (someString.length() == 1)
            return List.of(someString);

        List<String> anagrams = new ArrayList<>();
        for (int i = 0; i < someString.length(); i++) {
            List<String> anagramOfCutString = Anagram.of(removeChar(someString, i));
            for (String str : anagramOfCutString) {
                anagrams.add(someString.charAt(i) + str);
            }
        }

        return anagrams;
    }

    private static String removeChar(String someString, int index) {
        return new StringBuffer(someString).deleteCharAt(index).toString();
    }
}
