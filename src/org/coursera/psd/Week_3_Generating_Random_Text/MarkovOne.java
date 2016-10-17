package org.coursera.psd.Week_3_Generating_Random_Text;

import java.util.ArrayList;
import java.util.Random;

/**
 * MarkovOne
 *
 * @author (Igor Prus)
 * @version (Oct 16/16)
 */

public class MarkovOne {
    private String myText;
    private Random myRandom;

    public MarkovOne() {
        myRandom = new Random();
    }

    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        myText = s.trim();
    }

    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int k=0; k < numChars; k++){
            int index = myRandom.nextInt(myText.length());
            sb.append(myText.charAt(index));
        }

        return sb.toString();
    }

    public ArrayList<Character> getFollows(String key){
        ArrayList<Character> result = new ArrayList<>();
        for (int i = 0; i < myText.length()-1; i++) {
            if (key.equals(myText.charAt(i))){
                result.add(myText.charAt(i + 1));
            }
        }
        return result;
    }
}
