package org.coursera.psd.Week_1_Filtering_Data;

/**
 * This is DepthFilter. Takes MIN and MAX depth and returns array of quakes between them.
 *
 * @author (Igor Prus)
 * @version (0.1)
 */
public class DepthFilter implements Filter{
    private double minDepth;
    private double maxDepth;
    public DepthFilter(double min, double max){
        this.minDepth = min;
        this.maxDepth = max;
    }

    public boolean satisfies(QuakeEntry qe){
        return qe.getDepth() >= minDepth &&
                qe.getDepth() <= maxDepth;
    }

    public String getName(){
        return "Depth";
    }
}