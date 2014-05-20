package gui;

import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import controller.Controller;
import dto.ClientDTO;
import dto.SubcategoryDTO;
import dto.TownDTO;

public class ImportClientsGUI extends JPanel implements Runnable {

	private static final long 				serialVersionUID = 4378474080212938338L;
	
	public static String 					VALID_HEAD = "CLIENT_NAME CLIENT_LASTNAME EMAIL " +
											"TELEPHONE BUSINESS_NAME SUMMER_TIME WINTER_TIME " +
											"WEB LATITUDE LONGITUDE ADDRESS TOWN SUBCATEGORY";
	
	private File							file;
	private Controller						controller;
	private JTextArea						textArea;
	private JProgressBar 					progressBar;
	
	private HashMap<String, TownDTO> 		towns;
	private HashMap<String, SubcategoryDTO> subcategories;
	
	public ImportClientsGUI(File file, Controller controller) {
		super();
		setOpaque(false);

		this.controller = controller;
		this.towns = new HashMap<String, TownDTO>();
		this.subcategories = new HashMap<String, SubcategoryDTO>();
		
		for(TownDTO town : controller.getAllTowns()) {
			this.towns.put(town.getName().toUpperCase(), town);
		}

		for(SubcategoryDTO subcategory : controller.getAllSubcategories()) {
			this.subcategories.put(subcategory.getDescription().toUpperCase(), subcategory);
		}
		
		this.file = file;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 50, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(15, 15, 10, 15);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setForeground(Color.GREEN);
		textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textArea.setBackground(new Color(0, 0, 0, 140));
		scrollPane.setViewportView(textArea);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.BLACK);
		progressBar.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.fill = GridBagConstraints.BOTH;
		gbc_progressBar.insets = new Insets(0, 15, 15, 15);
		gbc_progressBar.gridx = 0;
		gbc_progressBar.gridy = 1;
		add(progressBar, gbc_progressBar);
	}

	public void run() {
		try {
			FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);		 
            XSSFSheet sheet = workbook.getSheetAt(0);		 
            Iterator<Row> rowIterator = sheet.iterator();
            Iterator<Row> rowIterator2 = sheet.iterator();
            
            if(rowIterator.hasNext()) {
            	Row row = rowIterator.next();
            	Iterator<Cell> cellIterator = row.cellIterator();
            	String aux = "";
            	while (cellIterator.hasNext()) {
            		Cell cell = cellIterator.next();
            		switch (cell.getCellType()) {
            			case Cell.CELL_TYPE_STRING:
            				aux += cell.getStringCellValue().toUpperCase() + " ";
            				break;
                     }
                 }
            	System.out.println("Aux: " + aux);
            	if(aux.trim().equals(VALID_HEAD)) {
            		textArea.append("EXCEL VALIDO\n\n");
            		int size = 0;
            		rowIterator2.next();
            		while (rowIterator2.hasNext()) {
                		rowIterator2.next();
                		size++;
            		}
            		progressBar.setMaximum(size);
            		progressBar.setValue(0);
            		textArea.append("Clientes en fichero: " + size + "\n\n");
            		int num = 0;
            		while (rowIterator.hasNext()) {
                		num++;
                		textArea.append("--- CLIENT NUMBER " + num + " ---\n");
            			Row row2 = rowIterator.next();                       
                    	processLine(row2.cellIterator());
                		progressBar.setValue(num);
                    	Thread.sleep(1000);
            		}
            	} else {
            		textArea.append("El fichero excel seleccionado no es valido. " +
            				"Selecciona un fichero excel con las columnas: \n" + VALID_HEAD);
            	}
            }
            fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void processLine(Iterator<Cell> cellIterator) {
		String name = cellIterator.next().getStringCellValue();
        String lastname = cellIterator.next().getStringCellValue();
        String email = cellIterator.next().getStringCellValue();
        int telephone = (int) cellIterator.next().getNumericCellValue();
        String business = cellIterator.next().getStringCellValue();
        String summerTime = cellIterator.next().getStringCellValue();
        String winterTime = cellIterator.next().getStringCellValue();
        String website = cellIterator.next().getStringCellValue();
        double latitude = cellIterator.next().getNumericCellValue();
        double longitude = cellIterator.next().getNumericCellValue();
        String address = cellIterator.next().getStringCellValue();
        String town = cellIterator.next().getStringCellValue();
        String subcategory = cellIterator.next().getStringCellValue();
        
        TownDTO townDTO = towns.get(town.toUpperCase());
        SubcategoryDTO subcategoryDTO = subcategories.get(subcategory.toUpperCase());
        if(townDTO == null || subcategoryDTO == null) {
        	if(townDTO == null) {
        		textArea.append(" - Error: No existe la ciudad: " + town + "\n");
        	}
        	if(subcategoryDTO == null) {
        		textArea.append(" - Error: No existe la subcategoria: " + subcategory + "\n");
        	}
        } else {
        	ClientDTO client = new ClientDTO(name, lastname, email, business, null, 
    				"", website, address, townDTO, summerTime, winterTime, telephone, 
    				latitude, longitude, subcategoryDTO);
        	String result = controller.addClient(client, "");
    		if(result.startsWith("OK")) {
    			textArea.append("Added: " + client + "\n\n");
    		} else {
    			textArea.append(result.substring(4) + ": " + client + "\n\n");
    		}
        }
	}
}