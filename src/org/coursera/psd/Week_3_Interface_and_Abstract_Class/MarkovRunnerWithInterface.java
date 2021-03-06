package org.coursera.psd.Week_3_Interface_and_Abstract_Class;

/**
 * MarkovRunnerWithInterface
 *
 * @author (Igor Prus)
 * @version (Oct 17/16)
 */

import edu.duke.*; 

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setTraining(text);
		markov.setRandom(seed);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
//            markov.setRandom(seed);
            String st= markov.getRandomText(size);
			printOut(st);
		}
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 500;
		int seed = 953;
		
//        MarkovZero mz = new MarkovZero();
//        runModel(mz, st, size, seed);
    
//        MarkovOne mOne = new MarkovOne();
//        runModel(mOne, st, size, seed);
////
        MarkovModel mThree = new MarkovModel(7);
        runModel(mThree, st, size, seed);
//
//        MarkovFour mFour = new MarkovFour();
//        runModel(mFour, st, size, seed);

    }

	public void testHashMap(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
//        String st = "yes-this-is-a-thin-pretty-pink-thistle";
        int size = 500;
        int seed = 531;
		EfficientMarkovModel markovModel = new EfficientMarkovModel(5);
        runModel(markovModel, st, size, seed);
	}

    public void compareMethods(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 1000;
        int seed = 42;
        EfficientMarkovModel markovModel = new EfficientMarkovModel(2);
        runModel(markovModel, st, size, seed);
        MarkovModel mThree = new MarkovModel(2);
        runModel(mThree, st, size, seed);
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
