package gui;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import components.ImagePanel;
import controller.Controller;

/**
 * @author Jordan Aranda Tejada
 */
public class MainPanelGUI extends ImagePanel implements ActionListener {

	private static final long 		serialVersionUID = 1767941894706554567L;
	
	private JPanel					container;
	
	public MainPanelGUI(Controller controller) {
				
		try {
			setImageBackground(ImageIO.read(new File("img/background.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setLayout(new BorderLayout(0, 0));
		
		container = new JPanel();
		container.setOpaque(false);
		container.setLayout(new BorderLayout());
		add(container, BorderLayout.CENTER);
	}
	
	public void setContainer(JPanel panel) {
		container.removeAll();
		container.add(panel);
		container.updateUI();
	}

	public void actionPerformed(ActionEvent e) {
		
	}
}