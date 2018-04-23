package Sceneries;

public interface Scenery {

    boolean FREE = true;
    boolean BOOKED = false;
    int getPricePerHour();

    String getName();
}
