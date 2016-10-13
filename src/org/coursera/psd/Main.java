package org.coursera.psd;

public class Main {
    public static void main(String[] args) {
//        ClosestQuakes closestQuakes = new ClosestQuakes();
//        closestQuakes.findClosestQuakes();
        EarthQuakeClient earthQuakeClient = new EarthQuakeClient();
        earthQuakeClient.bigQuakes();
        earthQuakeClient.closeToMe();
        earthQuakeClient.quakesOfDepth();
        earthQuakeClient.quakesByPhrase();
    }
}
