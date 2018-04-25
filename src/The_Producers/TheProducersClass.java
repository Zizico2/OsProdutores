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

    private Array<Recording> plannedRecordings;
    private Array<Recording> pastRecordings;
    private Array<StaffMember> staff;
    private Array<Scenery> sceneries;

    public TheProducersClass(){
        staff = new ArrayClass<StaffMember>();
        plannedRecordings = new ArrayClass<Recording>();
        pastRecordings = new ArrayClass<Recording>();
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

    @Override
    public void addScenery(String site, int pricePerHour){

        sceneries.add(new SceneryClass(site, pricePerHour));

    }

    public String listSceneries(){

        String msg = "";

        sceneries.initialize();

        while(sceneries.hasNext()){
            Scenery somewhereovertherainbow = sceneries.next();
            msg += somewhereovertherainbow.getName() + " " + somewhereovertherainbow.getPricePerHour() + ".\n";
        }
        return msg;
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
    public String record(){
        Recording recording = plannedRecordings.remove();
        pastRecordings.add(recording);
        return recording.toString() + " Gravada!";
    }

    public String site(String site){
        String msg = "";
        Recording recording;
        int totalCost = 0;
        plannedRecordings.initialize();
        while(plannedRecordings.hasNext()){
            recording = plannedRecordings.next();
            if(site.equals(recording.getScenery())){
                totalCost += recording.getCost();
                msg += recording.toString().replaceFirst(site + "; ","") + "\n";
            }
        }
        msg += totalCost + " euros orcamentados.";
        return msg;
    }

    @Override
    public boolean siteExists(String scenery) {
        sceneries.initialize();
        while(sceneries.hasNext())
            if(sceneries.next().getName().equals(scenery))
                return true;
        return false;
    }

    public String listRecordings(int arrayCode){
        Array<Recording> array;
        String money = " euros ";
        if(arrayCode == PLANNED) {
            array = plannedRecordings;
            money += "orcamentados.";
        }
        else {
            array = pastRecordings;
            money += "gastos.";
        }
        int totalCost = 0;
        String msg = "";
        array.initialize();
        if(array.hasNext()) {
            while (array.hasNext()) {
                Recording R = array.next();
                totalCost += R.getCost();
                msg += R.toString() + "\n";
            }
            msg += totalCost + money;
        }
        return msg;
    }

    @Override
    public String staff() {
        staff.initialize();
        String msg = "";

        while(staff.hasNext()){
            StaffMember jonhdoe = staff.next();
            StaffType ST = checkType(jonhdoe);
            msg += ST.getOutput() + jonhdoe.getName() + " " + jonhdoe.getMoneyPerHour() + "\n";
        }
        return msg;
    }

    public String planned() {
        plannedRecordings.initialize();
        String msg = "";

        while(plannedRecordings.hasNext()){
            Recording NCIS_LA = plannedRecordings.next();
            msg += NCIS_LA.toString();
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
    public boolean isCostValid(int money){
        return money > 0;
    }

    public boolean duplicateSceneryName(String name){
        sceneries.initialize();
        while(sceneries.hasNext()){
            if(sceneries.next().getName().equals(name))
                return true;
        }
        return false;
    }

    private StaffType getType(String type, String subType){
        for (StaffType T: StaffType.values()) {
            if(type.equals(T.getType()) && subType.equals(T.getSubType()))
                return T;
        }
        return null;
    }

    public void scheduleRecording(String scenery, int[] localDateTime, String[] names){
        plannedRecordings.add(new RecordingClass(getSceneryByName(scenery), localDateTime[0], localDateTime[1],
                     localDateTime[2], localDateTime[3], localDateTime[4], localDateTime[5], getStaffMembersByName(names)));
    }



    private Scenery getSceneryByName(String name){
        sceneries.initialize();
        while(sceneries.hasNext()) {
            Scenery sC = sceneries.next();
            if (sC.getName().equals(name))
                return sC;
        }
            return null;
    }

    private StaffMember[] getStaffMembersByName(String[] names) {
        int counter = 0;
        int length = names.length;
        StaffMember[] staff = new StaffMember[length];
        this.staff.initialize();
        while (this.staff.hasNext() && counter < length){
            StaffMember sM = this.staff.next();
            if (sM.getName().equals(names[counter])) {
                staff[counter++] = sM;
                this.staff.initialize();
            }
        }
            return staff;
    }
}
