package org.coursera.psd.Week_1_Filtering_Data;

import java.util.ArrayList;

/**
 * This is MatchAllFilter.
 *
 * @author (Igor Prus)
 * @version (0.1)
 */

public class MatchAllFilter implements Filter{
    private ArrayList<Filter> filters;
    public MatchAllFilter(){
        filters = new ArrayList<Filter>();
    }

    public void addFilter(Filter filter){
        filters.add(filter);
    }

    public boolean satisfies(QuakeEntry qe){
        for (Filter f : filters){
            if (!f.satisfies(qe)){
                return false;
            }
        }
        return true;
    }

    public String getName(){
        String result = "";
        for (Filter filter : filters){
            result = result + filter.getName() + " ";
        }
        return result;
    }

}
