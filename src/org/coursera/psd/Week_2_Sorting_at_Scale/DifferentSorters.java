package org.coursera.psd.Week_2_Sorting_at_Scale;

/**
 * DifferentSorters
 *
 * @author (Igor Prus)
 * @version (Oct 15/16)
 */

import java.util.*;

public class DifferentSorters {
    public void sortWithCompareTo() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list);
        int quakeNumber = 10;
        System.out.println("\nPrint quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber) + "\n");
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }    

    public void sortByMagnitude() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, new MagnitudeComparator());
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }

    public void sortByDistance() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        // Location is Durham, NC
        Location where = new Location(35.9886, -78.9072);
        Collections.sort(list, new DistanceComparator(where));
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
    }

    public void sortByTitleAndDepth(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, new TitleAndDepthComparator());
        System.out.println("\n=============================");
        System.out.println("sortByTitleAndDepth()");
        System.out.println("=============================");
        int quakeNumber = 10;
        System.out.println("\nPrint quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber) + "\n");
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
    }
}
