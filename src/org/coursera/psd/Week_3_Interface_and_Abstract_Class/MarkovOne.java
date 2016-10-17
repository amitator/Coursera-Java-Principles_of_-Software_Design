package org.coursera.psd.Week_3_Interface_and_Abstract_Class;

import java.util.ArrayList;
import java.util.Random;

/**
 * MarkovOne
 *
 * @author (Igor Prus)
 * @version (Oct 17/16)
 */

public class MarkovOne extends AbstractMarkovModel{
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
        int index = myRandom.nextInt(myText.length() - 1);
        String key = myText.substring(index, index + 1);
        sb.append(key);
        for(int k=0; k < numChars - 1; k++){
            ArrayList<String> list = getFollows(key);
            if (list.size() == 0){
                break;
            }
            index = myRandom.nextInt(list.size());
            String next = list.get(index);
            sb.append(next);
            key = next;
        }
        return sb.toString();
    }
}
