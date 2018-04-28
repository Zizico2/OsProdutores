package Staff.StaffMembers;

import Staff.StaffMemberAbstract;
import Staff.Tags.Producer;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

public class SeniorProducerClass extends StaffMemberAbstract implements Producer {

    public SeniorProducerClass(String Name, int moneyPerHour) {
        super(Name, moneyPerHour);
    }
}
