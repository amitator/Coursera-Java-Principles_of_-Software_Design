package org.coursera.psd.Week_3_WordGram;

import java.util.ArrayList;
import java.util.Random;

/**
 * MarkovWord
 *
 * @author (Igor Prus)
 * @version (Oct 20/16)
 */

public class MarkovWord implements IMarkovModel{
    String[] myText;
    Random myRandom;
    int myOrder;


    public MarkovWord(int order) {
        myRandom = new Random();
        this.myOrder = order;
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String text){
        myText = text.split("\\s+");
    }

    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length - myOrder);  // random word to start with
        String key = myText[index];
        String[] startWG = new String [myOrder];
        startWG[0] = key;
        for (int i = 1; i < myOrder; i++){
            startWG[i] = myText[index + i];
        }
        WordGram wordGram = new WordGram(startWG, 0, myOrder);
        sb.append(wordGram.toString());
        for(int k=0; k < numWords - myOrder; k++){
            ArrayList<String> follows = getFollows(wordGram);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            wordGram = wordGram.shiftAdd(next);
        }

        return sb.toString().trim();
    }

    private int indexOf(String[] words, WordGram target, int start){
        int targetSize = target.length();
        for (int i = start; i < words.length - targetSize; i++){
            String[] temp = new String[targetSize];
            for (int j = 0; j < targetSize; j++){
                temp[j] = words[j + i];
            }
            WordGram tempWg = new WordGram(temp, 0, targetSize);
            if (target.equals(tempWg)){
                return i;
            }
        }
        return -1;
    }

    private ArrayList<String> getFollows(WordGram kGram) {
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        while (pos < myText.length){
            int start = indexOf(myText, kGram, pos);
            if (start == -1){
                break;
            }
            if (start + kGram.length() >= myText.length){
                break;
            }
            String next = myText[start + kGram.length()];
            follows.add(next);
            pos = ++start;
        }
        return follows;
    }

    public void testIndexOf(){
        String str = "this is just a test yes this is a simple test";
        String[] words = str.split("\\s+");
//        String target = "test";
        int start = 5;
        String[] wgStr = {"just", "a", "test"};
        WordGram wg = new WordGram(wgStr, 0, 3);
        int indx = indexOf(words, wg, start);
        System.out.println(indx);
    }

}
