package controller;

import gui.WelcomeGUI;
import gui.Window;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dto.CategoryDTO;
import dto.ClientDTO;
import dto.ProvinceDTO;
import dto.SubcategoryDTO;
import dto.TownDTO;
import remote.RMIServiceLocator;

/**
 * @author Jordan Aranda Tejada
 */
public class Controller {

	private RMIServiceLocator	rsl;

	public Controller(String[] args) throws RemoteException {
		rsl = new RMIServiceLocator();
		rsl.setService(args);
		Window.getInstance().setContainer(new WelcomeGUI(this));
		Window.getInstance().setVisible(true);
	}
	
	public boolean login(String email, String password) {
		try {
			String response = rsl.getService().login(email, password);
			if( ! response.startsWith("ERR")) {
				return true;
			} else {
				JOptionPane.showMessageDialog(Window.getInstance(), response.substring(4), "Error", 
						JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error.png"));
				return false;
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ClientDTO getClient(long id) {
		try {
			return rsl.getService().getClient(id);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	public Vector<ClientDTO> getClients(TownDTO townDTO, ProvinceDTO provinceDTO, SubcategoryDTO subcategoryDTO, CategoryDTO categoryDTO) {
		Vector<ClientDTO> vClients = new Vector<ClientDTO>();
		try {
			ArrayList<ClientDTO> clients = rsl.getService().getClients(townDTO, provinceDTO, subcategoryDTO, categoryDTO);
			for(ClientDTO client : clients) {
				vClients.add(client);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vClients;
	}
	public Vector<ClientDTO> getAllClients() {
		Vector<ClientDTO> vClients = new Vector<ClientDTO>();
		try {
			ArrayList<ClientDTO> clients = rsl.getService().getAllClients();
			for(ClientDTO client : clients) {
				vClients.add(client);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vClients;
	}
	public String addClient(ClientDTO clientDTO, String password) {
		try {
			return rsl.getService().addClient(clientDTO, password);
		} catch (RemoteException e) {
			e.printStackTrace();
			return "ERR";
		}
	}
	public String removeClient(long id) {
		try {
			return rsl.getService().removeClient(id);
		} catch (RemoteException e) {
			e.printStackTrace();
			return "ERR";
		}
	}
	
	public Vector<CategoryDTO> getCombableCategories() {
		Vector<CategoryDTO> vCategory = new Vector<CategoryDTO>();
		vCategory.add(new CategoryDTO(1, "Categorias"));
		try {
			ArrayList<CategoryDTO> categories = rsl.getService().getAllCategories();
			for(CategoryDTO category : categories) {
				vCategory.add(category);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vCategory;
	}
	
	public Vector<SubcategoryDTO> getAllSubcategories() {
		Vector<SubcategoryDTO> vSubcategories = new Vector<SubcategoryDTO>();
		try {
			ArrayList<SubcategoryDTO> subcategories = rsl.getService().getAllSubcategories();
			for(SubcategoryDTO subcategory : subcategories) {
				vSubcategories.add(subcategory);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vSubcategories;
	}
	
	public Vector<ProvinceDTO> getCombableProvinces() {
		Vector<ProvinceDTO> vProvinces = new Vector<ProvinceDTO>();
		vProvinces.add(new ProvinceDTO("Provincias"));
		try {
			ArrayList<ProvinceDTO> provinces = rsl.getService().getAllProvinces();
			for(ProvinceDTO province : provinces) {
				vProvinces.add(province);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vProvinces;
	}
	
	public Vector<TownDTO> getAllTowns() {
		Vector<TownDTO> vTowns = new Vector<TownDTO>();
		try {
			ArrayList<TownDTO> towns = rsl.getService().getAllTowns();
			for(TownDTO town : towns) {
				vTowns.add(town);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vTowns;
	}
	
	
	
	public static void main(String[] args) throws RemoteException {
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new Controller(args);
	}
}