package org.coursera.psd.Week_1;

import java.util.ArrayList;

public class ClosestQuakes {
    public ArrayList<QuakeEntry> getClosest(ArrayList<QuakeEntry> quakeData, Location current, int howMany) {
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
        if (quakeData.size() < howMany){
            howMany = quakeData.size();
        }
        for (int i = 0; i < howMany; i++){
            int minIndex = 0;
            for (int j = 1; j < copy.size(); j++){
                QuakeEntry qe = copy.get(j);
                Location  loc = qe.getLocation();
                if (loc.distanceTo(current) < copy.get(minIndex).getLocation().distanceTo(current)){
                    minIndex = j;
                }
            }
            ret.add(copy.get(minIndex));
            copy.remove(minIndex);
        }

        return ret;
    }

    public void findClosestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
//        String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("\n===============================");
        System.out.println("findClosestQuakes()");
        System.out.println("read data for "+list.size());
        System.out.println("===============================");

        //LOCATION and HOWMANY
        Location jakarta  = new Location(-6.211,106.845);
        int howMany = 3;

        ArrayList<QuakeEntry> close = getClosest(list,jakarta,howMany);
        for(int k=0; k < close.size(); k++){
            QuakeEntry entry = close.get(k);
            double distanceInMeters = jakarta.distanceTo(entry.getLocation());
            System.out.printf("%4.2f\t %s\n", distanceInMeters/1000,entry);
        }
        System.out.println("number found: "+close.size());
    }
    
}
