package org.coursera.psd.Week_2_Sorting_at_Scale;

import java.util.Comparator;

/**
 * TitleAndDepthComparator
 *
 * @author (Igor Prus)
 * @version (Oct 15/16)
 */

public class TitleAndDepthComparator implements Comparator<QuakeEntry>{
    public int compare(QuakeEntry q1, QuakeEntry q2){
        if (q1.getInfo().compareTo(q2.getInfo()) == 0){
            return Double.compare(q1.getDepth(), q2.getDepth());
        }
        return q1.getInfo().compareTo(q2.getInfo());
    }
}
