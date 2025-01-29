import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateArithmetic {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String inputDate = "2025-01-29";
        LocalDate date = LocalDate.parse(inputDate, formatter);

        LocalDate newDate = date.plusDays(7).plusMonths(1).plusYears(2);

        newDate = newDate.minusWeeks(3);
        
        System.out.println("Modified Date: " + newDate.format(formatter));
    }
}
