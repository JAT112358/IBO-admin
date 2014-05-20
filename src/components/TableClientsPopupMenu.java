package components;

import gui.ClientGUI;
import gui.MainPanelGUI;
import gui.Window;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import controller.Controller;
import dto.ClientDTO;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableClientsPopupMenu extends JPopupMenu implements ActionListener {

	private static final long 	serialVersionUID = 7687984965040147152L;
	
	private Controller			controller;
	private ClientDTO			client;
	private MainPanelGUI		mainPanel;
	
	private JMenuItem 			menuItemView;
	private JMenuItem 			menuItemEdit;
	private JMenuItem 			menuItemDelete;

	public TableClientsPopupMenu(Controller controller, ClientDTO client, MainPanelGUI mainPanel) {	
		super();
		setVisible(true);
		
		this.controller = controller;
		this.client = client;
		this.mainPanel = mainPanel;
		
		menuItemView = new JMenuItem("Visualizar");
		menuItemView.setMargin(new Insets(5, 5, 5, 5));
		menuItemView.setForeground(Color.BLACK);
		menuItemView.setIcon(new ImageIcon("img/menu-icons/view.png"));
		menuItemView.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		menuItemView.addActionListener(this);
		add(menuItemView);
		
		menuItemEdit = new JMenuItem("Editar");
		menuItemEdit.setMargin(new Insets(5, 5, 5, 5));
		menuItemEdit.setForeground(Color.BLACK);
		menuItemEdit.setIcon(new ImageIcon("img/menu-icons/edit.png"));
		menuItemEdit.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		menuItemEdit.addActionListener(this);
		add(menuItemEdit);
		
		menuItemDelete = new JMenuItem("Eliminar");
		menuItemDelete.setMargin(new Insets(5, 5, 5, 5));
		menuItemDelete.setForeground(Color.BLACK);
		menuItemDelete.setIcon(new ImageIcon("img/menu-icons/trash.png"));
		menuItemDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		menuItemDelete.addActionListener(this);
		add(menuItemDelete);
	}

	public void actionPerformed(ActionEvent e) {
		if(menuItemView == e.getSource()) {
			if(client != null) {
				mainPanel.setContainer(new ClientGUI(client));
			}
		} else if(menuItemEdit == e.getSource()) {
			
		} else if(menuItemDelete == e.getSource()) {
			int option = JOptionPane.showOptionDialog(
					   Window.getInstance(), "Est\u00e1s seguro de querer eliminar el cliente: " 
							   				+ client.getName() + " " + client.getLastname() + "?", 
					   "Eliminar cliente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					   null, new Object[] {"No", "Si"}, "Si");
			if(option == 1) {
				int option2 = JOptionPane.showOptionDialog(
						   Window.getInstance(), "Si eliminas el cliente se borrar\u00e1n todas sus ofertas y sus datos\n" +
						   		"y no se podr\u00e1n recuperar, est\u00e1s seguro?", 
						   "Eliminar cliente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
						   null, new Object[] {"No", "Si"}, "Si");
				if(option2 == 1) {
					String response = controller.removeClient(client.getId());
					if(response.startsWith("OK")) {
						JOptionPane.showMessageDialog(Window.getInstance(), "El cliente ha sido eliminado correctamente.", 
								"Cliente eliminado", JOptionPane.PLAIN_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(Window.getInstance(), "El cliente no ha podido eliminarse correctemente.", 
								"Cliente no eliminado", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		}
	}
}