package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import dto.ClientDTO;
import java.awt.Font;
import java.awt.Color;

/**
 * @author Jordan Aranda Tejada
 */
public class ClientGUI extends JPanel {

	private static final long serialVersionUID = -3580372059629220552L;

	public ClientGUI(ClientDTO client) {
		setOpaque(false);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 2.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0, 175));
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.LIGHT_GRAY);
		lblId.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.WEST;
		gbc_lblId.insets = new Insets(15, 25, 5, 10);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		panel.add(lblId, gbc_lblId);
		
		JLabel lblIdClient = new JLabel(Long.toString(client.getId()));
		lblIdClient.setForeground(Color.WHITE);
		lblIdClient.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblIdClient = new GridBagConstraints();
		gbc_lblIdClient.anchor = GridBagConstraints.WEST;
		gbc_lblIdClient.gridwidth = 3;
		gbc_lblIdClient.insets = new Insets(15, 0, 5, 10);
		gbc_lblIdClient.gridx = 1;
		gbc_lblIdClient.gridy = 0;
		panel.add(lblIdClient, gbc_lblIdClient);
		
		JLabel lblPersonalData = new JLabel("DATOS PERSONALES");
		lblPersonalData.setBackground(Color.BLACK);
		lblPersonalData.setForeground(new Color(50, 205, 50));
		lblPersonalData.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPersonalData = new GridBagConstraints();
		gbc_lblPersonalData.anchor = GridBagConstraints.WEST;
		gbc_lblPersonalData.gridwidth = 4;
		gbc_lblPersonalData.insets = new Insets(10, 25, 5, 10);
		gbc_lblPersonalData.gridx = 0;
		gbc_lblPersonalData.gridy = 1;
		panel.add(lblPersonalData, gbc_lblPersonalData);
		
		JLabel lblName = new JLabel("Nombre");
		lblName.setForeground(Color.LIGHT_GRAY);
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.gridwidth = 2;
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(5, 35, 5, 10);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 2;
		panel.add(lblName, gbc_lblName);
		
		JLabel lblNameClient = new JLabel(client.getName());
		lblNameClient.setForeground(Color.WHITE);
		lblNameClient.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNameClient = new GridBagConstraints();
		gbc_lblNameClient.anchor = GridBagConstraints.WEST;
		gbc_lblNameClient.gridwidth = 2;
		gbc_lblNameClient.insets = new Insets(5, 0, 5, 10);
		gbc_lblNameClient.gridx = 2;
		gbc_lblNameClient.gridy = 2;
		panel.add(lblNameClient, gbc_lblNameClient);
		
		JLabel lblLastname = new JLabel("Apellidos");
		lblLastname.setForeground(Color.LIGHT_GRAY);
		lblLastname.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblLastname = new GridBagConstraints();
		gbc_lblLastname.gridwidth = 2;
		gbc_lblLastname.anchor = GridBagConstraints.WEST;
		gbc_lblLastname.insets = new Insets(5, 35, 5, 10);
		gbc_lblLastname.gridx = 0;
		gbc_lblLastname.gridy = 3;
		panel.add(lblLastname, gbc_lblLastname);
		
		JLabel lblLastnameClient = new JLabel(client.getLastname());
		lblLastnameClient.setForeground(Color.WHITE);
		lblLastnameClient.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblLastnameClient = new GridBagConstraints();
		gbc_lblLastnameClient.anchor = GridBagConstraints.WEST;
		gbc_lblLastnameClient.gridwidth = 2;
		gbc_lblLastnameClient.insets = new Insets(5, 0, 5, 10);
		gbc_lblLastnameClient.gridx = 2;
		gbc_lblLastnameClient.gridy = 3;
		panel.add(lblLastnameClient, gbc_lblLastnameClient);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.LIGHT_GRAY);
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.gridwidth = 2;
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(5, 35, 5, 10);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 4;
		panel.add(lblEmail, gbc_lblEmail);
		
		JLabel lblEmailClient = new JLabel(client.getEmail());
		lblEmailClient.setForeground(Color.WHITE);
		lblEmailClient.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblEmailClient = new GridBagConstraints();
		gbc_lblEmailClient.anchor = GridBagConstraints.WEST;
		gbc_lblEmailClient.gridwidth = 2;
		gbc_lblEmailClient.insets = new Insets(5, 0, 5, 10);
		gbc_lblEmailClient.gridx = 2;
		gbc_lblEmailClient.gridy = 4;
		panel.add(lblEmailClient, gbc_lblEmailClient);
		
		JLabel lblTelephone = new JLabel("Tel\u00E9fono");
		lblTelephone.setForeground(Color.LIGHT_GRAY);
		lblTelephone.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblTelephone = new GridBagConstraints();
		gbc_lblTelephone.gridwidth = 2;
		gbc_lblTelephone.anchor = GridBagConstraints.WEST;
		gbc_lblTelephone.insets = new Insets(5, 35, 5, 10);
		gbc_lblTelephone.gridx = 0;
		gbc_lblTelephone.gridy = 5;
		panel.add(lblTelephone, gbc_lblTelephone);
		
		JLabel lblTelephoneClient = new JLabel(Integer.toString(client.getTelephone()));
		lblTelephoneClient.setForeground(Color.WHITE);
		lblTelephoneClient.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblTelephoneClient = new GridBagConstraints();
		gbc_lblTelephoneClient.anchor = GridBagConstraints.WEST;
		gbc_lblTelephoneClient.gridwidth = 2;
		gbc_lblTelephoneClient.insets = new Insets(5, 0, 5, 10);
		gbc_lblTelephoneClient.gridx = 2;
		gbc_lblTelephoneClient.gridy = 5;
		panel.add(lblTelephoneClient, gbc_lblTelephoneClient);
		
		JLabel lblBusinessDate = new JLabel("DATOS COMERCIALES");
		lblBusinessDate.setBackground(Color.BLACK);
		lblBusinessDate.setForeground(new Color(50, 205, 50));
		lblBusinessDate.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblBusinessDate = new GridBagConstraints();
		gbc_lblBusinessDate.anchor = GridBagConstraints.WEST;
		gbc_lblBusinessDate.gridwidth = 4;
		gbc_lblBusinessDate.insets = new Insets(10, 25, 5, 10);
		gbc_lblBusinessDate.gridx = 0;
		gbc_lblBusinessDate.gridy = 6;
		panel.add(lblBusinessDate, gbc_lblBusinessDate);
		
		JLabel lblBusiness = new JLabel("Comercio");
		lblBusiness.setForeground(Color.LIGHT_GRAY);
		lblBusiness.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblBusiness = new GridBagConstraints();
		gbc_lblBusiness.gridwidth = 2;
		gbc_lblBusiness.anchor = GridBagConstraints.WEST;
		gbc_lblBusiness.insets = new Insets(5, 35, 5, 10);
		gbc_lblBusiness.gridx = 0;
		gbc_lblBusiness.gridy = 7;
		panel.add(lblBusiness, gbc_lblBusiness);
		
		JLabel lblBusinessClient = new JLabel(client.getBusiness());
		lblBusinessClient.setForeground(Color.WHITE);
		lblBusinessClient.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblBusinessClient = new GridBagConstraints();
		gbc_lblBusinessClient.anchor = GridBagConstraints.WEST;
		gbc_lblBusinessClient.gridwidth = 2;
		gbc_lblBusinessClient.insets = new Insets(5, 0, 5, 10);
		gbc_lblBusinessClient.gridx = 2;
		gbc_lblBusinessClient.gridy = 7;
		panel.add(lblBusinessClient, gbc_lblBusinessClient);
		
		JLabel lblImage = new JLabel("Foto");
		lblImage.setForeground(Color.LIGHT_GRAY);
		lblImage.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblImage = new GridBagConstraints();
		gbc_lblImage.gridwidth = 2;
		gbc_lblImage.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblImage.insets = new Insets(5, 35, 5, 10);
		gbc_lblImage.gridx = 0;
		gbc_lblImage.gridy = 8;
		panel.add(lblImage, gbc_lblImage);
		
		JLabel lblDescription = new JLabel("Descripci\u00F3n");
		lblDescription.setForeground(Color.LIGHT_GRAY);
		lblDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.gridwidth = 2;
		gbc_lblDescription.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDescription.insets = new Insets(5, 35, 5, 10);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 9;
		panel.add(lblDescription, gbc_lblDescription);
		
		JLabel lblAddress = new JLabel("Direcci\u00F3n");
		lblAddress.setForeground(Color.LIGHT_GRAY);
		lblAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.gridwidth = 2;
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.insets = new Insets(5, 35, 5, 10);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 10;
		panel.add(lblAddress, gbc_lblAddress);
		
		JLabel lblAddressClient = new JLabel(client.getAddress());
		lblAddressClient.setForeground(Color.WHITE);
		lblAddressClient.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblAddressClient = new GridBagConstraints();
		gbc_lblAddressClient.anchor = GridBagConstraints.WEST;
		gbc_lblAddressClient.gridwidth = 2;
		gbc_lblAddressClient.insets = new Insets(5, 0, 5, 10);
		gbc_lblAddressClient.gridx = 2;
		gbc_lblAddressClient.gridy = 10;
		panel.add(lblAddressClient, gbc_lblAddressClient);
		
		JLabel lblTown = new JLabel("Ciudad");
		lblTown.setForeground(Color.LIGHT_GRAY);
		lblTown.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblTown = new GridBagConstraints();
		gbc_lblTown.gridwidth = 2;
		gbc_lblTown.anchor = GridBagConstraints.WEST;
		gbc_lblTown.insets = new Insets(5, 35, 5, 10);
		gbc_lblTown.gridx = 0;
		gbc_lblTown.gridy = 11;
		panel.add(lblTown, gbc_lblTown);
		
		JLabel lblTownClient = new JLabel(client.getTown().getName());
		lblTownClient.setForeground(Color.WHITE);
		lblTownClient.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblTownClient = new GridBagConstraints();
		gbc_lblTownClient.anchor = GridBagConstraints.WEST;
		gbc_lblTownClient.gridwidth = 2;
		gbc_lblTownClient.insets = new Insets(5, 0, 5, 10);
		gbc_lblTownClient.gridx = 2;
		gbc_lblTownClient.gridy = 11;
		panel.add(lblTownClient, gbc_lblTownClient);
		
		JLabel lblWeb = new JLabel("P\u00E1gina web");
		lblWeb.setForeground(Color.LIGHT_GRAY);
		lblWeb.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblWeb = new GridBagConstraints();
		gbc_lblWeb.gridwidth = 2;
		gbc_lblWeb.anchor = GridBagConstraints.WEST;
		gbc_lblWeb.insets = new Insets(5, 35, 5, 10);
		gbc_lblWeb.gridx = 0;
		gbc_lblWeb.gridy = 12;
		panel.add(lblWeb, gbc_lblWeb);
		
		JLabel lblWebClient = new JLabel(client.getWebsite());
		lblWebClient.setForeground(Color.WHITE);
		lblWebClient.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblWebClient = new GridBagConstraints();
		gbc_lblWebClient.anchor = GridBagConstraints.WEST;
		gbc_lblWebClient.gridwidth = 2;
		gbc_lblWebClient.insets = new Insets(5, 0, 5, 10);
		gbc_lblWebClient.gridx = 2;
		gbc_lblWebClient.gridy = 12;
		panel.add(lblWebClient, gbc_lblWebClient);
		
		JLabel lblSummerTime = new JLabel("Horario de verano");
		lblSummerTime.setForeground(Color.LIGHT_GRAY);
		lblSummerTime.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblSummerTime = new GridBagConstraints();
		gbc_lblSummerTime.gridwidth = 3;
		gbc_lblSummerTime.anchor = GridBagConstraints.WEST;
		gbc_lblSummerTime.insets = new Insets(5, 35, 5, 10);
		gbc_lblSummerTime.gridx = 0;
		gbc_lblSummerTime.gridy = 13;
		panel.add(lblSummerTime, gbc_lblSummerTime);
		
		JLabel lblSummerTimeClient = new JLabel(client.getSummerTime());
		lblSummerTimeClient.setForeground(Color.WHITE);
		lblSummerTimeClient.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblSummerTimeClient = new GridBagConstraints();
		gbc_lblSummerTimeClient.anchor = GridBagConstraints.WEST;
		gbc_lblSummerTimeClient.insets = new Insets(5, 0, 5, 10);
		gbc_lblSummerTimeClient.gridx = 3;
		gbc_lblSummerTimeClient.gridy = 13;
		panel.add(lblSummerTimeClient, gbc_lblSummerTimeClient);
		
		JLabel lblWinterTime = new JLabel("Horario de invierno");
		lblWinterTime.setForeground(Color.LIGHT_GRAY);
		lblWinterTime.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblWinterTime = new GridBagConstraints();
		gbc_lblWinterTime.anchor = GridBagConstraints.WEST;
		gbc_lblWinterTime.gridwidth = 3;
		gbc_lblWinterTime.insets = new Insets(5, 35, 5, 10);
		gbc_lblWinterTime.gridx = 0;
		gbc_lblWinterTime.gridy = 14;
		panel.add(lblWinterTime, gbc_lblWinterTime);
		
		JLabel lblWinterTimeClient = new JLabel(client.getWinterTime());
		lblWinterTimeClient.setForeground(Color.WHITE);
		lblWinterTimeClient.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblWinterTimeClient = new GridBagConstraints();
		gbc_lblWinterTimeClient.anchor = GridBagConstraints.WEST;
		gbc_lblWinterTimeClient.insets = new Insets(5, 0, 5, 10);
		gbc_lblWinterTimeClient.gridx = 3;
		gbc_lblWinterTimeClient.gridy = 14;
		panel.add(lblWinterTimeClient, gbc_lblWinterTimeClient);
		
		JLabel lblLatitude = new JLabel("Latitud");
		lblLatitude.setForeground(Color.LIGHT_GRAY);
		lblLatitude.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblLatitude = new GridBagConstraints();
		gbc_lblLatitude.gridwidth = 2;
		gbc_lblLatitude.anchor = GridBagConstraints.WEST;
		gbc_lblLatitude.insets = new Insets(5, 35, 5, 10);
		gbc_lblLatitude.gridx = 0;
		gbc_lblLatitude.gridy = 15;
		panel.add(lblLatitude, gbc_lblLatitude);
		
		JLabel lblLatitudeClient = new JLabel(Double.toString(client.getLatitude()));
		lblLatitudeClient.setForeground(Color.WHITE);
		lblLatitudeClient.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblLatitudeClient = new GridBagConstraints();
		gbc_lblLatitudeClient.anchor = GridBagConstraints.WEST;
		gbc_lblLatitudeClient.gridwidth = 2;
		gbc_lblLatitudeClient.insets = new Insets(5, 0, 5, 10);
		gbc_lblLatitudeClient.gridx = 2;
		gbc_lblLatitudeClient.gridy = 15;
		panel.add(lblLatitudeClient, gbc_lblLatitudeClient);
		
		JLabel lblLongitude = new JLabel("Longitud");
		lblLongitude.setForeground(Color.LIGHT_GRAY);
		lblLongitude.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblLongitude = new GridBagConstraints();
		gbc_lblLongitude.anchor = GridBagConstraints.WEST;
		gbc_lblLongitude.gridwidth = 2;
		gbc_lblLongitude.insets = new Insets(5, 35, 5, 10);
		gbc_lblLongitude.gridx = 0;
		gbc_lblLongitude.gridy = 16;
		panel.add(lblLongitude, gbc_lblLongitude);
		
		JLabel lblLongitudeClient = new JLabel(Double.toString(client.getLongitude()));
		lblLongitudeClient.setForeground(Color.WHITE);
		lblLongitudeClient.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblLongitudeClient = new GridBagConstraints();
		gbc_lblLongitudeClient.anchor = GridBagConstraints.WEST;
		gbc_lblLongitudeClient.gridwidth = 2;
		gbc_lblLongitudeClient.insets = new Insets(5, 0, 5, 10);
		gbc_lblLongitudeClient.gridx = 2;
		gbc_lblLongitudeClient.gridy = 16;
		panel.add(lblLongitudeClient, gbc_lblLongitudeClient);
		
		JLabel lblSubcategory = new JLabel("Subcategoria");
		lblSubcategory.setForeground(Color.LIGHT_GRAY);
		lblSubcategory.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblSubcategory = new GridBagConstraints();
		gbc_lblSubcategory.gridwidth = 2;
		gbc_lblSubcategory.anchor = GridBagConstraints.WEST;
		gbc_lblSubcategory.insets = new Insets(5, 35, 5, 10);
		gbc_lblSubcategory.gridx = 0;
		gbc_lblSubcategory.gridy = 17;
		panel.add(lblSubcategory, gbc_lblSubcategory);
		
		JLabel lblSubcategoryClient = new JLabel(client.getSubcategory().getDescription());
		lblSubcategoryClient.setForeground(Color.WHITE);
		lblSubcategoryClient.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblSubcategoryClient = new GridBagConstraints();
		gbc_lblSubcategoryClient.anchor = GridBagConstraints.WEST;
		gbc_lblSubcategoryClient.gridwidth = 2;
		gbc_lblSubcategoryClient.insets = new Insets(5, 0, 5, 10);
		gbc_lblSubcategoryClient.gridx = 2;
		gbc_lblSubcategoryClient.gridy = 17;
		panel.add(lblSubcategoryClient, gbc_lblSubcategoryClient);
		
		JLabel lblOffers = new JLabel("OFERTAS ACTIVAS");
		lblOffers.setForeground(new Color(50, 205, 50));
		lblOffers.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblOffers.setBackground(Color.BLACK);
		GridBagConstraints gbc_lblOffers = new GridBagConstraints();
		gbc_lblOffers.gridwidth = 4;
		gbc_lblOffers.anchor = GridBagConstraints.WEST;
		gbc_lblOffers.insets = new Insets(10, 25, 0, 10);
		gbc_lblOffers.gridx = 0;
		gbc_lblOffers.gridy = 18;
		panel.add(lblOffers, gbc_lblOffers);

	}
}