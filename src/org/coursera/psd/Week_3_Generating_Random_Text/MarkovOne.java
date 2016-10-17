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
        int index = 0;
        int last = myText.lastIndexOf(key);
        while (index < last){
            index = myText.indexOf(key, index);
            if (index + key.length() == myText.length()){
                break;
            }
            result.add(myText.charAt(index + key.length()));
            index++;
        }
        return result;
    }
}
