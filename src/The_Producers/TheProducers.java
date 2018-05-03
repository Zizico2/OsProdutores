package The_Producers;


/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

@SuppressWarnings("BooleanMethodIsAlwaysInverted")
public interface TheProducers {

    void register(String name, int payPerHour, String type, String subType);

    void addScenery(String site, int pricePerHour);

    String staff();

    String listSceneries();

    boolean duplicateSceneryName(String name);

    void scheduleRecording(String scenery, int[] localDateTime, String[] names, boolean suspended);

    String listPlannedRecordings();

    String listPerformedRecordings();

    String record();

    String site(String scenery);

    String staffMember(String name);

    String poutances(String name);

    int mope(String bullyName, String victimName);

    int reconcile(String exBullyName, String exVictimName);

    boolean isSubTypeValid(String subType);

    boolean isCostInvalid(int i);

    boolean isDateValid(int[] dateArray);

    boolean isThereAStaffMemberNamed(String name);

    boolean isThereASiteNamed(String scenery);

    boolean isTypeValid(String type);

    boolean isThereAFightWith(String exBullyName, String exVictimName);

    boolean isThereAVedetteNamed(String name);

    boolean isDurationValid(int duration);

    boolean isThereAProducerNamed(String name);

    boolean isThereADirectorNamed(String name);

    boolean isThereATechnicianNamed(String name);

    boolean isThereStaffMembersNamed(String[] names, int numberOfStaffMembers);

    boolean isThereFightsBetweenThisStaff(String[] names);

    boolean isThereDatesConflict(String scenery, int[] date, String[] names);

    boolean isReschuleNeeded(String scenery, int[] date, String[] names);

    void reschedule(String sceneryName, int[] date, String[] names);
}
