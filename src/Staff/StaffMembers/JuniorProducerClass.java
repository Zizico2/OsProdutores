package Staff.StaffMembers;

import Staff.StaffMemberAbstract;
import Staff.Tags.Producer;

public class JuniorProducerClass extends StaffMemberAbstract implements Producer {

    protected JuniorProducerClass(String Name, int moneyPerHour) {
        super(Name, moneyPerHour);
    }
}
