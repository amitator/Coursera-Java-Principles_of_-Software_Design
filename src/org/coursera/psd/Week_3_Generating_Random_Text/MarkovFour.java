package org.coursera.psd.Week_3_Generating_Random_Text;

import java.util.ArrayList;
import java.util.Random;

/**
 * MarkovFour
 *
 * @author (Igor Prus)
 * @version (Oct 17/16)
 */

public class MarkovFour {
    private String myText;
    private Random myRandom;

    public MarkovFour() {
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
        int index = myRandom.nextInt(myText.length() - 4);
        String key = myText.substring(index, index + 4);
        sb.append(key);
        for(int k=0; k < numChars - 4; k++){
            ArrayList<String> list = getFollows(key);
            if (list.size() == 0){
                break;
            }
            index = myRandom.nextInt(list.size());
            String next = list.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }
        return sb.toString();
    }

    public ArrayList<String> getFollows(String key){
        ArrayList<String> result = new ArrayList<>();
        int index = 0;
        int last = myText.lastIndexOf(key);
        while (index <= last){
            index = myText.indexOf(key, index);
            if (index + key.length() == myText.length()){
                break;
            }
            result.add(String.valueOf(myText.charAt(index + key.length())));
            index++;
        }
        return result;
    }
}
