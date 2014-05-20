package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import utils.StringUtils;
import components.ImagePanel;
import components.Menu;

import controller.Controller;

/**
 * @author Jordan Aranda Tejada
 */
public class LoginGUI extends ImagePanel implements ActionListener {

	private static final long 	serialVersionUID = 734336376406510904L;
	
	private Controller 			controller;
	
	private JTextField 			textFieldEmail;
	private JPasswordField 		passwordField;
	private JButton 			btnEnter;
	private JButton 			btnForgotPassword;

	public LoginGUI(Controller controller) {
		super();

		this.controller = controller;
		
		setBorder(new LineBorder(new Color(255, 255, 255)));
		setBackground(new Color(225, 240, 250));

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 10, 0, 10, 0 };
		gridBagLayout.rowHeights = new int[] { 10, 0, 0, 0, 0, 0, 10, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		
		JLabel lblEmail = new JLabel("Correo electr\u00F3nico");
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 1;
		add(lblEmail, gbc_lblEmail);

		textFieldEmail = new JTextField("jordan.aranda@me.com");
		textFieldEmail.setFont(new Font("Calibri", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_username = new GridBagConstraints();
		gbc_textField_username.anchor = GridBagConstraints.WEST;
		gbc_textField_username.fill = GridBagConstraints.VERTICAL;
		gbc_textField_username.insets = new Insets(0, 0, 5, 5);
		gbc_textField_username.gridx = 1;
		gbc_textField_username.gridy = 2;
		add(textFieldEmail, gbc_textField_username);
		textFieldEmail.setColumns(25);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(10, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 3;
		add(lblPassword, gbc_lblPassword);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 15));
		passwordField.setColumns(25);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.anchor = GridBagConstraints.WEST;
		gbc_passwordField.fill = GridBagConstraints.VERTICAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 4;
		add(passwordField, gbc_passwordField);
		
		JPanel panelBtns = new JPanel();
		panelBtns.setOpaque(false);
		GridBagConstraints gbc_panelBtns = new GridBagConstraints();
		gbc_panelBtns.insets = new Insets(10, 0, 5, 5);
		gbc_panelBtns.fill = GridBagConstraints.BOTH;
		gbc_panelBtns.gridx = 1;
		gbc_panelBtns.gridy = 5;
		add(panelBtns, gbc_panelBtns);
		GridBagLayout gbl_panelBtns = new GridBagLayout();
		gbl_panelBtns.columnWidths = new int[]{0, 0, 0};
		gbl_panelBtns.rowHeights = new int[]{0, 0};
		gbl_panelBtns.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panelBtns.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelBtns.setLayout(gbl_panelBtns);
		
		btnEnter = new JButton("Entrar");
		GridBagConstraints gbc_btnEnter = new GridBagConstraints();
		gbc_btnEnter.fill = GridBagConstraints.VERTICAL;
		gbc_btnEnter.anchor = GridBagConstraints.WEST;
		gbc_btnEnter.insets = new Insets(0, 0, 0, 5);
		gbc_btnEnter.gridx = 0;
		gbc_btnEnter.gridy = 0;
		panelBtns.add(btnEnter, gbc_btnEnter);
		btnEnter.setForeground(Color.BLACK);
		btnEnter.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnEnter.setBackground(new Color(137, 185, 0));
		
		btnForgotPassword = new JButton("\u00BFHas olvidado la contrase\u00F1a?");
		GridBagConstraints gbc_btnForgotPassword = new GridBagConstraints();
		gbc_btnForgotPassword.fill = GridBagConstraints.VERTICAL;
		gbc_btnForgotPassword.anchor = GridBagConstraints.EAST;
		gbc_btnForgotPassword.gridx = 1;
		gbc_btnForgotPassword.gridy = 0;
		panelBtns.add(btnForgotPassword, gbc_btnForgotPassword);
		btnForgotPassword.setContentAreaFilled(false);
		btnForgotPassword.setBorderPainted(false);
		btnForgotPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		btnForgotPassword.addActionListener(this);
		btnEnter.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnter) {
			String email = textFieldEmail.getText().trim();
			char[] password = passwordField.getPassword();
			if (email.isEmpty() || password.length == 0) {
				JOptionPane.showMessageDialog(this, "ERROR! Introduce los datos.");
			} else {
				if (controller.login(email, StringUtils.sha1(new String(password)))) {
					MainPanelGUI panel = new MainPanelGUI(controller);
					Window.getInstance().setJMenuBar(new Menu(controller, panel));
					Window.getInstance().setContainer(panel);
				}
			}
		} else if(btnForgotPassword == e.getSource()) {
			// TODO
		}
	}
}