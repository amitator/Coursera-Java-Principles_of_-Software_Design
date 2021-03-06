package org.coursera.psd.Week_3_WordGram;

/**
 * MarkovRunner
 *
 * @author (Igor Prus)
 * @version (Oct 20/16)
 */

import edu.duke.*;

public class MarkovRunner {
    public void runModel(IMarkovModel markov, String text, int size){ 
        markov.setTraining(text); 
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runModel(IMarkovModel markov, String text, int size, int seed){ 
        markov.setTraining(text); 
        markov.setRandom(seed);
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runMarkov() { 
        FileResource fr = new FileResource(); 
        String st = fr.asString(); 
        st = st.replace('\n', ' ');
        MarkovWord markovWord = new MarkovWord(5);
        int size = 50;
        int seed = 844;
        runModel(markovWord, st, size, seed);
        //MarkovWordOne markovWord = new MarkovWordOne(); 
        //runModel(markovWord, st, 200); 
    }

    public void testHashMap(){
        FileResource fr = new FileResource();
        String st = fr.asString();
//        String st = "this is a test yes this is really a test yes a test this is wow";
        st = st.replace('\n', ' ');
        EfficientMarkovWord markovWord = new EfficientMarkovWord(2);
        int size = 50;
        int seed = 65;
        runModel(markovWord, st, size, seed);
    }

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println(); 
                psize = 0;
            } 
        } 
        System.out.println("\n----------------------------------");
    } 

}
