import java.awt.Color;
/**
 * RedTintFilter is a filter that tints an image red.
 *
 * @author Gavin Armenti
 * @version 4/22/2026
 */
public class RedTintFilter extends Filter
{
    /**
     * Constructor for objects of class RedTintFilter.
     * @param name The name of the filter.
     */
    public RedTintFilter(String name)
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
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                
                // The value to be given to the red component.
                int newRed = image.getPixel(x, y).getRed() + 50;
                if (newRed > 255)
                {
                    newRed = 255;
                }
                
                // The value to be given to the green component.
                int newGreen = image.getPixel(x, y).getGreen();
                
                // The value to be given to the blue component.
                int newBlue = image.getPixel(x, y).getBlue();
                
                image.setPixel(x, y, new Color(newRed,newGreen,newBlue));
            }
        }
    }
}