package org.coursera.psd.Week_2_Sorting_at_Scale;

/**
 * MagnitudeComparator
 *
 * @author (Igor Prus)
 * @version (Oct 15/16)
 */

import java.util.*;

public class MagnitudeComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry qe1, QuakeEntry qe2) {
        return Double.compare(qe1.getMagnitude(), qe2.getMagnitude());
    }
    
}
