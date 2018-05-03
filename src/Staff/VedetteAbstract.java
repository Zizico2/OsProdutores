package Staff;

import Array.*;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

public abstract class VedetteAbstract extends StaffMemberAbstract implements Vedette {

    private final Array<StaffMember> blacklist;
    protected VedetteAbstract(String Name, int moneyPerHour) {
        super(Name, moneyPerHour);
        blacklist = new ArrayClass<StaffMember>();
    }


    @Override
    public void mope(StaffMember staffMember){
        blacklist.add(staffMember);
    }

    @Override
    public void reconcile(String name){
        blacklist.initialize();
        while(blacklist.hasNext())
            if(blacklist.next().getName().equals(name)) {
                blacklist.remove(blacklist.getCurrentElem());
                return;
            }
    }

    @Override
    public String getBlacklist(){
        String msg = "";
        blacklist.initialize();
        while(blacklist.hasNext())
            msg += blacklist.next().getName() + "\n";
        return msg;
    }

    @Override
    public boolean isMadWith(String name){
        blacklist.initialize();
        while(blacklist.hasNext())
            if(blacklist.next().getName().equals(name))
                return true;
        return false;
    }
}
