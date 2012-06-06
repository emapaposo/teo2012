/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teo2012;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;

public class Image extends Component {

	BufferedImage img;
	BufferedImage workingImage;
	int[] arrayValues;
        int[] alphas;
        
        //public Vector getAlphas(){ return this.alphas; }

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
        
        
/*        public Image(String path, Vector alfas){
            try {
		img = ImageIO.read(new File(path));
            } catch (IOException e) {}
            
            workingImage = new BufferedImage(img.getWidth(), img.getHeight(),
		BufferedImage.TYPE_INT_ARGB);
            
            // encode values in alpha channel
            int alfaSize = alfas.size();
            int k = 0;
            int code;
            for (int i = 0; i < img.getWidth(); i++) {
                for (int j = 0; j < img.getHeight(); j++) {
                        //code = arrayValues[k];
                        
                        if (k < alfaSize){
                            code = (Integer) alfas.get(k);
                            k++;
                        }else{
                            code = 0;
                        }

                        Color c = new Color(img.getRGB(i, j));

                        int r = c.getRed();
                        int g = c.getGreen();
                        int b = c.getBlue();
                        int a = code;

                        Color newColor = new Color(r, g, b, a);
                        workingImage.setRGB(i, j, newColor.getRGB());
                        
                        try {
                            ImageIO.write(workingImage, "png", new File("sherlock2.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        } 
                }
            }
        }
        
*/
	public Image(String path, int[] alphas, int index) {
		try {
			img = ImageIO.read(new File(path));

		} catch (IOException e) {
		}

		workingImage = new BufferedImage(img.getWidth(), img.getHeight(),
				BufferedImage.TYPE_INT_ARGB);

		arrayValues = new int[img.getWidth() * img.getHeight()];

		// generate random values for alpha component
		/*for (int i = 0; i < arrayValues.length; i++) {
			arrayValues[i] = (int) (Math.random() * 255.0f);
			System.out.println(arrayValues[i]);
		}*/

		int code;

		// encode values in alpha channel
		int k = 0;
		for (int i = 0; i < img.getWidth(); i++) {
			for (int j = 0; j < img.getHeight(); j++) {
				
				if (k < index){
                                    code = alphas[k];
                                    k++;
                                }else{ code = 255; }
				
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

		
	//	k = 0;
		// decode values from alpha values
	/*	for (int i = 0; i < workingImage.getWidth(); i++) {
			for (int j = 0; j < workingImage.getHeight(); j++) {				
				int alpha = (workingImage.getRGB(i, j) >> 24) & 0xff;
				arrayValues[k] = alpha;
                                //alphas.add(k);
				//System.out.println(arrayValues[k]);
				k++;
			}
		} */
	}
        
        public BufferedImage getImage(){ return this.workingImage; }

//	public Dimension getPreferredSize() {
//		if (img == null) {
//			return new Dimension(100, 100);
//		} else {
//			return new Dimension(img.getWidth(null), img.getHeight(null));
//		}
//	}

}
