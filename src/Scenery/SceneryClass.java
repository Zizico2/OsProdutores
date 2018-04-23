package Scenery;

public class SceneryClass implements Scenery {

    private String name;
    private int pricePerHour;
    private boolean status;


    public SceneryClass(String name, int pricePerHour){
        this.name = name;
        this.pricePerHour = pricePerHour;
        status = FREE;
    }

    public String getName() {
        return name;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public boolean getStatus() {
        return status;
    }

    public void changeStatus() {
        status = !status;
    }
}
