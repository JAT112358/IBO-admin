package components;

import javax.swing.table.DefaultTableModel;

/**
 * @author Jordan Aranda Tejada
 */
public class TableModel extends DefaultTableModel {

	private static final long	serialVersionUID	= 1L;

	public boolean isCellEditable(final int row, final int column) {
		return false;
	}
}