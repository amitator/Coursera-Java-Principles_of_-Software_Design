package org.coursera.psd.Week_3_Generating_Random_Text;

import edu.duke.FileResource;

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
        ArrayList<String> charList = markovOne.getFollows(".");
        System.out.println(charList);
    }

    public void testGetFollowsWithFile(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovOne markovOne = new MarkovOne();
        markovOne.setTraining(st);
        ArrayList<String> charList = markovOne.getFollows("t");
        System.out.println("CharList length: " + charList.size());

    }
}
