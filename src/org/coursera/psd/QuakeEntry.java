package org.coursera.psd;

public class QuakeEntry {
    private Location myLocation;
    private String title;
    private double depth;
    private double magnitude;

    public QuakeEntry(double latitude, double longitude, double magnitude, String title, double depth){
        myLocation = new Location(latitude, longitude);
        this.depth = depth;
        this.magnitude = magnitude;
        this.title = title;
    }

    public double getMagnitude(){
        return this.magnitude;
    }
}
