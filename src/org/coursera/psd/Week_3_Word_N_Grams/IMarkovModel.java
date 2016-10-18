package org.coursera.psd.Week_3_Word_N_Grams;

/**
 * MarkovZero
 *
 * @author (Igor Prus)
 * @version (Oct 18/16)
 */

public interface IMarkovModel {
    public void setTraining(String text);
    
    public void setRandom(int seed);
    
    public String getRandomText(int numChars);

}
