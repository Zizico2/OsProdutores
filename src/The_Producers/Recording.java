package The_Producers;

import Staff.StaffMember;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

interface Recording {

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

    int getDuration();

    String[] getStaff();

    void changeDate(LocalDateTime tempStartDate);
}
