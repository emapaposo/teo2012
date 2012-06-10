/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teo2012;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Image extends JPanel {

	BufferedImage img;
	BufferedImage workingImage;
	int[] arrayValues;
        int[] alphas;
        Dimension size = new Dimension();
        
        //public Vector getAlphas(){ return this.alphas; }

	public void paint(Graphics g) {
		g.drawImage(workingImage, 0, 0, null);
	}

    @Override
        protected void paintComponent(Graphics g) {
            // Center image in this component.
            int x = (getWidth() - size.width)/2;
            int y = (getHeight() - size.height)/2;
            g.drawImage(workingImage, x, y, this);
        }
        
        
	public Image(File path, int[] alphas, int index) {
		try {
			img = ImageIO.read(new File(path.getAbsolutePath()));

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
                
                size.setSize(workingImage.getWidth(), workingImage.getHeight());
		
		try {
			ImageIO.write(workingImage, "png", new File(path.getParent()+"/sherlock2.png"));
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
        
        
        public int[] getAlphaComponents(File path){
            
            try {
		img = ImageIO.read(new File(path.getAbsolutePath()));

            } catch (IOException e) {}
            
            workingImage = new BufferedImage(img.getWidth(), img.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
        
            alphas = new int[workingImage.getWidth() * workingImage.getHeight()];
            
            int k = 0;
            // decode values from alpha values
            for (int i = 0; i < workingImage.getWidth(); i++) {
		for (int j = 0; j < workingImage.getHeight(); j++) {				
                    int alpha = (workingImage.getRGB(i, j) >> 24) & 0xff;
                    alphas[k] = alpha;
                    //alphas.add(k);
                    //System.out.println(arrayValues[k]);
                    k++;
		}
            }
            
            return this.alphas;
        }
        
        
        public BufferedImage getImage(){ return this.workingImage; }

}
