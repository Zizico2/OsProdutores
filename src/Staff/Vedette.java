package Staff;

import Array.Array;

public interface Vedette{

    void mope(StaffMember staffMember);

    String getBlacklist();

    void reconcile(String name);

    Array<StaffMember> getBlacklistArray();
}
