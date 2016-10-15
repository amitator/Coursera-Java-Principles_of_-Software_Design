package org.coursera.psd.Week_2_Sorting_at_Scale;

import java.util.Comparator;

/**
 * Created by usver on 10/15/2016.
 */
public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry>{
    public int compare(QuakeEntry q1, QuakeEntry q2){
        String q1Title = q1.getInfo();
        String q2Title = q2.getInfo();
        if (q1Title.substring(q1Title.lastIndexOf(" ") + 1)
                .compareTo(q2Title.substring(q1Title.lastIndexOf(" ") + 1))
                == 0){
            return Double.compare(q1.getMagnitude(), q2.getMagnitude());
        }
        return q1Title.substring(q1Title.lastIndexOf(" ") + 1)
                .compareTo(q2Title.substring(q1Title.lastIndexOf(" ") + 1));
    }
}
