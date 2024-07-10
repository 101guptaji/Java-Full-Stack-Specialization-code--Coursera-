
/**
 * Write a description of PerimeterAssignmentRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class PerimeterAssignmentRunner {
    
    public double getPerimeter(Shape s)
    {
        double totalPeri = 0.0;
        Point prePt = s.getLastPoint();
        for(Point currPt : s.getPoints())
        {
            double currDist = prePt.distance(currPt);
            totalPeri = totalPeri+currDist;
            prePt = currPt;
        }
        return totalPeri;
    }

    public int getNumPoints(Shape s)
    {
        int count = 0;
        for(Point currPt : s.getPoints())
        {
            count++;
        }
        return count;
    }
    
    public double getAverageLength(Shape s)
    {   
        
        double peri = getPerimeter(s);
        int noOfSides = getNumPoints(s);
        double avgLen = peri/noOfSides;
        return avgLen;
    }
    
    public double getLargestSide(Shape s)
    {
        double largeSide = 0.0;
        Point prePt = s.getLastPoint();
        for(Point currPt : s.getPoints())
        {
            double currDist = prePt.distance(currPt);
            if(largeSide < currDist){
                largeSide = currDist;
            }
            prePt = currPt;
        }
        return largeSide;
    }
    
    public double getLargestX(Shape s)
    {
        double largeX = 0.0;
        for(Point p : s.getPoints())
        {
            if(largeX < p.getX())
            {
                largeX = p.getX();
            }
        }
        return largeX;
    }
    
    public void testPerimeter()
    {
        FileResource f = new FileResource();
        Shape s = new Shape(f);
        double peri = getPerimeter(s);
        System.out.println("Perimeter = "+peri);
        int noOfSides = getNumPoints(s);
        System.out.println("No. of Sides: "+noOfSides);
        double avgLen = getAverageLength (s);
        System.out.println("The average length of a side in your shape is "+avgLen);
        double largestSide = getLargestSide(s);
        System.out.println("Largest Side length is "+largestSide);
        double largeX = getLargestX(s);
        System.out.println("Largest X is "+largeX);
    }

    public static void main(String[] args)
    {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }

}
