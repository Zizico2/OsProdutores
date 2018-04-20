package Staff.StaffMembers.Vedettes;

import Staff.Tags.Director;
import Staff.VedetteAbstract;

public class VedetteDirectorClass extends VedetteAbstract implements Director {

    protected VedetteDirectorClass(String Name, int moneyPerHour) {
        super(Name, moneyPerHour);
    }

    @Override
    public void mope(String name) {

    }
}
