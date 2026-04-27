import java.awt.Color;
/**
 * An image filter that creates an image made up of 4
 * quarter-size images.
 * The top left image is the original image.
 * The top right image is the image tinted red and mirrored horizontally.
 * The bottom left image is the image tinted green and mirrored vertically.
 * The bottom right image is the image tinted blue and mirrored both
 * horizontally and vertically.
 * 
 * @author Gavin Armenti
 * Some code borrowed by Michael Kölling and David J. Barnes.
 * @version 4/26/2026
 */
public class FlippedWarholFilter extends Filter
{
    /**
     * Constructor for objects of class FlippedWarholFilter.
     * @param name The name of the filter.
     */
    public FlippedWarholFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        // create new image with decreased size
        int width = image.getWidth() / 2;
        int height = image.getHeight() / 2;
        
        // The original image, but smaller
        OFImage smlIMG = new OFImage(width, height);

        // copy pixel data into new image
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                smlIMG.setPixel(x, y, image.getPixel(x * 2, y * 2));
            }
        }
        
        // Red-tinted image
        OFImage redIMG = new OFImage(smlIMG);
        RedTintFilter redTint = new RedTintFilter("reddy");
        redTint.apply(redIMG);
        
        // Green-tinted image
        OFImage greenIMG = new OFImage(smlIMG);
        GreenTintFilter greenTint = new GreenTintFilter("greenie");
        greenTint.apply(greenIMG);
        
        // Blue-tinted image
        OFImage blueIMG = new OFImage(smlIMG);
        BlueTintFilter blueTint = new BlueTintFilter("BLOOEY");
        blueTint.apply(blueIMG);
        
        for(int y = 0; y < height; y++) {
            // Original Image
            for(int x = 0; x < width; x++) {
                
                // The value to be given to R, G, and B.
                int red = smlIMG.getPixel(x, y).getRed();
                int green = smlIMG.getPixel(x, y).getGreen();
                int blue = smlIMG.getPixel(x, y).getBlue();
                
                image.setPixel(x, y, new Color(red,green,blue));
            }
            // Red image
            for(int x = 0; x < width; x++) {
                
                // The value to be given to R, G, and B.
                int red = redIMG.getPixel(x, y).getRed();
                int green = redIMG.getPixel(x, y).getGreen();
                int blue = redIMG.getPixel(x, y).getBlue();
                
                image.setPixel((width*2)-x-1, y, new Color(red,green,blue));
            }
        }
        
        
        for(int y = 0; y < height; y++) {
            // green image
            for(int x = 0; x < width; x++) {
                // The value to be given to R, G, and B.
                int red = greenIMG.getPixel(x, y).getRed();
                int green = greenIMG.getPixel(x, y).getGreen();
                int blue = greenIMG.getPixel(x, y).getBlue();
                
                image.setPixel(x,(height*2)-y-1, new Color(red,green,blue));
            }
            // blue image
            for(int x = 0; x < width; x++) {
                
                // The value to be given to R, G, and B.
                int red = blueIMG.getPixel(x, y).getRed();
                int green = blueIMG.getPixel(x, y).getGreen();
                int blue = blueIMG.getPixel(x, y).getBlue();
                
                image.setPixel((width*2)-x-1, (height*2)-y-1, new Color(red,green,blue));
            }
            
        }
    }
}
