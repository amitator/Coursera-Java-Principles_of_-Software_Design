package org.coursera.psd.Week_1_Filtering_Data;

/**
 * PhraseFilter. Takes String representing the type of request that indicates where to search
 * in the title and has one of three values: (“start”, ”end”, or “any”), and 2) a String indicating
 * the phrase to search for in the title of the earthquake
 * Returns true if the phrase is found at the requested location in the title.
 *
 * @author (Igor Prus)
 * @version (0.1)
 */
public class PhraseFilter implements Filter{
    private String whereToSearch;
    private String whatToSearch;
    public PhraseFilter(String where, String what){
        this.whereToSearch = where;
        this.whatToSearch = what;
    }

    public boolean satisfies(QuakeEntry qe){
        String title = qe.getInfo();
        switch (whereToSearch) {
            case "start":
                if (title.startsWith(whatToSearch)) {
                    return true;
                }
                break;
            case "end":
                if (title.endsWith(whatToSearch)) {
                    return true;
                }
                break;
            case "any":
                if (title.contains(whatToSearch)) {
                    return true;
                }
                break;
        }
        return false;
    }

    public String getName(){
        return "Phrase";
    }
}
