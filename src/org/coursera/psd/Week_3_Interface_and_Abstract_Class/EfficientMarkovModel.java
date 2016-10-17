package org.coursera.psd.Week_3_Interface_and_Abstract_Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * EfficientMarkovModel
 *
 * @author (Igor Prus)
 * @version (Oct 17/16)
 */

public class EfficientMarkovModel extends AbstractMarkovModel{
    private int number;
    private Map<String, ArrayList<String>> map = new HashMap<>();

    public EfficientMarkovModel(int num) {
        myRandom = new Random();
        this.number = num;
    }

    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        myText = s.trim();
        buildHashMap();
        printHashMapInfo();
    }

    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - number);
        String key = myText.substring(index, index + number);
        sb.append(key);
        for(int k=0; k < numChars - number; k++){
            ArrayList<String> list = getFollows(key);
            if (list.size() == 0){
                break;
            }
            index = myRandom.nextInt(list.size());
            String next = list.get(index);
            sb.append(next);
            if (number == 0 || number == 1){
                key = next;
            } else {
                key = key.substring(1) + next;
            }
        }
        return sb.toString();
    }

    private void buildHashMap(){
        for (int i = 0; i < myText.length() - number; i++) {
            ArrayList<String> result = new ArrayList<>();
            int index = i;
            String key = myText.substring(i, number + i);
            if (!map.containsKey(key)) {
                int last = myText.lastIndexOf(key);
                while (index <= last) {
                    index = myText.indexOf(key, index);
                    if (index + key.length() == myText.length()) {
                        break;
                    }
                    result.add(String.valueOf(myText.charAt(index + key.length())));
                    index++;
                }
                map.put(key, result);
            }
        }
    }

    protected ArrayList<String> getFollows(String key){
        return map.get(key);
    }

    public void printHashMapInfo(){
        int maxValue = 0;
        String maxKey = "";
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
            int currentArraySize = entry.getValue().size();
            if (currentArraySize > maxValue){
                maxValue = currentArraySize;
                maxKey = entry.getKey();
            }
        }
        System.out.println("Number of KEYs in HashMap: " + map.size());
        System.out.println("Size of largest value: " + maxValue);
        System.out.println("maxValue KEY: " + maxKey);
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            if (entry.getValue().size() == maxValue) {
                System.out.println(entry.getKey() + "\t" + entry.getValue());
            }
        }
    }

    @Override
    public String toString(){
        return "MarkovModel of order: " + number;
    }
}
