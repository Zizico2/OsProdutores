package Staff.StaffMembers;

import Staff.StaffMemberAbstract;
import Staff.Tags.Producer;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

/**
 * Representa um Produtor Junior.
 */
public class JuniorProducerClass extends StaffMemberAbstract implements Producer {

    // Construtor
    public JuniorProducerClass(String Name, int moneyPerHour) {
        super(Name, moneyPerHour);
    }
}
