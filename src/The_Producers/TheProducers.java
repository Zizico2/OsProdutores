package The_Producers;
import Staff.*;
import Scenery.*;

public interface TheProducers {
    int PLANNED = 0;
    int PERFORMED = 1;

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

    String listRecordings(int arrayCode);

    String record();

    String site(String scenery);

    boolean siteExists(String scenery);
}
