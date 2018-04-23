package The_Producers;
import Staff.*;

public interface TheProducers {

    void register(String name, int payPerHour, String type, String subType);

    void addScenery(String site, int pricePerHour);

    StaffType checkType(StaffMember ST);

    String Staff();

    boolean duplicateName(String name);

    boolean isTypeValid(String type);

    boolean isSubTypeValid(String subType);

    boolean isSalaryValid(int i);

    String listSceneries();

}
