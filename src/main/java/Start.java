import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Start {
    public static void main(String[] args) {

        String data1 ="31-12-2022";
        LocalDate data1LD = LocalDate.parse(data1, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(data1LD);
        String data2 ="01/10/2022";
        LocalDate data2LD = LocalDate.parse(data2,DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(data2LD);

    }
}
