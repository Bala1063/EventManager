/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager.domain;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author bala
 */
public class Event {

    private int id;
    private String name;
    private Date startDate;
    private Location location;
    private Set<Speaker> speakers;

    public Event() {

    }

    public Set<Speaker> getSpeakers() {
        return speakers;
    }


    protected void setSpeakers(Set<Speaker> speakers) {
        this.speakers = speakers;
    }

    public void addSpeaker(Speaker speaker) {
        if (!speakers.contains(speaker)) {
            speakers.add(speaker);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", name=" + name + ", startDate=" + startDate + ", location name=" + location.getName() + ", location address="+location.getAddress()+", speakers=" + speakers.iterator().next() + '}';
    }

  
}
