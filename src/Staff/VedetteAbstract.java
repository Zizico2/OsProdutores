package Staff;

import Array.*;

public abstract class VedetteAbstract extends StaffMemberAbstract implements Vedette {

    private Array<StaffMember> blacklist;
    protected VedetteAbstract(String Name, int moneyPerHour) {
        super(Name, moneyPerHour);
        blacklist = new ArrayClass<StaffMember>();
    }


    public void mope(StaffMember staffMember){
        blacklist.add(staffMember);
    }

    public void reconcile(String name){
        blacklist.initialize();
        while(blacklist.hasNext())
            if(blacklist.next().getName().equals(name)) {
                blacklist.remove(blacklist.getCurrentElem());
                return;
            }
    }

    public String getBlacklist(){
        String msg = "";
        blacklist.initialize();
        while(blacklist.hasNext())
            msg += blacklist.next().getName() + "\n";
        return msg;
    }

    public Array<StaffMember> getBlacklistArray(){
        return blacklist;
    }

    public boolean isMadWith(String name){
        blacklist.initialize();
        while(blacklist.hasNext())
            if(blacklist.next().getName().equals(name))
                return true;

        return false;
    }
}
