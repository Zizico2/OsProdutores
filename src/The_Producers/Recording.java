package The_Producers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

public interface Recording {

    DateTimeFormatter FORMAT_DATE_TIME = DateTimeFormatter.ofPattern("yyyy M d h m");

    DateTimeFormatter FORMAT_DATE = DateTimeFormatter.ofPattern("yyyy M d");

    int getCost();

    String toString();

    String getScenery();

    void changeStatus();

    boolean checkStaffMember(String name);

    boolean isSuspended();

    boolean isRecordingSaved();

    LocalDateTime getDate();
}
