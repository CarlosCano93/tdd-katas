public class LeapYear {

    public boolean isLeap(int year) {

        if(year % 4 == 0
                && year % 100 == 0
                && year % 400 == 0)
            return true;

        if (year % 4 == 0
                && year % 100 == 0)
            return false;

        return year % 4 == 0;
    }
}
