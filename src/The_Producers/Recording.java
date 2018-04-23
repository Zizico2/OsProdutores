package The_Producers;
import java.time.format.DateTimeFormatter;

public interface Recording {

    DateTimeFormatter FORMAT_DATE_TIME = DateTimeFormatter.ofPattern("yyyy M d h m");
    DateTimeFormatter FORMAT_DATE = DateTimeFormatter.ofPattern("yyyy M d");
}
