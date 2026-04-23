import java.awt.Color;
/**
 * An image filter that channels the red component
 * to show where that component is most prominent.
 * Sets everything to black and white, but
 * the colors that are more red are more white, and 
 * the colors with less red are more black.
 *
 * @author Gavin Armenti
 * @version 4/22/2026
 */
public class RedChannelFilter extends Filter
{
    /**
     * Constructor for objects of class RedChannelFilter.
     * @param name The name of the filter.
     */
    public RedChannelFilter(String name)
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
                
                // The value to be given to R, G, and B.
                int comp = image.getPixel(x, y).getRed();
                
                image.setPixel(x, y, new Color(comp,comp,comp));
            }
        }
    }
}