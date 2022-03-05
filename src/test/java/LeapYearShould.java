import org.junit.jupiter.api.Test;

public class LeapYearShould {

    private LeapYear leapYear;

    @Test
    public void return_true_if_is_a_leap_year() {
        leapYear = new LeapYear();

        assert leapYear.isLeap(1996);
        assert !leapYear.isLeap(2001);

        assert leapYear.isLeap(2000);
        assert !leapYear.isLeap(1900);
    }
}
