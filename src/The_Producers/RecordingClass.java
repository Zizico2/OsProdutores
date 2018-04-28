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


    RecordingClass(Scenery scenery,LocalDateTime date, int duration, StaffMember[] staff) {
        start = date;
        //end = start.plusMinutes(duration);
        this.duration = duration;
        this.scenery = scenery;
        this.staff = new ArrayClass<StaffMember>();
        populateStaff(staff);
        suspended = false;
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
    public boolean checkStaffMember(String name) {
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
    public LocalDateTime getDate() {
        return start;
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

    public Array<StaffMember> getStaff(){
        return staff;
    }

    //Formatacao com a classe DateTimeFormatter
    //DateTimeFormatter format_date = DateTimeFormatter.ofPattern("yyyy M d");
    //DateTimeFormatter format_date_time = DateTimeFormatter.ofPattern("yyyy M d h m");
	//	System.out.println(start.format(format_date));
	//	System.out.println(start.format(format_date_time));

}
