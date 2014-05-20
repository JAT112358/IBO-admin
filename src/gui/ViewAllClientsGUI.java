package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Vector;
import java.util.regex.PatternSyntaxException;
import javax.swing.JTable;
import components.TableClientsPopupMenu;
import components.TableModel;
import controller.Controller;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import dto.CategoryDTO;
import dto.ClientDTO;
import dto.ProvinceDTO;
import dto.SubcategoryDTO;
import dto.TownDTO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

/**
 * @author Jordan Aranda Tejada
 */
public class ViewAllClientsGUI extends JPanel {
	
	private static final long 						serialVersionUID = 6282330084900203375L;
	
	private Controller								controller;
	private MainPanelGUI							mainPanel;								
	private JTextField 								textFieldName;
	private DefaultComboBoxModel<ProvinceDTO> 		modelComboBoxProvince;
	private JComboBox<ProvinceDTO> 					comboBoxProvince;
	private DefaultComboBoxModel<TownDTO> 			modelComboBoxTown;
	private JComboBox<TownDTO> 						comboBoxTown;
	private DefaultComboBoxModel<CategoryDTO> 		modelComboBoxCategory;
	private JComboBox<CategoryDTO> 					comboBoxCategory;
	private DefaultComboBoxModel<SubcategoryDTO>	modelComboBoxSubcategory;
	private JComboBox<SubcategoryDTO> 				comboBoxSubcategory;
	private JLabel 									lblFound;
	
	private TableModel								modelTable;
	private JTable 									table;

	private TownDTO									townDTO;
	private ProvinceDTO								provinceDTO;
	private SubcategoryDTO							subcategoryDTO;
	private CategoryDTO								categoryDTO;

	public ViewAllClientsGUI(Controller controller, MainPanelGUI mainPanel) {
		
		this.controller = controller;
		this.mainPanel = mainPanel;
		
		this.townDTO = null;
		this.provinceDTO = null;
		this.subcategoryDTO = null;
		this.categoryDTO = null;
		
		setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{220, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane scrollPaneFilter = new JScrollPane();
		scrollPaneFilter.setBorder(null);
		GridBagConstraints gbc_scrollPaneFilter = new GridBagConstraints();
		gbc_scrollPaneFilter.gridheight = 2;
		gbc_scrollPaneFilter.insets = new Insets(15, 15, 15, 5);
		gbc_scrollPaneFilter.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneFilter.gridx = 0;
		gbc_scrollPaneFilter.gridy = 0;
		add(scrollPaneFilter, gbc_scrollPaneFilter);
		
		JPanel panelFilter = new JPanel();
		panelFilter.setBorder(null);
		panelFilter.setBackground(new Color(0, 0, 0, 140));
		scrollPaneFilter.setViewportView(panelFilter);
		GridBagLayout gbl_panelFilter = new GridBagLayout();
		gbl_panelFilter.columnWidths = new int[]{0, 0};
		gbl_panelFilter.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panelFilter.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelFilter.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelFilter.setLayout(gbl_panelFilter);
				
		JLabel lblWord = new JLabel("Palabra clave");
		lblWord.setForeground(Color.LIGHT_GRAY);
		lblWord.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblWord = new GridBagConstraints();
		gbc_lblWord.anchor = GridBagConstraints.WEST;
		gbc_lblWord.insets = new Insets(15, 10, 5, 10);
		gbc_lblWord.gridx = 0;
		gbc_lblWord.gridy = 0;
		panelFilter.add(lblWord, gbc_lblWord);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_textFieldName = new GridBagConstraints();
		gbc_textFieldName.insets = new Insets(5, 10, 10, 10);
		gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldName.gridx = 0;
		gbc_textFieldName.gridy = 1;
		panelFilter.add(textFieldName, gbc_textFieldName);
		textFieldName.setColumns(10);
		textFieldName.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(final java.awt.event.KeyEvent e) {
				final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(
				(TableModel) table.getModel());
				table.setRowSorter(sorter);
				final String word = textFieldName.getText().trim();
				if (word.length() == 0) {
					sorter.setRowFilter(null);
				} else {
					try {
						sorter.setRowFilter(RowFilter.regexFilter(word));
					} catch (final PatternSyntaxException pse) {
					}
				}
			}

			public void keyPressed(final java.awt.event.KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					textFieldName.setText("");
				}
			}
		});
		
		modelComboBoxProvince = new DefaultComboBoxModel<ProvinceDTO>(controller.getCombableProvinces());
		comboBoxProvince = new JComboBox<ProvinceDTO>(modelComboBoxProvince);
		comboBoxProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxProvince.getSelectedIndex() > 0) {
					Vector<TownDTO> towns = new Vector<TownDTO>();
					towns.add(new TownDTO(1, "Ciudades"));
					provinceDTO = (ProvinceDTO) modelComboBoxProvince.getSelectedItem();
					for(TownDTO town : provinceDTO.getTowns()) {
						towns.add(town);
					}
					modelComboBoxTown = new DefaultComboBoxModel<TownDTO>(towns);
					comboBoxTown.setModel(modelComboBoxTown);
					comboBoxTown.setEnabled(true);
					loadTable(ViewAllClientsGUI.this.controller.getClients(townDTO, provinceDTO, subcategoryDTO, categoryDTO));
				} else {
					Vector<TownDTO> towns = new Vector<TownDTO>();
					towns.add(new TownDTO(1, "Ciudades"));
					provinceDTO = null;
					townDTO = null;
					modelComboBoxTown = new DefaultComboBoxModel<TownDTO>(towns);
					comboBoxTown.setModel(modelComboBoxTown);
					comboBoxTown.setEnabled(false);
					loadTable(ViewAllClientsGUI.this.controller.getClients(townDTO, provinceDTO, subcategoryDTO, categoryDTO));
				}
			}
		});
		comboBoxProvince.setForeground(Color.BLACK);
		comboBoxProvince.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_comboBoxCountry = new GridBagConstraints();
		gbc_comboBoxCountry.insets = new Insets(15, 10, 5, 10);
		gbc_comboBoxCountry.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCountry.gridx = 0;
		gbc_comboBoxCountry.gridy = 2;
		panelFilter.add(comboBoxProvince, gbc_comboBoxCountry);
		
		Vector<TownDTO> towns = new Vector<TownDTO>();
		towns.add(new TownDTO(1, "Provincias"));
		modelComboBoxTown = new DefaultComboBoxModel<TownDTO>(towns);
		comboBoxTown = new JComboBox<TownDTO>(modelComboBoxTown);
		comboBoxTown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBoxTown.setForeground(Color.BLACK);
		comboBoxTown.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBoxTown.setEnabled(false);
		GridBagConstraints gbc_comboBoxProvince = new GridBagConstraints();
		gbc_comboBoxProvince.insets = new Insets(5, 10, 10, 10);
		gbc_comboBoxProvince.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxProvince.gridx = 0;
		gbc_comboBoxProvince.gridy = 3;
		panelFilter.add(comboBoxTown, gbc_comboBoxProvince);
		
		modelComboBoxCategory = new DefaultComboBoxModel<CategoryDTO>(controller.getCombableCategories());
		comboBoxCategory = new JComboBox<CategoryDTO>(modelComboBoxCategory);
		comboBoxCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxCategory.getSelectedIndex() > 0) {
					Vector<SubcategoryDTO> subcategories = new Vector<SubcategoryDTO>();
					subcategories.add(new SubcategoryDTO(1, "Subcategorias"));
					categoryDTO = (CategoryDTO) modelComboBoxCategory.getSelectedItem();
					for(SubcategoryDTO subcategory : categoryDTO.getSubcategories()) {
						subcategories.add(subcategory);
					}
					modelComboBoxSubcategory = new DefaultComboBoxModel<SubcategoryDTO>(subcategories);
					comboBoxSubcategory.setModel(modelComboBoxSubcategory);
					comboBoxSubcategory.setEnabled(true);
				} else {
					Vector<SubcategoryDTO> subcategories = new Vector<SubcategoryDTO>();
					subcategories.add(new SubcategoryDTO(1, "Subcategorias"));
					categoryDTO = null;
					subcategoryDTO = null;
					modelComboBoxSubcategory = new DefaultComboBoxModel<SubcategoryDTO>(subcategories);
					comboBoxSubcategory.setModel(modelComboBoxSubcategory);
					comboBoxSubcategory.setEnabled(false);
				}
				loadTable(ViewAllClientsGUI.this.controller.getClients(townDTO, provinceDTO, subcategoryDTO, categoryDTO));
			}
		});
		comboBoxCategory.setForeground(Color.BLACK);
		comboBoxCategory.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_comboBoxCategory = new GridBagConstraints();
		gbc_comboBoxCategory.insets = new Insets(15, 10, 5, 10);
		gbc_comboBoxCategory.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCategory.gridx = 0;
		gbc_comboBoxCategory.gridy = 4;
		panelFilter.add(comboBoxCategory, gbc_comboBoxCategory);
		
		Vector<SubcategoryDTO> subcategories = new Vector<SubcategoryDTO>();
		subcategories.add(new SubcategoryDTO(1, "Subcategorias"));
		modelComboBoxSubcategory = new DefaultComboBoxModel<SubcategoryDTO>(subcategories);
		comboBoxSubcategory = new JComboBox<SubcategoryDTO>(modelComboBoxSubcategory);
		comboBoxSubcategory.setForeground(Color.BLACK);
		comboBoxSubcategory.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBoxSubcategory.setEnabled(false);
		GridBagConstraints gbc_comboBoxSubcategory = new GridBagConstraints();
		gbc_comboBoxSubcategory.insets = new Insets(5, 10, 10, 10);
		gbc_comboBoxSubcategory.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSubcategory.gridx = 0;
		gbc_comboBoxSubcategory.gridy = 5;
		panelFilter.add(comboBoxSubcategory, gbc_comboBoxSubcategory);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255, 140));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(15, 15, 0, 15);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		lblFound = new JLabel();
		lblFound.setForeground(Color.LIGHT_GRAY);
		lblFound.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GridBagConstraints gbc_lblFound = new GridBagConstraints();
		gbc_lblFound.anchor = GridBagConstraints.EAST;
		gbc_lblFound.insets = new Insets(5, 15, 15, 15);
		gbc_lblFound.gridx = 1;
		gbc_lblFound.gridy = 1;
		add(lblFound, gbc_lblFound);
		
		modelTable = new TableModel();
		
		loadTable(controller.getAllClients());		
		
		scrollPane.setViewportView(table);
	}

	private void loadTable(Vector<ClientDTO> clients) {
				
		final String[] header = {"ID", "Nombre", "Apellidos", "Empresa", "Email", "Telefono", "Subcategoria", "Localidad"};
		final String[][] content = new String[clients.size()][8];
		
		for(int i = 0; i<clients.size(); i++) {
			ClientDTO client = clients.get(i);
			content[i][0] = Long.toString(client.getId());
			content[i][1] = client.getName();
			content[i][2] = client.getLastname();
			content[i][3] = client.getBusiness();
			content[i][4] = client.getEmail();
			content[i][5] = Integer.toString(client.getTelephone());
			content[i][6] = client.getSubcategory().getDescription();
			content[i][7] = client.getTown().getName();
		}
		
		modelTable.setDataVector(content, header);

		table = new JTable(modelTable);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3) {
					int row = table.rowAtPoint(e.getPoint());
					if(row >= 0) {
						long id = Long.parseLong((String) modelTable.getValueAt(row, 0));
						ClientDTO client = ViewAllClientsGUI.this.controller.getClient(id);
						Point point = e.getPoint();
						new TableClientsPopupMenu(controller, client, mainPanel).show(table, point.x, point.y); 
					}
				}
				if(e.getClickCount() == 2) {
					int row = table.rowAtPoint(e.getPoint());
					if(row >= 0) {
						System.out.println("Selected: " + modelTable.getValueAt(row, 0));
						long id = Long.parseLong((String) modelTable.getValueAt(row, 0));
						ClientDTO client = ViewAllClientsGUI.this.controller.getClient(id);
						if(client != null) {
							mainPanel.setContainer(new ClientGUI(client));
						}
					}
				}
			}
		});
		table.setBackground(new Color(255, 255, 255, 140));
		table.getTableHeader().setReorderingAllowed(false);
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setDragEnabled(false);
		table.setSelectionForeground(Color.WHITE);
		table.setSelectionBackground(SystemColor.textHighlight);
		table.setForeground(Color.BLACK);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		table.setRowHeight(30);		
		table.getTableHeader().setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		lblFound.setText(clients.size() + " encontrados");
	}
}