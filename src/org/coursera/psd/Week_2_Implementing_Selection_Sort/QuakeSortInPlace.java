package org.coursera.psd.Week_2_Implementing_Selection_Sort;

/**
 * QuakeSortInPlace.
 * 
 * @author (Igor Prus)
 * @version (Oct 14/16)
 */

import java.util.ArrayList;

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }

    public void onePassBubbleSort(ArrayList<QuakeEntry> quakeData, int numSorted){
        for (int i = 0; i < quakeData.size() - numSorted - 1; i++){
            if (quakeData.get(i).getMagnitude() > quakeData.get(i + 1).getMagnitude()){
                QuakeEntry temp = quakeData.get(i);
                quakeData.set(i, quakeData.get(i + 1));
                quakeData.set(i + 1, temp);
            }
        }
    }

    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in){
        for (int i = 0; i < in.size() - 1; i++){
            onePassBubbleSort(in, i);
        }
    }

    public int getLargestDepth(ArrayList<QuakeEntry> quakeData, int index){
        int indexOfLargest = index;
        for (int i = index + 1; i < quakeData.size(); i++){
            if (quakeData.get(i).getDepth() > quakeData.get(indexOfLargest).getDepth()){
                indexOfLargest = i;
            }
        }
        return indexOfLargest;
    }

    public void sortByLargestDepth(ArrayList<QuakeEntry> in){
        int count = 0;
        for (int i = 0; i < 50; i++){
            int indexOfLargest = getLargestDepth(in, i);
            QuakeEntry qeI = in.get(i);
            QuakeEntry qeLargest = in.get(indexOfLargest);
            in.set(i, qeLargest);
            in.set(indexOfLargest, qeI);
            count = i + 1;
        }
        System.out.println("Passes made: " + count);
    }
   
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
        for (int i = 0; i < in.size(); i++) {
            int minIdx = getSmallestMagnitude(in, i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i, qmin);
            in.set(minIdx, qi);
        }
    }

    public boolean checkInSortedOrder(ArrayList<QuakeEntry> quakes){
        for (int i = 0; i < quakes.size() - 1; i++){
            if(!(quakes.get(i).getMagnitude() <= quakes.get(i + 1).getMagnitude())){
                return false;
            }
        }
        return true;
    }

    public void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> in){
        int howMany = 0;
        for (int i = 0; i < in.size() - 1; i++){
            onePassBubbleSort(in, i);
            if (checkInSortedOrder(in)){
                howMany = i + 1;
                break;
            }
        }
        System.out.println("\nSorted in " + howMany + " passes");
    }

    public void sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in){
        int counter = 0;
        for (int i = 0; i < in.size(); i++) {
            int minIdx = getSmallestMagnitude(in, i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i, qmin);
            in.set(minIdx, qi);
            if(checkInSortedOrder(in)){
                counter = i + 1;
                break;
            }
        }
        System.out.println("\nSorted in " + counter + " passes");
    }

    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/earthQuakeDataWeekDec6sample1.atom";
//        String source = "data/earthquakeDataSampleSix2.atom";
//        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
//        sortByMagnitude(list);
//        sortByLargestDepth(list);
//        sortByMagnitudeWithBubbleSort(list);
        sortByMagnitudeWithBubbleSortWithCheck(list);
//        sortByMagnitudeWithCheck(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        } 
        
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
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
