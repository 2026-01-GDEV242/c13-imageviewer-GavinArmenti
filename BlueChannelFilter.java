import java.awt.Color;
/**
 * An image filter that channels the blue component
 * to show where that component is most prominent.
 * Sets everything to black and white, but
 * the colors that are more blue are more white, and 
 * the colors with less blue are more black.
 *
 * @author Gavin Armenti
 * @version 4/22/2026
 */
public class BlueChannelFilter extends Filter
{
    /**
     * Constructor for objects of class BlueChannelFilter.
     * @param name The name of the filter.
     */
    public BlueChannelFilter(String name)
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
                int comp = image.getPixel(x, y).getBlue();
                
                image.setPixel(x, y, new Color(comp,comp,comp));
            }
        }
    }
}