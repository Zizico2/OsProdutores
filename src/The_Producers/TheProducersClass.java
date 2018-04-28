package The_Producers;

import Array.*;
import Scenery.*;
import Staff.StaffMembers.*;
import Staff.*;
import Staff.Tags.*;
import java.time.LocalDateTime;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

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

    @Override
    public boolean isDateValid(int[] dateArray){
        LocalDateTime date = LocalDateTime.of(dateArray[0],dateArray[1],dateArray[2],dateArray[3],dateArray[4]);
        pastRecordings.initialize();
        if(pastRecordings.hasNext()) {
            LocalDateTime lastRecordingDate = pastRecordings.next().getDate();
            return !lastRecordingDate.isAfter(date) || !lastRecordingDate.isEqual(date);
        }
        return true;
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
        String msg;
        pastRecordings.add(recording);
        if(recording.isSuspended())
            msg =  recording.toStringExtra().replaceFirst(" Suspensa!"," Cancelada!");
        else
            msg = recording.toStringExtra() + " Gravada!";
        return msg;
    }

    @Override
    public String site(String site){
        String msg = "";
        Recording recording;
        int totalCost = 0;
        plannedRecordings.initialize();
        while(plannedRecordings.hasNext()){
            recording = plannedRecordings.next();
            if(site.equals(recording.getScenery())){
                totalCost += recording.getCost();
                msg += recording.toStringExtra().replaceFirst(site + "; ","") + "\n";
            }
        }
        msg += totalCost + " euros orcamentados.";
        return msg;
    }

    @Override
    public String staffMember(String name){
        String msg = "";
        int totalCost = 0;
        plannedRecordings.initialize();
        while(plannedRecordings.hasNext()){
            Recording recording = plannedRecordings.next();
            if(recording.checkStaffMember(name)){
                totalCost += recording.getCost();
                msg += recording.toStringExtra().replaceFirst(recording.getScenery() + "; ","") + "\n";
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

    @Override
    public boolean staffMemberExists(String name) {
        staff.initialize();
        while(staff.hasNext())
            if(staff.next().getName().equals(name))
                return true;
        return false;
    }

    @Override
    public String listPlannedRecordings(){
        String money = " euros orcamentados.";
        int totalCost = 0;
        String msg = "";
        plannedRecordings.initialize();
        if(plannedRecordings.hasNext()) {
            while (plannedRecordings.hasNext()) {
                Recording R = plannedRecordings.next();
                totalCost += R.getCost();
                msg += R.toStringExtra() + "\n";
            }
            msg += totalCost + money;
        }
        return msg;
    }

    @Override
    public String listPerformedRecordings(){
        String money = " euros gastos.";
        int totalCost = 0;
        String msg = "";
        pastRecordings.initialize();
        if(pastRecordings.hasNext()) {
            while (pastRecordings.hasNext()) {
                Recording R = pastRecordings.next();
                if(!R.isSuspended())
                    totalCost += R.getCost();
                msg += R.toStringExtra() + "\n";
            }
            msg += totalCost + money;
        }
        return msg.replaceAll(" Suspensa!\n"," Cancelada!\n");
    }

    @Override
    public int mope(String bullyName, String victimName){
        String[] bully = {bullyName};
        Vedette bullyMember = (Vedette) getStaffMembersByName(bully)[0];

        String[] victim = {victimName};
        StaffMember victimMember = getStaffMembersByName(victim)[0];

        bullyMember.mope(victimMember);
        return suspendRecordings(bullyName,victimName);
    }

    @Override
    public boolean isThereAFightWith(String exBullyName, String exVictimName) {
        String[] bully = {exBullyName};
        Vedette bullyMember = (Vedette) getStaffMembersByName(bully)[0];
        return checkFight(bullyMember,exVictimName);
    }

    @Override
    public boolean isThereAVedetteNamed(String name){
        staff.initialize();
        while(staff.hasNext()) {
            StaffMember sT = staff.next();
            if(sT.getName().equals(name) && sT instanceof Vedette)
                return true;
        }
        return false;
    }

    @Override
    public boolean isDurationValid(int duration) {
        return duration > 0;
    }

    @Override
    public boolean isThereAProducerNamed(String name) {
        staff.initialize();
        while(staff.hasNext()) {
            StaffMember sT = staff.next();
            if(sT.getName().equals(name) && sT instanceof Producer)
                return true;
        }
        return false;
    }

    @Override
    public boolean isThereADirectorNamed(String name) {
        staff.initialize();
        while(staff.hasNext()) {
            StaffMember sT = staff.next();
            if(sT.getName().equals(name) && sT instanceof Director)
                return true;
        }
        return false;
    }

    @Override
    public boolean isThereATechnicianNamed(String name) {
        staff.initialize();
        while(staff.hasNext()) {
            StaffMember sT = staff.next();
            if(sT.getName().equals(name) && sT instanceof TechnicianClass)
                return true;
        }
        return false;
    }

    @Override
    public boolean isThereStaffNamed(String[] mainNames, int numberOfStaffMembers) {
        for(int i = 2; i < numberOfStaffMembers; i++)
            if(!staffMemberExists(mainNames[i]))
                return false;
        return true;
    }

    private boolean checkFight(Vedette vedette,String victimName){
        return vedette.isMadWith(victimName);
    }

    public int reconcile(String exBullyName, String exVictimName){
        String[] bully = {exBullyName};
        Vedette bullyMember = (Vedette)getStaffMembersByName(bully)[0];
        bullyMember.reconcile(exVictimName);
        return unSuspendRecordings(exBullyName,exVictimName);
    }

    private int unSuspendRecordings(String exBullyName, String exVictimName) {
        int nUnSuspended = 0;
        plannedRecordings.initialize();
        while(plannedRecordings.hasNext()){
            Recording recording = plannedRecordings.next();
            if(recording.checkStaffMember(exVictimName) && recording.checkStaffMember(exBullyName) && recording.isRecordingSaved()) {
                recording.changeStatus();
                nUnSuspended++;
            }
        }
        return nUnSuspended;
    }

    private int suspendRecordings(String bullyName, String victimName){
        int nSuspended = 0;
        plannedRecordings.initialize();
        while(plannedRecordings.hasNext()){
            Recording recording = plannedRecordings.next();
            if(recording.checkStaffMember(victimName) && recording.checkStaffMember(bullyName) && !recording.isSuspended()) {
                recording.changeStatus();
                nSuspended++;
            }
        }
        return nSuspended;
    }

    public String poutances(String name){
        String[] vedette = {name};
        Vedette vedetteMember = (Vedette)getStaffMembersByName(vedette)[0];
        return vedetteMember.getBlacklist();
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
        LocalDateTime date = LocalDateTime.of(localDateTime[0],localDateTime[1],localDateTime[2],localDateTime[3],localDateTime[4]);
        int duration = localDateTime[5];
        plannedRecordings.add(new RecordingClass(getSceneryByName(scenery), date, duration, getStaffMembersByName(names)),getChronologicalPos(date));
    }

    private int getChronologicalPos(LocalDateTime date){
    plannedRecordings.initialize();
    while(plannedRecordings.hasNext()){
        Recording recording = plannedRecordings.next();
        if(recording.getDate().isAfter(date))
            return plannedRecordings.getCurrentElem();
    }
        return plannedRecordings.length();
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
