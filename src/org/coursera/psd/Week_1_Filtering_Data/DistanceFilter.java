package org.coursera.psd.Week_1_Filtering_Data;

/**
 * This is DistanceFilter. Takes Location and MAX distance and returns true
 * if a QuakeEntry’s distance from the given location is less than the specified maximum distance.
 *
 * @author (Igor Prus)
 * @version (0.1)
 */
public class DistanceFilter implements Filter{
    private Location location;
    private double distance;
    public DistanceFilter(Location loc, double distance){
        this.location = loc;
        this.distance = distance;
    }

    public boolean satisfies(QuakeEntry qe){
        return qe.getLocation().distanceTo(location) < distance;
    }

    public String getName(){
        return "Distance";
    }
}
