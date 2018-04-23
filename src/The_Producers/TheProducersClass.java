package The_Producers;

import Array.*;
import Scenery.Scenery;
import Scenery.SceneryClass;
import Staff.StaffMember;
import Staff.StaffMembers.JuniorProducerClass;

import Staff.StaffMembers.*;
import Staff.*;
import Staff.StaffMembers.VedetteActorClass;
import Staff.StaffMembers.VedetteDirectorClass;
import Staff.Tags.*;


public class TheProducersClass implements TheProducers {

    private Array<Recording> calendar;
    private Array<StaffMember> staff;
    private Array<Scenery> sceneries;

    public TheProducersClass(){
        staff = new ArrayClass<StaffMember>();
        calendar = new ArrayClass<Recording>();
        sceneries = new ArrayClass<Scenery>();
    }

    @Override
    public void register(String name, int payPerHour, String type, String subType) {
        StaffType ST = getType(type,subType);

        switch(ST){
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

    public void addScenery(String name, int pricePerHour){
        sceneries.add(new SceneryClass(name,pricePerHour));
    }

    @Override
    public StaffType checkType(StaffMember ST){
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
            StaffType ST = checkType(jonhdoe);
            msg += ST.getOutput() + jonhdoe.getName() + " " + jonhdoe.getMoneyPerHour() + "\n";
        }
        return msg;
    }

    public boolean duplicateName(String name){
        staff.initialize();
        while(staff.hasNext()){
            if(staff.next().getName().equals(name))
                return true;
        }
        return false;
    }

    @Override
    public boolean isTypeValid(String type){

        for(StaffType ST: StaffType.values())
            if(ST.getType().equals(type))
                return true;
        return false;
    }

    @Override
    public boolean isSubTypeValid(String subType){
        for(StaffType ST: StaffType.values())
            if(ST.getSubType().equals(subType))
                return true;
        return false;
    }

    @Override
    public boolean isSalaryValid(int money){
        return money > 0;
    }

    private StaffType getType(String type, String subType){
        for (StaffType T: StaffType.values()) {
            if(type.equals(T.getType()) && subType.equals(T.getSubType()))
                return T;
        }
        return null;
    }


}
