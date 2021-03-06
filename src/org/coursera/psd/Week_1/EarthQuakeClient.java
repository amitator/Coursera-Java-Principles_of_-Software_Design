package org.coursera.psd.Week_1;

import java.util.ArrayList;

public class EarthQuakeClient {
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry qe : quakeData) {
            if (qe.getMagnitude() > magMin){
                answer.add(qe);
            }
        }

        return answer;
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData, double distMax, Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry qe : quakeData) {
            //IF distance to Location (from) less than distMax - save it
            double current = qe.getLocation().distanceTo(from);
            if (current < distMax) {
                answer.add(qe);
            }
        }

        return answer;
    }

    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData, double minDepth, double maxDepth){
        ArrayList<QuakeEntry> result = new ArrayList<QuakeEntry>();
        for (int i = 0; i < quakeData.size(); i++){
            if (quakeData.get(i).getDepth() > minDepth &&
                    quakeData.get(i).getDepth() < maxDepth){
                result.add(quakeData.get(i));
            }
        }
        return result;
    }

    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData, String whereToSearch,
                                                String whatToSearch){
        ArrayList<QuakeEntry> result = new ArrayList<QuakeEntry>();
        for (QuakeEntry qe : quakeData){
            String title = qe.getInfo();
            switch (whereToSearch){
                case "start":
                    if (title.startsWith(whatToSearch)){
                        result.add(qe);
                    }
                    break;
                case "end":
                    if (title.endsWith(whatToSearch)){
                        result.add(qe);
                    }
                    break;
                case "any":
                    if (title.contains(whatToSearch)){
                        result.add(qe);
                    }
                    break;
            }
        }
        return result;
    }

    public void quakesByPhrase(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("\n===============================");
        System.out.println("quakesByPhrase()");
        System.out.println("read data for "+list.size()+" quakes");
        System.out.println("===============================");

        //WHERE and WHAT to search
//        String whereToSearch = "end";
//        String whatToSearch = "Alaska";
        String whereToSearch = "any";
        String whatToSearch = "Can";
//        String whereToSearch = "start";
//        String whatToSearch = "Quarry Blast";

                ArrayList<QuakeEntry> result = filterByPhrase(list, whereToSearch, whatToSearch);
//        for (QuakeEntry qe : result){
//            System.out.println(qe);
//        }
        System.out.println("Found " + result.size() + " quakes match " + whatToSearch + " at " + whereToSearch);
    }

    public void quakesOfDepth() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("\n===============================");
        System.out.println("quakesOfDepth()");
        System.out.println("read data for "+list.size()+" quakes");
        System.out.println("===============================");

        //MIN and MAX depth
        double minDepth = -4_000;
        double maxDepth = -2_000;
        ArrayList<QuakeEntry> result = filterByDepth(list, minDepth, maxDepth);
        System.out.println("Find quakes with depth between " + minDepth +
                            " and " + maxDepth);
//        for (QuakeEntry qe : result){
//            System.out.println(qe);
//        }
        System.out.println("Found " + result.size() + " that match that criteria");
    }

    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

    }

    public void bigQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("===============================");
        System.out.println("bigQuakes()");
        System.out.println("read data for "+list.size()+" quakes");
        System.out.println("===============================");

        //Magnitude
        double mag = 5.0d;
        ArrayList<QuakeEntry> listBig = filterByMagnitude(list, mag);
        for (QuakeEntry qe : listBig){
            System.out.println(qe);
        }
        System.out.println("Found " + listBig.size() + " quakes that bigger than " + mag + " of magnitude");

    }

    public void closeToMe(){
        EarthQuakeParser parser = new EarthQuakeParser();
//        String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("===============================");
        System.out.println("closeToMe()");
        System.out.println("read data for "+list.size()+" quakes");
        System.out.println("===============================");

        // This location is Durham, NC
//        Location city = new Location(35.988, -78.907);

        // This location is Bridgeport, CA
         Location city =  new Location(38.17, -118.82);

        //maxDistance in meters
        double maxDistance = 1000000.0d;
        ArrayList<QuakeEntry> closest = filterByDistanceFrom(list, maxDistance, city);
        for (QuakeEntry qe : closest) {
            System.out.println(qe.getLocation().distanceTo(city) / 1000 + "\t" + qe.getInfo());
        }
        System.out.println("Found " + closest.size() + " earthquakes that closer then " + maxDistance/1000 +
                            " km from city");

    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    
}
