package org.coursera.psd.Week_1_Filtering_Data;

/**
 * This is MagnitudeFilter. Takes MIN and MAX magnitudes and returns array of quakes between them.
 *
 * @author (Igor Prus)
 * @version (0.1)
 */
public class MagnitudeFilter implements Filter{
    private double minMagnitude;
    private double maxMagnitude;
    public MagnitudeFilter(double minMag, double maxMag){
        this.minMagnitude = minMag;
        this.maxMagnitude = maxMag;
    }

    public boolean satisfies(QuakeEntry qe){
        return qe.getMagnitude() >= minMagnitude &&
                qe.getMagnitude() <= maxMagnitude;
    }

    public String getName(){
        return "Magnitude";
    }
}
