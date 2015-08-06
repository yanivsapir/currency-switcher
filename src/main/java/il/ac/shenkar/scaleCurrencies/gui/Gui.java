package main.java.il.ac.shenkar.scaleCurrencies.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import main.java.il.ac.shenkar.scaleCurrencies.utills.ClassLogger;
import main.scala.il.ac.shenkar.scaleCurrencies.model.Coin;


/**
 * -
 * @author Golan Sabo and Yaniv Sapir
 * instatiate gui elements
 */
public class Gui{	
	private JFrame frame=null;
	private JTabbedPane tab=null;
	private JPanel currencyPanel=null;
	private JPanel chartPanel=null;
	private BackgroundPanel CurrencyTopPanel=null;
	private BackgroundPanel CurrencyMiddlePanel=null;
	private BackgroundPanel CurrencyBottomPanel=null;
	private JLabel from=null;
	private JLabel to=null;
	private InformativeTextArea helpInfo=null;
	private InformativeTextArea aboutInfo=null;
	private JComboBox<String> coinIHave=null;
	private JComboBox<String> coinIWant=null;
	private JTextField amoutToChange=null;
	private JTextField result=null;
	private JButton cnvrt=null;
	private JButton	swtch=null;
	private JTable table=null;
	private JScrollPane scrollPane=null;
	private JScrollPane helpScrollPane=null;
	private String path="src/main/resources/Flags/";
	private String defualtBackgroundImage="src/main/resources/Flags/Australia.gif";
	private HashMap<String,Coin> coins =null;
	private ClassLogger cl = new ClassLogger("Gui");
	/**
	 * initiate and run the GUI
	 * @param coin saved for later use in converting coins
	 * @param data initiate the JTable
	 * @param countries initiate the JComboBox
	 */
	public Gui(HashMap<String,Coin> coin,String[][] data,String[] countries){
		coins =coin;
		tab=new JTabbedPane();
		currencyPanel=new JPanel();
		chartPanel=new JPanel();
		CurrencyBottomPanel=new BackgroundPanel();
		try{
			CurrencyTopPanel=new BackgroundPanel(defualtBackgroundImage);
			CurrencyMiddlePanel=new BackgroundPanel(defualtBackgroundImage);
			
		}
		catch(IOException e)
		{
			System.out.println("unable to find file\n");
			CurrencyTopPanel=new BackgroundPanel();
			CurrencyMiddlePanel=new BackgroundPanel();
		}
		frame=new JFrame("Currencies-by Golan Sabo & Yaniv Sapir");
		from=new JLabel("From : ");
		to=new JLabel("To :      ");
		from.setFont(new Font("Serif", Font.BOLD, 35));
		to.setFont(new Font("Serif", Font.BOLD, 35));
		coinIHave=new JComboBox<String>(countries);
		coinIWant=new JComboBox<String>(countries);
		amoutToChange=new JTextField(10);
		result=new JTextField(10);
		cnvrt=new JButton("Convert");
		swtch=new JButton("Switch");

		table=new JTable(new CurrencyTableModel(data));
		scrollPane=new JScrollPane(table);
	
		helpInfo=new InformativeTextArea("src/main/resources/Help.txt");
		helpScrollPane=new JScrollPane(helpInfo);
		
		aboutInfo=new InformativeTextArea("src/main/resources/About.txt");
		this.start();
	}

	/**
	 * placing gui elements
	 */
	private void start()
	{
		cl.info("Placing Gui elements...");
		result.setEditable(false);
		frame.setVisible(true);
		frame.setSize(500,330);
		frame.add(tab);
		frame.setResizable(false);
		currencyPanel.setLayout(new GridLayout(3,1));
		currencyPanel.add(CurrencyTopPanel);
		currencyPanel.add(CurrencyMiddlePanel);
		currencyPanel.add(CurrencyBottomPanel);
		CurrencyTopPanel.add(from);
		CurrencyTopPanel.add(coinIWant);
		CurrencyTopPanel.add(amoutToChange);
		CurrencyMiddlePanel.add(to);
		CurrencyMiddlePanel.add(coinIHave);
		CurrencyMiddlePanel.add(result);
		CurrencyBottomPanel.add(cnvrt);
		CurrencyBottomPanel.add(swtch);
		CurrencyBottomPanel.setBackground(Color.yellow);
		ChangeFlag cf=new ChangeFlag();
		CurrencyConvert cc=new CurrencyConvert();
		CurrencySwitch cs=new CurrencySwitch();
		cnvrt.addActionListener(cc);
		swtch.addActionListener(cs);
		coinIHave.addActionListener(cf);
		coinIWant.addActionListener(cf);
		tab.addTab("Currencies", currencyPanel);
		table.getTableHeader().setEnabled(false);
		chartPanel.add(scrollPane);
		tab.addTab("Currency Table", chartPanel);

		tab.addTab("Help",helpScrollPane);
		tab.addTab("About",aboutInfo);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				frame.setVisible(false);
				frame.dispose();
				cl.info("We hope our app was useful, see you next time!");
				System.exit(0);
			}
		});
		cl.info("Gui elements are in place");
	}

	/**
	 * action for the convert button
	 */
	private class CurrencyConvert implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			Coin tmp1 = coins.get(coinIHave.getSelectedItem().toString());
			Coin tmp2 = coins.get(coinIWant.getSelectedItem().toString());
			cl.info("Calculating currency ratio for the selected countries : " + coinIWant.getSelectedItem().toString()
					+ " and " + coinIHave.getSelectedItem().toString() + "..." );
			try{
				Double d=tmp1.calculateCurrencies(tmp2) *Double.parseDouble(amoutToChange.getText());
				BigDecimal bd=new BigDecimal(d);
				result.setText(bd.setScale(3, BigDecimal.ROUND_HALF_UP).toString()); //rounds the result to 2 decimal points
				cl.info(amoutToChange.getText() + " " + tmp2.getCountry() + " " + tmp2.getName() + " are: "
						+ bd.setScale(3, BigDecimal.ROUND_HALF_UP).toString() + " " + tmp1.getCountry() + " " + tmp1.getName());
			}
			catch(Exception err){
				Gui.this.amoutToChange.setText("");
				JOptionPane.showMessageDialog(frame,"Enter Amount!");
			}
		}
	}

	/**
	 * action for the replace coins button
	 */
	private class CurrencySwitch implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String tmp=(String)coinIHave.getSelectedItem();
			coinIHave.setSelectedItem(coinIWant.getSelectedItem());
			coinIWant.setSelectedItem(tmp);	
		}
	}

	/**
	 * comobox listener, changes flag on the background
	 */
	private class ChangeFlag implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==coinIWant)
			{
				try {
					CurrencyTopPanel.setBackgroundImage(path+coinIWant.getSelectedItem()+".gif");
				} catch (IOException e1) {
					System.out.println("File was not found");
				}
			}
			else
			{
				try {
					CurrencyMiddlePanel.setBackgroundImage(path+coinIHave.getSelectedItem()+".gif");
				} catch (IOException e1) {
					System.out.println("File was not found");
				}
			}
			
		}		
	}
	/**
	 * updates the application data
	 * @param coin update the coin array
	 * @param data update table data
	 */
	public void updateData(HashMap<String,Coin> coin, String[][] data) {
		table.setModel(new CurrencyTableModel(data));
		coins =coin;
	}
	
}
