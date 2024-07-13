import edu.duke.*;
import java.io.File;
/**
 * Assignment 2: Image Inversion
 * Write a program to create new images that are photographic negatives (or inverted images) of selected images and save these new images with filenames that are related to the original images, such as adding “inverted-” in front of the old filename. 
 *  In inverting an image, a pixel’s red, blue, and green components are modified to be the exact opposite within the 0 to 255 range. 
 *  That is, if a pixel’s red, blue, and green values are (34, 198, 240), then that same pixel in the inverted image would have the red, blue and green values of (221, 57, 15). 
    Note that 255 - 34 is 221, 255 - 198 is 57, and 255 - 240 is 15.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageInversion {

    public ImageResource invertImage(ImageResource inImage)
    {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for(Pixel pix : outImage.pixels())
        {
            Pixel inPixel = inImage.getPixel(pix.getX(), pix.getY());
            int red = inPixel.getRed();
            int green = inPixel.getGreen();
            int blue = inPixel.getBlue();
            pix.setRed(255-red);
            pix.setGreen(255-green);
            pix.setBlue(255-blue);
        }
        return outImage;
    }
    
    public void selectAndConvert()
    {
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            ImageResource ir = new ImageResource(f);
            ImageResource invertedImage = invertImage(ir);
            String fName = ir.getFileName();
            String invertName = "inverted- "+fName;
            invertedImage.setFileName(invertName);
            invertedImage.draw();
            invertedImage.save();
        }
    }
}
