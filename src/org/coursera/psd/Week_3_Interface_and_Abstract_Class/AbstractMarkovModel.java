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

}
