package Staff.StaffMembers.Vedettes;

import Staff.Tags.Actor;
import Staff.VedetteAbstract;

public class VedetteActorClass extends VedetteAbstract implements Actor {

    protected VedetteActorClass(String Name, int moneyPerHour) {
        super(Name, moneyPerHour);
    }

    @Override
    public void mope(String name) {

    }
}
