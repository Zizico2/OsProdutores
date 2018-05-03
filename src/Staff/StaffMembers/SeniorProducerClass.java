package Staff.StaffMembers;

import Staff.StaffMemberAbstract;
import Staff.Tags.Producer;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

/**
 * Representa um Produtor Senior.
 */
public class SeniorProducerClass extends StaffMemberAbstract implements Producer {

    // Construtor
    public SeniorProducerClass(String Name, int moneyPerHour) {
        super(Name, moneyPerHour);
    }
}
