package org.coursera.psd.Week_1_Filtering_Data;

import java.util.ArrayList;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("\n===============================");
        System.out.println("quakesWithFilter()");
        System.out.println("read data for "+list.size()+" quakes");
        System.out.println("===============================");
//        Filter f = new MagnitudeFilter(3.5, 4.5);
//        ArrayList<QuakeEntry> minMaxMagnitude  = filter(list, f);
//        f = new DepthFilter(-55_000.0d, -20_000.0d);
//        ArrayList<QuakeEntry> depthFilter = filter(minMaxMagnitude, f);
        //Location of Tokyo
        Location city = new Location(35.42, 139.43);
        //Location Denver
//        Location city = new Location(39.7392d, -104.9903d);
        Filter f = new DistanceFilter(city, 10_000_000.0d);
        ArrayList<QuakeEntry> distFilter = filter(list, f);
        f = new PhraseFilter("end", "Japan");
        ArrayList<QuakeEntry> phraseFilter = filter(distFilter, f);

//        System.out.println("Found " + depthFilter.size() + " quakes");
//        for (QuakeEntry qe: depthFilter) {
//            System.out.println(qe);
//        }
        for (QuakeEntry qe: phraseFilter) {
            System.out.println(qe);
        }
        System.out.println("Found " + phraseFilter.size() + " quakes");
    }

    public void testMatchAllFilter(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("\n===============================");
        System.out.println("testMatchAllFilter()");
        System.out.println("read data for "+list.size()+" quakes");
        System.out.println("===============================");
        MatchAllFilter matchAllFilter = new MatchAllFilter();
        matchAllFilter.addFilter(new MagnitudeFilter(1.0d, 4.0d));
        matchAllFilter.addFilter(new DepthFilter(-180_000.0d, -30_000.0d));
        matchAllFilter.addFilter(new PhraseFilter("any", "o"));
        ArrayList<QuakeEntry> result = filter(list, matchAllFilter);
        System.out.println("Found " + result.size() + " quakes");
        for (QuakeEntry qe : result){
            System.out.println(qe);
        }
        System.out.println("\nFilter used: " + matchAllFilter.getName());
    }

    public void testMatchAllFilter2(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("\n===============================");
        System.out.println("testMatchAllFilter()");
        System.out.println("read data for "+list.size()+" quakes");
        System.out.println("===============================");
        MatchAllFilter matchAllFilter = new MatchAllFilter();
        matchAllFilter.addFilter(new MagnitudeFilter(0.0d, 5.0d));
        //Oklahoma
//        Location city = new Location(36.1314, -95.9372);
        //Denmark
        Location city = new Location(55.7308d, 9.1153d);
        matchAllFilter.addFilter(new DistanceFilter(city, 3_000_000.0d));
        matchAllFilter.addFilter(new PhraseFilter("any", "e"));
        ArrayList<QuakeEntry> result = filter(list, matchAllFilter);
        for (QuakeEntry qe : result){
            System.out.println(qe);
        }
        System.out.println("\nFound " + result.size() + " quakes");
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

}
