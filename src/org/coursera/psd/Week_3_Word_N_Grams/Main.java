package org.coursera.psd.Week_3_Word_N_Grams;

/**
 * MarkovZero
 *
 * @author (Igor Prus)
 * @version (Oct 18/16)
 */

public class Main {
    public static void main(String[] args) {
//        MarkovWordOne markov = new MarkovWordOne();
//        markov.testIndexOf();
        MarkovRunner markov = new MarkovRunner();
        markov.runMarkov();
    }
}
