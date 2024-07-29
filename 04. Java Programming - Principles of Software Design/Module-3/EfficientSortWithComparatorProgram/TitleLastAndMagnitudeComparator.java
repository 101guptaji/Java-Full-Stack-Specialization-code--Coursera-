import java.util.*;

/**
 * Write a description of TitleLastAndMagnitudeComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {

    public int compare(QuakeEntry qe1, QuakeEntry qe2) {
        int endIndex1 = qe1.getInfo().lastIndexOf(" ");
        String titleEnd1 = qe1.getInfo().substring(endIndex1);
        
        int endIndex2 = qe2.getInfo().lastIndexOf(" ");
        String titleEnd2 = qe2.getInfo().substring(endIndex2);
        
        if(titleEnd1.compareTo(titleEnd2) == 0)
        {
            return Double.compare(qe1.getMagnitude(), qe2.getMagnitude());
        }
        else
        {
            return titleEnd1.compareTo(titleEnd2);
        }
    }
}
