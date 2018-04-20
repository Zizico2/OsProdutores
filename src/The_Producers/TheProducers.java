package The_Producers;
import Staff.*;

public interface TheProducers {

    void add(String name, int payPerHour, StaffType type);

    StaffType getType(StaffMember ST);

    String Staff();

}
