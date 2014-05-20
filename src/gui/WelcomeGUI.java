package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import utils.Preferences;
import components.ImagePanel;
import controller.Controller;

/**
 * @author Jordan Aranda Tejada
 */
public class WelcomeGUI extends ImagePanel implements ActionListener {

	private static final long 		serialVersionUID = 1767941894706554567L;
	
	private HashMap<String, String>	lookNFeelHashMap;
	private String					currentLookAndFeel;
	
	private JPanel					container;
	private JComboBox<String>		comboBoxAppearance;
	
	public WelcomeGUI(Controller controller) {
				
		try {
			setImageBackground(ImageIO.read(new File("img/background.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		container = new JPanel();
		container.setLayout(new BorderLayout());
		GridBagConstraints gbc_containerPanel = new GridBagConstraints();
		gbc_containerPanel.insets = new Insets(0, 0, 5, 5);
		gbc_containerPanel.fill = GridBagConstraints.BOTH;
		gbc_containerPanel.gridx = 1;
		gbc_containerPanel.gridy = 1;
		add(container, gbc_containerPanel);
		
		LoginGUI loginGUI = new LoginGUI(controller);
		container.add(loginGUI);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setOpaque(false);
		GridBagConstraints gbc_bottomPanel = new GridBagConstraints();
		gbc_bottomPanel.gridwidth = 3;
		gbc_bottomPanel.insets = new Insets(0, 15, 15, 15);
		gbc_bottomPanel.fill = GridBagConstraints.BOTH;
		gbc_bottomPanel.gridx = 0;
		gbc_bottomPanel.gridy = 3;
		add(bottomPanel, gbc_bottomPanel);
		GridBagLayout gbl_bottomPanel = new GridBagLayout();
		gbl_bottomPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_bottomPanel.rowHeights = new int[]{0, 0};
		gbl_bottomPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_bottomPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		bottomPanel.setLayout(gbl_bottomPanel);
		
		JLabel lblApearance = new JLabel("Apariencia");
		lblApearance.setForeground(new Color(225, 240, 250));
		lblApearance.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblApearance = new GridBagConstraints();
		gbc_lblApearance.insets = new Insets(0, 0, 0, 5);
		gbc_lblApearance.anchor = GridBagConstraints.EAST;
		gbc_lblApearance.gridx = 3;
		gbc_lblApearance.gridy = 0;
		bottomPanel.add(lblApearance, gbc_lblApearance);
		
		comboBoxAppearance = new JComboBox<String>(getAvailableLF());
		comboBoxAppearance.addActionListener(this);
		comboBoxAppearance.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBoxAppearance.setSelectedItem(currentLookAndFeel);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 4;
		gbc_comboBox_1.gridy = 0;
		bottomPanel.add(comboBoxAppearance, gbc_comboBox_1);
	}
	
	private Vector<String> getAvailableLF() {
		final LookAndFeelInfo lfs[] = UIManager.getInstalledLookAndFeels();
		lookNFeelHashMap = new HashMap<String, String>(lfs.length);
		final Vector<String> v = new Vector<String>(lfs.length);

		for (final LookAndFeelInfo lf2: lfs) {
			lookNFeelHashMap.put(lf2.getName(), lf2.getClassName());
			v.add(lf2.getName());
			if (Preferences.getLookAndFeel().equals(lf2.getClassName())) {
				currentLookAndFeel = lf2.getName();
			}
		}
		return v;
	}
	
	public void setContainer(JPanel panel) {
		container.removeAll();
		container.add(panel);
		container.updateUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(comboBoxAppearance == e.getSource()) {
			Preferences.setLookAndFeelClass(lookNFeelHashMap.get(comboBoxAppearance.getSelectedItem()));
			
			try {
				UIManager.setLookAndFeel(lookNFeelHashMap.get(comboBoxAppearance.getSelectedItem()));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
			SwingUtilities.updateComponentTreeUI(Window.getInstance());
		}
	}
}