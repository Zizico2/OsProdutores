package Staff;

import Array.Array;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

public interface Vedette extends  StaffMember{

    void mope(StaffMember staffMember);

    String getBlacklist();

    void reconcile(String name);

    Array<StaffMember> getBlacklistArray();

    boolean isMadWith(String name);
}
