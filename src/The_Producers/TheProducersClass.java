package The_Producers;

import Array.*;
import Staff.StaffMember;
import Staff.StaffMembers.JuniorProducerClass;

import Staff.StaffMembers.*;
import Staff.*;
import Staff.StaffMembers.Vedette.VedetteActorClass;
import Staff.StaffMembers.Vedette.VedetteDirectorClass;
import Staff.Tags.*;


public class TheProducersClass implements TheProducers {

    private Array<Recording> calendar;
    private Array<StaffMember> staff;

    public TheProducersClass(){
        staff = new ArrayClass<StaffMember>();
        calendar = new ArrayClass<Recording>();
    }

    @Override
    public void add(String name, int payPerHour, StaffType type) {

        switch(type){
            case SENIOR_PRODUCER:
                staff.add(new SeniorProducerClass(name,payPerHour));
                break;

            case JUNIOR_PRODUCER:
                staff.add(new JuniorProducerClass(name,payPerHour));
                break;

            case VEDETTE_ACTOR:
                staff.add(new VedetteActorClass(name,payPerHour));
                break;

            case NORMAL_ACTOR:
                staff.add(new NormalActorClass(name,payPerHour));
                break;

            case VEDETTE_DIRECTOR:
                staff.add(new VedetteDirectorClass(name,payPerHour));
                break;

            case NORMAL_DIRECTOR:
                staff.add(new NormalDirectorClass(name,payPerHour));
                break;

            case TECHNICIAN:
                staff.add(new TechnicianClass(name,payPerHour));
        }
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
        String prollySpace = " ";
        while(staff.hasNext()){
            StaffMember jonhdoe = staff.next();
            StaffType ST = getType(jonhdoe);
            if(ST.equals(StaffType.TECHNICIAN))
                prollySpace = "";
                msg += ST.getType() + prollySpace + ST.getSubType() + " " + jonhdoe.getName() + " " + jonhdoe.getMoneyPerHour() + "\n";
                prollySpace = " ";
        }
        return msg;
    }
}
