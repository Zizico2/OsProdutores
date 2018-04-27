package Staff.StaffMembers;

import Staff.Tags.Director;
import Staff.VedetteAbstract;

public class VedetteDirectorClass extends VedetteAbstract implements Director {

    public VedetteDirectorClass(String Name, int moneyPerHour) {
        super(Name, moneyPerHour);
    }
}
