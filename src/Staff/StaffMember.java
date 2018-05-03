package Staff;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

/**
 * Representa um Colaborador.
 */
public interface StaffMember {

    /**
     * Devolve o nome.
     *
     * @return name.
     */
    String getName();


    /**
     * devolve o salário por hora.
     *
     * @return moneyPerHour.
     */
    int getMoneyPerHour();
}

