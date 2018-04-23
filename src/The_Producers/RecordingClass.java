package The_Producers;

import java.time.LocalDateTime;
import Array.Array;
import Scenery.*;
import Staff.StaffMember;
import Staff.Tags.Director;

public class RecordingClass implements Recording{

    Scenery scenery;
    LocalDateTime start;
    LocalDateTime end;
    Array<StaffMember> staff;
    boolean suspended;


    public RecordingClass(int year, int month, int day, int hour, int minute, int duration, Director director, Array<StaffMember> staff) {
        start = LocalDateTime.of(year, month, day, hour, minute);
        end = start.plusMinutes(duration);
        this.scenery = scenery;
        this.staff = staff;
        suspended = false;
    }

    @Override
    public String toString() {
        String s = "";
        staff.initialize();
        if(suspended)
            s = " Suspensa!";
        return start.format(FORMAT_DATE) + "; " + scenery.getName() + "; " + staff.next().getName() + "; "
                + staff.next().getName() + "." + s + "\n";
    }

    public int getCost(){
        staff.initialize();
        int total = 0;
        while(staff.hasNext()){
            total += staff.next().getMoneyPerHour() * start.compareTo(end);
        }


        return 0;
    }
// verificar se data -start- 'e inferior 'a data -date-
	//	System.out.println(start.isBefore(date));

    //Formatacao com a classe DateTimeFormatter
    //DateTimeFormatter format_date = DateTimeFormatter.ofPattern("yyyy M d");
    //DateTimeFormatter format_date_time = DateTimeFormatter.ofPattern("yyyy M d h m");
	//	System.out.println(start.format(format_date));
	//	System.out.println(start.format(format_date_time));

}
