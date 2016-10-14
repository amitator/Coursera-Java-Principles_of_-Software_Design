package org.coursera.psd.Week_1_Filtering_Data;

/**
 * src.org.courcera.psd.Filter interface.
 * 
 * @author (Igor Prus)
 * @version (0.1)
 */
public interface Filter
{
    public String getName();
    public  boolean satisfies(QuakeEntry qe); 
}
