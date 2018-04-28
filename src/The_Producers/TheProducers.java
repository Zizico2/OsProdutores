package The_Producers;
import Staff.*;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

public interface TheProducers {

    void register(String name, int payPerHour, String type, String subType);

    void addScenery(String site, int pricePerHour);

    StaffType checkType(StaffMember ST);

    String staff();

    boolean duplicateName(String name);

    boolean isTypeValid(String type);

    boolean isSubTypeValid(String subType);

    boolean isCostValid(int i);

    String listSceneries();

    boolean duplicateSceneryName(String name);

    void scheduleRecording(String scenery, int[] localDateTime, String[] names);

    String listPlannedRecordings();

    String listPerformedRecordings();

    String record();

    String site(String scenery);

    boolean siteExists(String scenery);

    boolean staffMemberExists(String name);

    String staffMember(String name);

    String poutances(String name);

    int mope(String bullyName, String victimName);

    int reconcile(String exBullyName, String exVictimName);

    boolean isThereAFightWith(String exBullyName, String exVictimName);

    boolean isThereAVedetteNamed(String name);
}
