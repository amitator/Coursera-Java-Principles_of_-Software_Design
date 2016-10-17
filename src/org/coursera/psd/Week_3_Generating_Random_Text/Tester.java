package org.coursera.psd.Week_3_Generating_Random_Text;

import java.util.ArrayList;

/**
 * Tester. To test getFollows()
 *
 * @author (Igor Prus)
 * @version (Oct 16/16)
 */

public class Tester {
    public void testGetFollows(){
        MarkovOne markovOne = new MarkovOne();
        markovOne.setTraining("this is a test yes this is a test.");
        ArrayList<Character> charList = markovOne.getFollows("t");
        System.out.println(charList);
    }
}
