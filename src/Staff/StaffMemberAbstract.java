package Staff;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

/**
 * Implementa um Colaborador
 */
public abstract class StaffMemberAbstract implements StaffMember {

    // Variáveis de Instância
    private final int moneyPerHour;
    private final String Name;

    // Construtor
    protected StaffMemberAbstract(String Name, int moneyPerHour){
        this.moneyPerHour = moneyPerHour;
        this.Name = Name;
    }

    public int getMoneyPerHour() {
        return moneyPerHour;
    }

    public String getName() {
        return Name;
    }
}

