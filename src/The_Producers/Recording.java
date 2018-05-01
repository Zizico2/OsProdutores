package The_Producers;

import Staff.StaffMember;
import Staff.Tags.Producer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

public interface Recording {

    DateTimeFormatter FORMAT_DATE = DateTimeFormatter.ofPattern("yyyy M d");

    int getCost();

    String toStringExtra();

    String getScenery();

    void changeStatus();

    boolean hasStaffMemberNamed(String name);

    boolean isSuspended();

    boolean isRecordingSaved();

    LocalDateTime getStartingDate();

    LocalDateTime getEndDate();

    StaffMember getProducer();
}
