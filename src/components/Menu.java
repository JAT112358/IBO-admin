package components;

import gui.ImportClientsGUI;
import gui.MainPanelGUI;
import gui.ViewAllClientsGUI;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import controller.Controller;
import utils.FileChooser;

/**
 * @author Jordan Aranda Tejada
 */
public class Menu extends JMenuBar implements ActionListener {

	private static final long	serialVersionUID	= - 2674054941368737779L;

	private Controller 			controller;
	private MainPanelGUI		panel;			
	
	private final JMenu			application;
	private final JMenu			clients, exportClients;
	private final JMenuItem		newClient, findClient, viewAllClients, importClients, exportClientPDF, exportClientExcel, exportClientXML;
	private final JMenu			users;
	private final JMenuItem		newUser, findUser, viewAllUsers, importUsers, exportUsers;
	private final JMenu			administrators;
	private final JMenuItem		newAdministrator, findAdministrator, viewAllAdministrators;
	private final JMenu			categories;
	private final JMenuItem		newCategory, viewAllCategories;
	private final JMenu			subcategories;
	private final JMenuItem		newSubcategory, viewAllSubcategories;
	private final JMenu			provinces;
	private final JMenuItem		newProvince, viewAllProvinces;
	private final JMenu			towns;
	private final JMenuItem		newTown, viewAllTowns;

	public Menu(Controller controller, MainPanelGUI panel) {
		super();

		this.controller = controller;
		this.panel = panel;
		
		application = new JMenu("WooMe");
		application.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		application.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		application.setMargin(new Insets(5, 5, 5, 5));
		
		add(application);
		
		clients = new JMenu("Clientes");
		clients.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		clients.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clients.setMargin(new Insets(5, 5, 5, 5));
		
		newClient = new JMenuItem("Nuevo");
		newClient.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		newClient.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newClient.setMargin(new Insets(5, 5, 5, 5));
		newClient.setIcon(new ImageIcon("img/menu-icons/user.png"));
		newClient.addActionListener(this);
		clients.add(newClient);
		
		findClient = new JMenuItem("Buscar...");
		findClient.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		findClient.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		findClient.setMargin(new Insets(5, 5, 5, 5));
		findClient.setIcon(new ImageIcon("img/menu-icons/search.png"));
		findClient.addActionListener(this);
		clients.add(findClient);
		
		viewAllClients = new JMenuItem("Ver todos");
		viewAllClients.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		viewAllClients.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		viewAllClients.setMargin(new Insets(5, 5, 5, 5));
		viewAllClients.setIcon(new ImageIcon("img/menu-icons/view.png"));
		viewAllClients.addActionListener(this);
		clients.add(viewAllClients);
		
		importClients = new JMenuItem("Importar...");
		importClients.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		importClients.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		importClients.setMargin(new Insets(5, 5, 5, 5));
		importClients.setIcon(new ImageIcon("img/menu-icons/import.png"));
		importClients.addActionListener(this);
		clients.add(importClients);
		
		exportClients = new JMenu("Exportar...");
		exportClients.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		exportClients.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exportClients.setMargin(new Insets(5, 5, 5, 5));
		exportClients.setIcon(new ImageIcon("img/menu-icons/export.png"));
		
		exportClientExcel = new JMenuItem("Excel");
		exportClientExcel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		exportClientExcel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exportClientExcel.setMargin(new Insets(5, 5, 0, 5));
		exportClientExcel.addActionListener(this);
		exportClients.add(exportClientExcel);
		
		exportClientPDF = new JMenuItem("PDF");
		exportClientPDF.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		exportClientPDF.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exportClientPDF.setMargin(new Insets(5, 5, 0, 5));
		exportClientPDF.addActionListener(this);
		exportClients.add(exportClientPDF);
		
		exportClientXML = new JMenuItem("XML");
		exportClientXML.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		exportClientXML.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exportClientXML.setMargin(new Insets(5, 5, 0, 5));
		exportClientXML.addActionListener(this);
		exportClients.add(exportClientXML);
		
		clients.add(exportClients);
		
		add(clients);
		
		users = new JMenu("Usuarios");
		users.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		users.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		users.setMargin(new Insets(5, 5, 5, 5));
		
		newUser = new JMenuItem("Nuevo");
		newUser.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		newUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newUser.setMargin(new Insets(5, 5, 5, 5));
		newUser.setIcon(new ImageIcon("img/menu-icons/user.png"));
		newUser.addActionListener(this);
		users.add(newUser);
		
		findUser = new JMenuItem("Buscar...");
		findUser.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		findUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		findUser.setMargin(new Insets(5, 5, 5, 5));
		findUser.setIcon(new ImageIcon("img/menu-icons/search.png"));
		findUser.addActionListener(this);
		users.add(findUser);
		
		viewAllUsers = new JMenuItem("Ver todos");
		viewAllUsers.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		viewAllUsers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		viewAllUsers.setMargin(new Insets(5, 5, 5, 5));
		viewAllUsers.setIcon(new ImageIcon("img/menu-icons/view.png"));
		viewAllUsers.addActionListener(this);
		users.add(viewAllUsers);
		
		importUsers = new JMenuItem("Importar...");
		importUsers.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		importUsers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		importUsers.setMargin(new Insets(5, 5, 5, 5));
		importUsers.setIcon(new ImageIcon("img/menu-icons/import.png"));
		importUsers.addActionListener(this);
		users.add(importUsers);
		
		exportUsers = new JMenuItem("Exportar...");
		exportUsers.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		exportUsers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exportUsers.setMargin(new Insets(5, 5, 5, 5));
		exportUsers.setIcon(new ImageIcon("img/menu-icons/export.png"));
		exportUsers.addActionListener(this);
		users.add(exportUsers);
		
		add(users);
		
		administrators = new JMenu("Administradores");
		administrators.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		administrators.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		administrators.setMargin(new Insets(5, 5, 5, 5));
		
		newAdministrator = new JMenuItem("Nuevo");
		newAdministrator.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		newAdministrator.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newAdministrator.setMargin(new Insets(5, 5, 5, 5));
		newAdministrator.setIcon(new ImageIcon("img/menu-icons/user.png"));
		newAdministrator.addActionListener(this);
		administrators.add(newAdministrator);
		
		findAdministrator = new JMenuItem("Buscar...");
		findAdministrator.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		findAdministrator.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		findAdministrator.setMargin(new Insets(5, 5, 5, 5));
		findAdministrator.setIcon(new ImageIcon("img/menu-icons/search.png"));
		findAdministrator.addActionListener(this);
		administrators.add(findAdministrator);
		
		viewAllAdministrators = new JMenuItem("Ver todos");
		viewAllAdministrators.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		viewAllAdministrators.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		viewAllAdministrators.setMargin(new Insets(5, 5, 5, 5));
		viewAllAdministrators.setIcon(new ImageIcon("img/menu-icons/view.png"));
		viewAllAdministrators.addActionListener(this);
		administrators.add(viewAllAdministrators);
		
		add(administrators);
		
		categories = new JMenu("Categorias");
		categories.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		categories.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		categories.setMargin(new Insets(5, 5, 5, 5));
		
		newCategory = new JMenuItem("Nueva");
		newCategory.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		newCategory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newCategory.setMargin(new Insets(5, 5, 5, 5));
		newCategory.setIcon(new ImageIcon("img/menu-icons/add.png"));
		newCategory.addActionListener(this);
		categories.add(newCategory);
		
		viewAllCategories = new JMenuItem("Ver todas");
		viewAllCategories.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		viewAllCategories.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		viewAllCategories.setMargin(new Insets(5, 5, 5, 5));
		viewAllCategories.setIcon(new ImageIcon("img/menu-icons/view.png"));
		viewAllCategories.addActionListener(this);
		categories.add(viewAllCategories);
		
		add(categories);
		
		subcategories = new JMenu("Subcategorias");
		subcategories.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		subcategories.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		subcategories.setMargin(new Insets(5, 5, 5, 5));
		
		newSubcategory = new JMenuItem("Nueva");
		newSubcategory.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		newSubcategory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newSubcategory.setMargin(new Insets(5, 5, 5, 5));
		newSubcategory.setIcon(new ImageIcon("img/menu-icons/add.png"));
		newSubcategory.addActionListener(this);
		subcategories.add(newSubcategory);
		
		viewAllSubcategories = new JMenuItem("Ver todas");
		viewAllSubcategories.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		viewAllSubcategories.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		viewAllSubcategories.setMargin(new Insets(5, 5, 5, 5));
		viewAllSubcategories.setIcon(new ImageIcon("img/menu-icons/view.png"));
		viewAllSubcategories.addActionListener(this);
		subcategories.add(viewAllSubcategories);
		
		add(subcategories);
		
		provinces = new JMenu("Provincias");
		provinces.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		provinces.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		provinces.setMargin(new Insets(5, 5, 5, 5));
		
		newProvince = new JMenuItem("Nueva");
		newProvince.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		newProvince.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newProvince.setMargin(new Insets(5, 5, 5, 5));
		newProvince.setIcon(new ImageIcon("img/menu-icons/add.png"));
		newProvince.addActionListener(this);
		provinces.add(newProvince);
		
		viewAllProvinces = new JMenuItem("Ver todas");
		viewAllProvinces.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		viewAllProvinces.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		viewAllProvinces.setMargin(new Insets(5, 5, 5, 5));
		viewAllProvinces.setIcon(new ImageIcon("img/menu-icons/view.png"));
		viewAllProvinces.addActionListener(this);
		provinces.add(viewAllProvinces);
		
		add(provinces);
		
		towns = new JMenu("Ciudades");
		towns.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		towns.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		towns.setMargin(new Insets(5, 5, 5, 5));
		
		newTown = new JMenuItem("Nueva");
		newTown.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		newTown.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newTown.setMargin(new Insets(5, 5, 5, 5));
		newTown.setIcon(new ImageIcon("img/menu-icons/add.png"));
		newTown.addActionListener(this);
		towns.add(newTown);
		
		viewAllTowns = new JMenuItem("Ver todas");
		viewAllTowns.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		viewAllTowns.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		viewAllTowns.setMargin(new Insets(5, 5, 5, 5));
		viewAllTowns.setIcon(new ImageIcon("img/menu-icons/view.png"));
		viewAllTowns.addActionListener(this);
		towns.add(viewAllTowns);
		
		add(towns);
	}

	public void actionPerformed(final ActionEvent e) {
		if(importClients == e.getSource()) {
			File file = FileChooser.openFile("Fichero Excel", "xlsx");
			if(file != null) {
				ImportClientsGUI  importClients = new ImportClientsGUI(file, controller);
				panel.setContainer(importClients);
				new Thread(importClients).start();
			}
		} else if(viewAllClients == e.getSource()) {
			panel.setContainer(new ViewAllClientsGUI(controller, panel));
		}
	}
}