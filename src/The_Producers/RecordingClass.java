package The_Producers;

import java.time.LocalDateTime;
import Array.*;
import Scenery.*;
import Staff.StaffMember;
import Staff.Tags.Director;

public class RecordingClass implements Recording{

    private Scenery scenery;
    private LocalDateTime start;
    private int duration;
    private Array<StaffMember> staff;
    private boolean suspended;


    RecordingClass(Scenery scenery, int year, int month, int day, int hour, int minute, int duration, StaffMember[] staff) {
        start = LocalDateTime.of(year, month, day, hour, minute);
        //end = start.plusMinutes(duration);
        this.duration = duration;
        this.scenery = scenery;
        this.staff = new ArrayClass<StaffMember>();
        populateStaff(staff);
        suspended = false;
    }


    public String toString() {
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

// verificar se data -start- 'e inferior 'a data -date-
	//	System.out.println(start.isBefore(date));

    //Formatacao com a classe DateTimeFormatter
    //DateTimeFormatter format_date = DateTimeFormatter.ofPattern("yyyy M d");
    //DateTimeFormatter format_date_time = DateTimeFormatter.ofPattern("yyyy M d h m");
	//	System.out.println(start.format(format_date));
	//	System.out.println(start.format(format_date_time));

}
