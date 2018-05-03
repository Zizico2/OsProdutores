package Staff.StaffMembers;

import Staff.Tags.Director;
import Staff.VedetteAbstract;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

/**
 * Representa um Diretor Vedeta.
 */

public class VedetteDirectorClass extends VedetteAbstract implements Director {

    // Construtor
    public VedetteDirectorClass(String Name, int moneyPerHour) {
        super(Name, moneyPerHour);
    }
}
