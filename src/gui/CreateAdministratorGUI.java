package gui;

import javax.swing.JDialog;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class CreateAdministratorGUI extends JDialog {

	private static final long 	serialVersionUID = -3388699883293194573L;
	
	private JTextField 			textFieldEmail;
	private JPasswordField 		passwordField;
	private JPasswordField 		passwordFieldConfirm;

	public CreateAdministratorGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblEmail = new JLabel("Correo electr\u00F3nico");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(15, 15, 10, 10);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 0;
		getContentPane().add(lblEmail, gbc_lblEmail);
		
		textFieldEmail = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(15, 0, 10, 15);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		getContentPane().add(textFieldEmail, gbc_textField);
		textFieldEmail.setColumns(20);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 15, 10, 10);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 1;
		getContentPane().add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setForeground(Color.BLACK);
		passwordField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.anchor = GridBagConstraints.WEST;
		gbc_passwordField.insets = new Insets(0, 0, 10, 15);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 1;
		getContentPane().add(passwordField, gbc_passwordField);
		
		JLabel lblConfirm = new JLabel("Confirmar contrase\u00F1a");
		lblConfirm.setForeground(Color.BLACK);
		lblConfirm.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblConfirm = new GridBagConstraints();
		gbc_lblConfirm.anchor = GridBagConstraints.WEST;
		gbc_lblConfirm.insets = new Insets(0, 15, 10, 10);
		gbc_lblConfirm.gridx = 0;
		gbc_lblConfirm.gridy = 2;
		getContentPane().add(lblConfirm, gbc_lblConfirm);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setColumns(10);
		passwordFieldConfirm.setForeground(Color.BLACK);
		passwordFieldConfirm.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
		gbc_passwordField_1.anchor = GridBagConstraints.WEST;
		gbc_passwordField_1.insets = new Insets(0, 0, 10, 15);
		gbc_passwordField_1.gridx = 1;
		gbc_passwordField_1.gridy = 2;
		getContentPane().add(passwordFieldConfirm, gbc_passwordField_1);
		
		JButton btnAccept = new JButton("A\u00F1adir");
		btnAccept.setForeground(Color.BLACK);
		btnAccept.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_btnAccept = new GridBagConstraints();
		gbc_btnAccept.anchor = GridBagConstraints.EAST;
		gbc_btnAccept.insets = new Insets(0, 0, 15, 15);
		gbc_btnAccept.gridx = 1;
		gbc_btnAccept.gridy = 3;
		getContentPane().add(btnAccept, gbc_btnAccept);

	}
}