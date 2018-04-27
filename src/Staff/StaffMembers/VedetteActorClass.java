package Staff.StaffMembers;

import Staff.Tags.Actor;
import Staff.VedetteAbstract;

public class VedetteActorClass extends VedetteAbstract implements Actor {

    public VedetteActorClass(String Name, int moneyPerHour) {
        super(Name, moneyPerHour);
    }
}
