package org.coursera.psd.Week_3_WordGram;

/**
 * WordGram
 *
 * @author (Igor Prus)
 * @version (Oct 20/16)
 */

public class WordGram {
    private String[] myWords;
    private int myHash;

    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        return myWords.length;
    }

    public String toString(){
        String ret = "";
        for (int i = 0; i < myWords.length; i++){
            ret = ret + myWords[i] + " ";
        }
        return ret.trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        if (this.length() != other.length()){
            return false;
        }
        for (int i = 0; i < this.length(); i++){
            if (this.myWords[i] != other.myWords[i]){
                return false;
            }
        }
        return true;

    }

    public WordGram shiftAdd(String word) {	
        WordGram out = new WordGram(myWords, 0, myWords.length);
        // shift all words one towards 0 and add word at the end. 
        // you lose the first word
        int i;
        for (i = 0; i < myWords.length - 1; i++){
            out.myWords[i] = this.myWords[i + 1];
        }
        out.myWords[i] = word;
        return out;
    }

}