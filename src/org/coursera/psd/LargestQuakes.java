package org.coursera.psd;

import java.util.ArrayList;

public class LargestQuakes {
    public void findLargestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
//        String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("\n===============================");
        System.out.println("findLargestQuakes()");
        System.out.println("read data for "+list.size());
        System.out.println("===============================");
        int largestIndex = indexOfLargest(list);
        System.out.println("Largest index is " + largestIndex + " with magnitude "
                            + list.get(largestIndex).getMagnitude());

        //HOWMANY
        int howMany = 5;
        ArrayList<QuakeEntry> largestQuakes = new ArrayList<>(getLargest(list, howMany));
        for (int i = 0; i < largestQuakes.size(); i++){
            System.out.println(largestQuakes.get(i));
        }
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

    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        ArrayList<QuakeEntry> result = new ArrayList<>();
        ArrayList<QuakeEntry> copy = new ArrayList<>(quakeData);
        if (quakeData.size() < howMany){
            howMany = quakeData.size();
        }
        for (int i = 0; i < howMany; i++){
            int largestIndex = indexOfLargest(copy);
            result.add(copy.get(largestIndex));
            copy.remove(largestIndex);
        }
        return result;
    }
}
