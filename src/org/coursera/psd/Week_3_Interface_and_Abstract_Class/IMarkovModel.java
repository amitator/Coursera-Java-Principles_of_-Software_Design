package org.coursera.psd.Week_3_Interface_and_Abstract_Class;

/**
 * IMarkovModel
 *
 * @author (Igor Prus)
 * @version (Oct 17/16)
 */

public interface IMarkovModel {
    public void setTraining(String text);
    
    public String getRandomText(int numChars);
    
}
