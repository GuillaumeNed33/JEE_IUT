package fr.iut;

/**
 * Created by Guillaume on 28/02/2017.
 */
public class Room {
    private String name;
    private int occupation;
    private int capacity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOccupation() {
        return occupation;
    }

    public void setOccupation(int occupation) {
        this.occupation = occupation;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Room(String n, int o, int c) {
        name =n;
        if(o<c) {
            occupation = o;
            capacity = c;
        }
        else {
            capacity = o;
            occupation = c;
        }

    }
}
