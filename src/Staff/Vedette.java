package Staff;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

/**
 * Representa um Vedeta
 */
public interface Vedette extends StaffMember {

    /**
     * Amua, adicionando um colaborador a sua lista negra.
     *
     * @param staffMember colaborador a adicionar a lista negra.
     */
    void mope(StaffMember staffMember);

    /**
     * Devolve a mensagem correspondente ao comando "AMUANCOS".
     *
     * @return msg.
     */
    String getBlacklist();


    /**
     * Reconcilia, removendo um olaborador da sua lista negra.
     *
     * @param name nome do colaborador a remover.
     */
    void reconcile(String name);

    /**
     * Veriica se a sua lista negra contem o @param name.
     *
     * @param name nome a verificar.
     * @return True se, name pertence a lista negra.
     * False se, name nao pertence a lista negra.
     */
    boolean isMadWith(String name);
}
