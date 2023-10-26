import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

    public class DateOddChecker {
        public static boolean isDateOdd(String date) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH);
                LocalDate parsedDate = LocalDate.parse(date.charAt(0) + date.substring(1).toLowerCase(), formatter);

                int dayNumber = parsedDate.getDayOfYear();

                return dayNumber % 2 != 0;
            } catch (Exception e) {

                return false;
            }
        }

        public static void main(String[] args) {
            String date1 = "JANUARY 1 2000";
            String date2 = "JANUARY 2 2020";

            System.out.println(isDateOdd(date1));
            System.out.println(isDateOdd(date2));
        }
    }


