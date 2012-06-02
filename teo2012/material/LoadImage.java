import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

public class LoadImage extends Component {

	BufferedImage img;
	BufferedImage workingImage;
	int[] arrayValues;

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

	public LoadImage() {
		try {
			img = ImageIO.read(new File("SherlockToWatson.bmp"));

		} catch (IOException e) {
		}

		workingImage = new BufferedImage(img.getWidth(), img.getHeight(),
				BufferedImage.TYPE_INT_ARGB);

		arrayValues = new int[img.getWidth() * img.getHeight()];

		// generate random values for alpha component
		for (int i = 0; i < arrayValues.length; i++) {
			arrayValues[i] = (int) (Math.random() * 255.0f);
			System.out.println(arrayValues[i]);
		}

		int code;

		// encode values in alpha channel
		int k = 0;
		for (int i = 0; i < img.getWidth(); i++) {
			for (int j = 0; j < img.getHeight(); j++) {
				
				code = arrayValues[k];
				k++;
				
				Color c = new Color(img.getRGB(i, j));

				int r = c.getRed();
				int g = c.getGreen();
				int b = c.getBlue();
				int a = code;

				Color newColor = new Color(r, g, b, a);
				workingImage.setRGB(i, j, newColor.getRGB());
			}
		}
		
		try {
			ImageIO.write(workingImage, "png", new File("sherlock2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		k = 0;
		// decode values from alpha values
		for (int i = 0; i < workingImage.getWidth(); i++) {
			for (int j = 0; j < workingImage.getHeight(); j++) {				
				int alpha = (workingImage.getRGB(i, j) >> 24) & 0xff;
				arrayValues[k] = alpha;
				System.out.println(arrayValues[k]);
				k++;
			}
		}
	}

	public Dimension getPreferredSize() {
		if (img == null) {
			return new Dimension(100, 100);
		} else {
			return new Dimension(img.getWidth(null), img.getHeight(null));
		}
	}

	public static void main(String[] args) {

		JFrame f = new JFrame("Load Image Sample");

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		f.add(new LoadImage());
		f.pack();
		f.setVisible(true);
	}
}