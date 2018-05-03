package The_Producers;

import java.time.LocalDateTime;
import Array.*;
import Scenery.*;
import Staff.StaffMember;
import Staff.Vedette;

/**
 * @author Tiago Guerreiro
 * @author Bernardo Borda d'Agua
 *
 */

public class RecordingClass implements Recording{

    private Scenery scenery;
    private LocalDateTime start;
    private int duration;
    private Array<StaffMember> staff;
    private boolean suspended;


    RecordingClass(Scenery scenery,LocalDateTime date, int duration, StaffMember[] staff, boolean suspended) {
        start = date;
        //end = start.plusMinutes(duration);
        this.duration = duration;
        this.scenery = scenery;
        this.staff = new ArrayClass<StaffMember>();
        populateStaff(staff);
        this.suspended = suspended;
    }



    public String toStringExtra() {
        String s = "";
        staff.initialize();
        if (suspended)
            s = " Suspensa!";
        return start.format(FORMAT_DATE) + "; " + scenery.getName() + "; " + staff.next().getName() + "; "
                + staff.next().getName() + "." + s;
    }

    public String getScenery(){
        return scenery.getName();
    }

    @Override
    public void changeStatus() {
        suspended = !suspended;
    }

    @Override
    public boolean hasStaffMemberNamed(String name) {
        staff.initialize();
        while(staff.hasNext())
            if (name.equals(staff.next().getName()))
               return true;
        return false;
    }

    @Override
    public boolean isSuspended() {
        return suspended;
    }

    @Override
    public boolean isRecordingSaved() {
        Array<StaffMember> members = staff;
        members.initialize();
        staff.initialize();
        while(staff.hasNext()){
            StaffMember member = staff.next();
            if(member instanceof Vedette){
                Vedette vMember = (Vedette) member;
                while(staff.hasNext()){
                    if (vMember.isMadWith(members.next().getName()))
                        return false;
                }
            }
        }
        return true;
    }

    @Override
    public LocalDateTime getStartingDate() {
        return start;
    }

    public LocalDateTime getEndDate(){
        return start.plusMinutes(duration);
    }

    @Override
    public StaffMember getProducer() {
        staff.initialize();
        return staff.next();
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public int getCost(){
        int total = 0;
        staff.initialize();
        while(staff.hasNext())
            total += staff.next().getMoneyPerHour();
        return (int)((total + scenery.getPricePerHour()) * Math.ceil(duration/60.0));
    }

    private void populateStaff(StaffMember[] staff){
        for (StaffMember sM: staff)
            this.staff.add(sM);
    }

    public String[] getStaff(){
        String[] staffArray = new String[staff.length()];
        staff.initialize();
        for(int i = 0; staff.hasNext(); i++)
            staffArray[i] = staff.next().getName();

        return staffArray;
    }

    @Override
    public void changeDate(LocalDateTime tempStartDate) {
        start = tempStartDate;
    }

    //Formatacao com a classe DateTimeFormatter
    //DateTimeFormatter format_date = DateTimeFormatter.ofPattern("yyyy M d");
    //DateTimeFormatter format_date_time = DateTimeFormatter.ofPattern("yyyy M d h m");
	//	System.out.println(start.format(format_date));
	//	System.out.println(start.format(format_date_time));

}
