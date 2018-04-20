package Staff;

public abstract class VedetteAbstract extends StaffMemberAbstract implements Vedette {

    protected VedetteAbstract(String Name, int moneyPerHour) {
        super(Name, moneyPerHour);
    }
}
