import edu.duke.*;
import java.io.File;

/**
 * Assignment 1: Batch Grayscale
 * WAP to select and process several images to convert them to grayscale, display them and save new images (with new filenames) that are grayscale versions of each image..
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrayScale {

    public ImageResource makeGray(ImageResource inImage)
    {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for(Pixel pix : outImage.pixels())
        {
            Pixel inPixel = inImage.getPixel(pix.getX(), pix.getY());
            int avg = (inPixel.getRed()+inPixel.getGreen()+inPixel.getBlue())/3;
            pix.setRed(avg);
            pix.setGreen(avg);
            pix.setBlue(avg);
        }
        return outImage;
    }
    
    public void selectAndConvert()
    {
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            ImageResource ir = new ImageResource(f);
            ImageResource grayImage = makeGray(ir);
            String fName = ir.getFileName();
            String grayName = "gray- "+fName;
            grayImage.setFileName(grayName);
            grayImage.draw();
            grayImage.save();
        }
    }
}
