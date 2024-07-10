
/**
 * Write a description of PerimeterMultipleFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.File;

public class PerimeterMultipleFiles {

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
    
    
    public double getLargestPerimeterMultipleFiles()
    {
        double largePeri = 0.0;
        
        DirectoryResource dr = new DirectoryResource();
         for (File f : dr.selectedFiles()) {
             FileResource fr = new FileResource(f);
             Shape s = new Shape(fr);
             double peri = getPerimeter(s);
             if(peri > largePeri)
             {
                 largePeri = peri;
             }
         }
        
        return largePeri;
    }
    
    public void testPerimeterMultipleFiles()
    {
        double largestPeri = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter is "+largestPeri);
    }
    
    public String getFileWithLargestPerimeter()
    {
        File temp = null;
        
        double largePeri = 0.0;
        
        DirectoryResource dr = new DirectoryResource();
         for (File f : dr.selectedFiles()) {
             FileResource fr = new FileResource(f);
             Shape s = new Shape(fr);
             double peri = getPerimeter(s);
             if(peri > largePeri)
             {
                 largePeri = peri;
                 temp = f;
             }
         }
        
        return temp.getName();
    }
    
    public void testFileWithLargestPerimeter()
    {
        String file = getFileWithLargestPerimeter();
        System.out.println("File with Largest Perimeter is '"+file+"'");
    }
    
    public static void main(String[] args)
    {
        PerimeterMultipleFiles pm = new PerimeterMultipleFiles();
        pm.testPerimeterMultipleFiles();
        pm.testFileWithLargestPerimeter();
    }
}
