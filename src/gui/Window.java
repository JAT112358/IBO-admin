package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

import components.ImagePanel;

/**
 * @author Jordan Aranda Tejada
 */
public class Window extends JFrame {
	
	private static final long	serialVersionUID	= - 8641413596663241575L;
	private static Window		instance;
	private ImagePanel			contentPane;

	private Window() {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 600);
		setMinimumSize(new Dimension(800, 600));
		setLocationRelativeTo(null);
		setTitle("IBO-Admin");
		
		contentPane = new ImagePanel();
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
	}
	
	public void setImageBackground(BufferedImage image) {
		contentPane.setImageBackground(image);
	}
	
	public BufferedImage getImageBackground() {
		return contentPane.getImageBackground();
	}
	
	public void setContainer(JPanel panel) {
		instance.getContentPane().removeAll();
		instance.getContentPane().add(panel, BorderLayout.CENTER);
		((JPanel) instance.getContentPane()).updateUI();
	}
	
	public void minimize() {
		instance.setExtendedState(JFrame.ICONIFIED);
	}
	
	public void maximize() {
		instance.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public static Window getInstance() {
		if (instance == null) {
			instance = new Window();
		}
		return instance;
	}
}