package org.coursera.psd.Week_3_Generating_Random_Text;

/**
 * Main for psvm()
 *
 * @author (Igor Prus)
 * @version (Oct 17/16)
 */

public class Main {
    public static void main(String[] args) {
        MarkovRunner markovRunner = new MarkovRunner();
//        markovRunner.runMarkovZero();
//        markovRunner.runMarkovOne();
        markovRunner.runMarkovFour();
//        markovRunner.runMarkovModel();
//        Tester tester = new Tester();
//        tester.testGetFollows();
//        tester.testGetFollowsWithFile();
    }
}
