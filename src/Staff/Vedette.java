package Staff;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

public interface Vedette extends  StaffMember{

    void mope(StaffMember staffMember);

    String getBlacklist();

    void reconcile(String name);

    boolean isMadWith(String name);
}
