package Staff.StaffMembers;

import Staff.StaffMemberAbstract;
import Staff.Tags.Actor;

public class NormalActorClass extends StaffMemberAbstract implements Actor {

    protected NormalActorClass(String Name, int moneyPerHour) {
        super(Name, moneyPerHour);
    }
}
