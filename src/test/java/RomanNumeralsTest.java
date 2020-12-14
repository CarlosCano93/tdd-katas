import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumeralsTest {

    @Test
    void number_cast_from_arabic_to_roman() {
        var romanianNumerals = new RomanNumerals();

        assertEquals("I", romanianNumerals.build().cast(1));
        assertEquals("II", romanianNumerals.build().cast(2));
        assertEquals("III", romanianNumerals.build().cast(3));
        assertEquals("IV", romanianNumerals.build().cast(4));
        assertEquals("V", romanianNumerals.build().cast(5));
        assertEquals("VI", romanianNumerals.build().cast(6));
        assertEquals("VII", romanianNumerals.build().cast(7));
        assertEquals("VIII", romanianNumerals.build().cast(8));
        assertEquals("IX", romanianNumerals.build().cast(9));

        assertEquals("X", romanianNumerals.build().cast(10));
        assertEquals("XX", romanianNumerals.build().cast(20));
        assertEquals("XXX", romanianNumerals.build().cast(30));
        assertEquals("XL", romanianNumerals.build().cast(40));
        assertEquals("L", romanianNumerals.build().cast(50));
        assertEquals("LX", romanianNumerals.build().cast(60));
        assertEquals("LXX", romanianNumerals.build().cast(70));
        assertEquals("LXXX", romanianNumerals.build().cast(80));
        assertEquals("XC", romanianNumerals.build().cast(90));

        assertEquals("C", romanianNumerals.build().cast(100));
        assertEquals("CC", romanianNumerals.build().cast(200));
        assertEquals("CCC", romanianNumerals.build().cast(300));
        assertEquals("CD", romanianNumerals.build().cast(400));
        assertEquals("D", romanianNumerals.build().cast(500));
        assertEquals("DC", romanianNumerals.build().cast(600));
        assertEquals("DCC", romanianNumerals.build().cast(700));
        assertEquals("DCCC", romanianNumerals.build().cast(800));
        assertEquals("CM", romanianNumerals.build().cast(900));
        assertEquals("M", romanianNumerals.build().cast(1000));

        assertEquals("DCCCXLVI", romanianNumerals.build().cast(846));
        assertEquals("MCMXCIX", romanianNumerals.build().cast(1999));
        assertEquals("MMVIII", romanianNumerals.build().cast(2008));

    }
}