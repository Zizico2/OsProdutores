package Staff.StaffMembers;

import Staff.StaffMemberAbstract;
import Staff.Tags.Director;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

public class NormalDirectorClass extends StaffMemberAbstract implements Director {

    public NormalDirectorClass(String Name, int moneyPerHour) {
        super(Name, moneyPerHour);
    }
}
