package Staff.StaffMembers;

import Staff.Tags.Actor;
import Staff.VedetteAbstract;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */


/**
 * Representa um Ator Vedeta.
 */
public class VedetteActorClass extends VedetteAbstract implements Actor {

    // Construtor
    public VedetteActorClass(String Name, int moneyPerHour) {
        super(Name, moneyPerHour);
    }
}
