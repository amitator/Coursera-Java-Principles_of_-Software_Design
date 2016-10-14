package org.coursera.psd.Week_1_Filtering_Data;

/**
 * This is MinMagFilter. Takes MIN magnitude and returns array of quakes above or equals minMagnitude.
 * 
 * @author (Igor Prus)
 * @version (0.1)
 */
public class MinMagFilter implements Filter
{
    private double magMin; 
    
    public MinMagFilter(double min) { 
        magMin = min;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return qe.getMagnitude() >= magMin; 
    }

    public String getName(){
        return "MinMagnitude";
    }

}
