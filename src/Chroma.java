import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class Chroma {
	Robot screenCap = new Robot();

	public Chroma() throws AWTException {
		
	}
	
	
	public int getColor(int x, int y) { // Returns int representation of color
		
		Color color = screenCap.getPixelColor(x, y);
		int rgb = color.getRGB();
		return rgb;
	}
	
	public int[] getRGBAry(int x, int y) { // Returns an array containing RGB values of the pixel
		
		Color color = screenCap.getPixelColor(x, y);
		int[] rgb = new int[3];
		
		 rgb[0] = color.getRed();
		 rgb[1] = color.getBlue();
		 rgb[2] = color.getGreen();
		
		return rgb;
		
	}
	
	public float[] getHSB(int x, int y) { // Returns a float array containing HSB values of the pixel
		BufferedImage desktopCapture = screenCap.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		int color = desktopCapture.getRGB(x, y);
		float hsb[] = new float[3];
		
	    int r = (color >> 16) & 0xFF;
		int g = (color >>  8) & 0xFF;
		int b = (color      ) & 0xFF;
		Color.RGBtoHSB(r, g, b, hsb);
		
		return hsb;
		
	}
	

}
