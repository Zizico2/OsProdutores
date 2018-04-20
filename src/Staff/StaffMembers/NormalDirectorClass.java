package Staff.StaffMembers;

import Staff.StaffMemberAbstract;
import Staff.Tags.Director;

public class NormalDirectorClass extends StaffMemberAbstract implements Director {

    protected NormalDirectorClass(String Name, int moneyPerHour) {
        super(Name, moneyPerHour);
    }
}
