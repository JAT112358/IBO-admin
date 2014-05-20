package components;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * @author Jordan Aranda Tejada
 */
public class ImagePanel extends JPanel {
	
	private static final long 	serialVersionUID = 2271887043274765565L;
	private BufferedImage 		background;
	
	public ImagePanel() {
	}
	
	public ImagePanel(BufferedImage background) {
		this.background = background;
	}
	
	public BufferedImage getImageBackground() {
		return background;
	}
	
	public void setImageBackground(BufferedImage background) {
		this.background = background;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(background != null)
			g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}