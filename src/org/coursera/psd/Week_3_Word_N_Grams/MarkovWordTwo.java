package org.coursera.psd.Week_3_Word_N_Grams;

import java.util.ArrayList;
import java.util.Random;

/**
 * MarkovWordTwo
 *
 * @author (Igor Prus)
 * @version (Oct 18/16)
 */

public class MarkovWordTwo implements IMarkovModel{
    private String[] myText;
    private Random myRandom;

    public MarkovWordTwo() {
        myRandom = new Random();
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String text){
        myText = text.split("\\s+");
    }

    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-2);  // random word to start with
        String key1 = myText[index];
        String key2 = myText[index + 1];
        sb.append(key1);
        sb.append(" ");
        sb.append(key2);
        sb.append(" ");
        for(int i=0; i < numWords; i++){
            ArrayList<String> follows = getFollows(key1, key2);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key1 = key2;
            key2 = next;
        }

        return sb.toString().trim();
    }

    private int indexOf(String [] words, String target1, String target2, int start){
        for (int i = start; i < words.length - 1; i++){
            if (words[i].equals(target1) && words[i + 1].equals(target2)){
                return i + 1;
            }
        }
        return -1;
    }

    private ArrayList<String> getFollows(String key1, String key2) {
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        while (pos < myText.length){
            int start = indexOf(myText, key1, key2, pos);
            if (start == -1 || start + 1 >= myText.length){
                break;
            }
            String next = myText[start + 1];
            follows.add(next);
            pos = ++start;
        }
        return follows;
    }

    public void testIndexOf(){
        String str = "this is just a test yes this is a simple test";
        String[] words = str.split("\\s+");
        String target1 = "a";
        String target2 = "test";
        int start = 0;
        int indx = indexOf(words, target1, target2, start);
        System.out.println(indx);
    }
}
