import java.awt.Color;
/**
 * RGBVisionFilter is a filter which filters colors to their highest 
 * RGB component, and sets the other RGB components to 0. 
 * It is a filter I thought up in high school and coded in Python.
 * No idea if it's a common filter idea.
 * This is for the extra credit opportunity.
 *
 * @author Gavin Armenti
 * @version 4/26/2026
 */
public class RGBVisionFilter extends Filter
{
    /**
     * Constructor for objects of class RGBVisionFilter.
     * @param name The name of the filter.
     */
    public RGBVisionFilter(String name)
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
                int red = image.getPixel(x, y).getRed();
                
                // The value to be given to the green component.
                int green = image.getPixel(x, y).getGreen();
                
                // The value to be given to the blue component.
                int blue = image.getPixel(x, y).getBlue();
                
                Color pixelCol;
                
                if (red > green && red > blue)
                {
                    pixelCol = new Color(red, 0,0);
                }
                else if (green > blue)
                {
                    pixelCol = new Color(0,green,0);
                }
                else
                {
                    pixelCol = new Color(0,0,blue);
                }
                
                image.setPixel(x, y, pixelCol);
            }
        }
    }
}
