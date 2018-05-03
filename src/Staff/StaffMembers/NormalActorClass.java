package Staff.StaffMembers;

import Staff.StaffMemberAbstract;
import Staff.Tags.Actor;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

/**
 * Representa um Ator Normal.
 */
public class NormalActorClass extends StaffMemberAbstract implements Actor {

    // Construtor
    public NormalActorClass(String Name, int moneyPerHour) {
        super(Name, moneyPerHour);
    }
}
