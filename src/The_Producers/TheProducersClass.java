package The_Producers;

import Array.*;
import Staff.StaffMember;
import Staff.StaffMembers.JuniorProducerClass;
import Staff.StaffMembers.TechnicianClass;
import Staff.Tags.Actor;
import Staff.Tags.Director;
import Staff.Tags.*;
import Staff.*;


public class TheProducersClass implements TheProducers {

    private Array<Recording> calendar;
    private Array<StaffMember> staff;

    public TheProducersClass(){
        staff = new ArrayClass<StaffMember>();
        calendar = new ArrayClass<Recording>();
    }

    @Override
    public void add(String name, int payPerHour, StaffType type) {

    }

    @Override
    public Array<StaffMember> staff() {
        return staff;
    }


    public StaffType getType(StaffMember ST){
        if(ST instanceof Vedette) {
                 if(ST instanceof Actor)
                     return StaffType.VEDETTE_ACTOR;
                 else
                    return StaffType.VEDETTE_DIRECTOR;
        } else {
            if (ST instanceof Producer) {
                if (ST instanceof JuniorProducerClass)
                    return StaffType.JUNIOR_PRODUCER;
                else
                    return StaffType.SENIOR_PRODUCER;
            } else if (ST instanceof Actor)
                return StaffType.NORMAL_ACTOR;

            else if (ST instanceof Director)
                return StaffType.NORMAL_DIRECTOR;

            else
                return StaffType.TECHNICIAN;
        }
    }

    @Override
    public String Staff() {
        staff.initialize();
        String msg = "";
        while(staff.hasNext()){
            StaffMember jonhdoe = staff.next();
            StaffType ST = getType(jonhdoe);
            msg += ST.getType() + " " + ST.getSubType() + " " + jonhdoe.getName() + " " + jonhdoe.getMoneyPerHour();
        }
        return msg;
    }
}
