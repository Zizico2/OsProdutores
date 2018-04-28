package Staff.StaffMembers;

import Staff.Tags.Director;
import Staff.VedetteAbstract;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

public class VedetteDirectorClass extends VedetteAbstract implements Director {

    public VedetteDirectorClass(String Name, int moneyPerHour) {
        super(Name, moneyPerHour);
    }
}
