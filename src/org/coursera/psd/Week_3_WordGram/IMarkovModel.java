package org.coursera.psd.Week_3_WordGram;

/**
 * IMarkovModel
 *
 * @author (Igor Prus)
 * @version (Oct 20/16)
 */

public interface IMarkovModel {
    public void setTraining(String text);
    
    public void setRandom(int seed);
    
    public String getRandomText(int numChars);

}
