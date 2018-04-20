package The_Producers;

import Array.*;
import Staff.*;

public interface TheProducers {

    void add(String name, int payPerHour, StaffType type);

    Array<StaffMember> staff();

    StaffType getType(StaffMember ST);

    String Staff();





}
