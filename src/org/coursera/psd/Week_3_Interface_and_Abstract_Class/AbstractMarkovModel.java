package org.coursera.psd.Week_3_Interface_and_Abstract_Class;

/**
 * AbstractMarkovModel
 *
 * @author (Igor Prus)
 * @version (Oct 17/16)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
 
    abstract public String getRandomText(int numChars);

    protected ArrayList<String> getFollows(String key){
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
