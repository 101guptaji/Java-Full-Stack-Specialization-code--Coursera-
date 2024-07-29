
/**
 * Write the class DepthFilter that implements Filter. 
 * This class should include private instance variables for a minimum and maximum depth, a constructor to initialize those variables, and a satisfies method that returns true if a QuakeEntry’s depth is between the minimum and maximum depths, or equal to one of them. 
 * Otherwise it should return false. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DepthFilter implements Filter
{
    private double minDepth, maxDepth; 
    
    public DepthFilter(double min, double max) { 
        minDepth = min;
        maxDepth = max;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return qe.getDepth() >= minDepth && 
                qe.getDepth() <= maxDepth; 
    } 
    
    public String getName()
    {
        return "Depth";
    }
}
