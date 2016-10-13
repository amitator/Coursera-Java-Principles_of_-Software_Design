package org.coursera.psd;

import java.util.ArrayList;

public class LargestQuakes {
    public void findLargestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
//        String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("\n===============================");
        System.out.println("findLargestQuakes()");
        System.out.println("read data for "+list.size());
        System.out.println("===============================");
        int largestIndex = indexOfLargest(list);
        System.out.println("Largest index is " + largestIndex + " with magnitude "
                            + list.get(largestIndex).getMagnitude());
    }

    public int indexOfLargest(ArrayList<QuakeEntry> list){
        int largestIndex = 0;
        double maxMagnitude = 0.0d;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getMagnitude() > maxMagnitude){
                maxMagnitude = list.get(i).getMagnitude();
                largestIndex = i;
            }
        }
        return largestIndex;
    }
}
