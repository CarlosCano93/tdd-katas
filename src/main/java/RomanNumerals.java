import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class RomanNumerals {

    private final Map<Integer, String> mapping = new TreeMap<>(Collections.reverseOrder());
    private String roman;

    public String cast(int arabic) {

        for (Map.Entry entry : mapping.entrySet()) {

            while (arabic >= (int) entry.getKey()) {
                roman += entry.getValue();
                arabic -= (int) entry.getKey();
            }
        }

        return roman;
    }

    public RomanNumerals build() {
        roman = "";
        mapping.put(1000, "M");
        mapping.put(900, "CM");
        mapping.put(500, "D");
        mapping.put(400, "CD");
        mapping.put(100, "C");
        mapping.put(90, "XC");
        mapping.put(50, "L");
        mapping.put(40, "XL");
        mapping.put(10, "X");
        mapping.put(9, "IX");
        mapping.put(5, "V");
        mapping.put(4, "IV");
        mapping.put(1, "I");

        return this;
    }
}
