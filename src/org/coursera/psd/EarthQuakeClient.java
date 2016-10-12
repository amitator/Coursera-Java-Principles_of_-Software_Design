package org.coursera.psd;

import java.util.ArrayList;

public class EarthQuakeClient {
    public ArrayList<QuakeEntry> filterByMagnitute(ArrayList<QuakeEntry> quakeData, double minMagnitude){
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry qe : quakeData){
            if (qe.getMagnitude() > minMagnitude) {
                answer.add(qe);
            }
        }
        return answer;
    }
}
