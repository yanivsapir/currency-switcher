package main.java.il.ac.shenkar.scaleCurrencies.gui;

import javax.swing.table.AbstractTableModel;
/**
 * @author Golan Sabo and Yaniv Sapir
 */
public class CurrencyTableModel extends AbstractTableModel{
	private String[] colName={"Country","Coin","Unit","Currency Name","Rate (To NIS)","change"};
	private String[][] data=null;
	
	/**
	 * initiates the data member of the JTable
	 * to the needed data and inform the JTable
	 *  */
	public CurrencyTableModel(String[][] data) {
		super();
		this.data = data;
		this.fireTableDataChanged();
	}
	/**
	 * Overrides the {@link javax.swing.table.AbstractTableModel#getRowCount()}‬
	 */
	@Override
	public int getRowCount() {
		return data.length;
	}
	/**
	 * Overrides the {@link javax.swing.table.AbstractTableModel#getColumnCount()}
	 */
	@Override
	public int getColumnCount() {
		
		return colName.length;
	}
	/**
	 * Overrides the {@link javax.swing.table.AbstractTableModel#getValueAt(int, int)} ()}
	 */
	@Override
	public Object getValueAt(int row, int col) {
		
		return data[row][col];
	}
	/**
	 * Overrides the {@link javax.swing.table.AbstractTableModel#getColumnName(int)}
	 */
    @Override
    public String getColumnName(int col){
    	return colName[col];
    }
}
