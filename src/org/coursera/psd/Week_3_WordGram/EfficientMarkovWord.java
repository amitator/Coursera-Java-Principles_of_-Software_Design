package org.coursera.psd.Week_3_WordGram;

import java.util.*;

/**
 * EfficientMarkovWord
 *
 * @author (Igor Prus)
 * @version (Oct 20/16)
 */

public class EfficientMarkovWord implements IMarkovModel{
    private String[] myText;
    private Random myRandom;
    private int myOrder;
    private Map<WordGram, List<String>> myMap;


    public EfficientMarkovWord(int myOrder) {
        this.myOrder = myOrder;
        myRandom = new Random();
    }

    private Map<WordGram, List<String>> buildMap() {
        Map<WordGram, List<String>> mappedWords = new HashMap<>();
        int counter = 0;
        while (counter < myText.length - (myOrder - 1)) {
            WordGram wordGram = new WordGram(myText, counter, myOrder);
            if (!mappedWords.containsKey(wordGram) && counter + myOrder < myText.length) {
                mappedWords.put(wordGram, new ArrayList<>(Arrays.asList(myText[counter + myOrder])));
            }
            else if (mappedWords.containsKey(wordGram) && counter + myOrder < myText.length) {
                List<String> currentValues = mappedWords.get(wordGram);
                currentValues.add(myText[counter + myOrder]);
                mappedWords.put(wordGram, currentValues);
            }
            else if (!mappedWords.containsKey(wordGram) && counter + myOrder == myText.length) {
                mappedWords.put(wordGram, new ArrayList<String>());
            }
            counter++;
        }
        return mappedWords;
    }


    @Override
    public void setTraining(String text) {
        myText = text.split("\\s+");
    }

    @Override
    public String getRandomText(int numWords) {
        myMap = buildMap();
        printHashMapInfo();
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length - myOrder);  // random word to start with
        WordGram kGram = new WordGram(myText, index, myOrder);
        sb.append(kGram.toString()).append(" ");
        for (int k = 0; k < numWords - 1; k++) {
            List<String> follows = getFollows(kGram);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next).append(" ");
            kGram = kGram.shiftAdd(next);
        }
        return sb.toString().trim();
    }

    @Override
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    protected int indexOf(String[] words, WordGram target, int start) {
        for (int i = start; i < words.length - target.length(); i++) {
            if (words[i].equals(target.wordAt(0))) {
                boolean targetFound = true;
                for (int j = 1; j < target.length(); j++) {
                    if (!words[i + j].equals(target.wordAt(j))) {
                        targetFound = false;
                        break;
                    }
                }
                if (targetFound) {
                    return i;
                }
            }
        }
        return -1;
    }

    protected List<String> getFollows(WordGram kGram) {
        List<String> follows = new ArrayList<>();
        int counter = 0;
        while (counter < myText.length - kGram.length()) {
            int foundKey = indexOf(myText, kGram, counter);
            if (foundKey == -1 || foundKey + kGram.length() >= myText.length - 1) {
                break;
            }
            String next = myText[foundKey + kGram.length()];
            follows.add(next);
            counter = foundKey + kGram.length();
        }
        return follows;
    }

    public void printHashMapInfo() {
        int largest = 0;
        for (WordGram wordGram : myMap.keySet()) {
            if (myMap.get(wordGram).size() > largest) {
                largest = myMap.get(wordGram).size();
            }
        }
        System.out.println("Number of keys in hashmap: " + myMap.size());
        System.out.println("Size of largest value in hashmap: " + largest);
        System.out.println("Keys that have maximum value: ");
        for (WordGram wordGram : myMap.keySet()) {
            if (myMap.get(wordGram).size() == largest) {
                System.out.println(wordGram.toString());
            }
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
