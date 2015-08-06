package main.java.il.ac.shenkar.scaleCurrencies.gui;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTextArea;

public class InformativeTextArea extends JTextArea {
	private BufferedReader br=null;

	/**
	 * extends regular TextArea to get external information
	 * and adjust it to the textArea
	 * @param path
	 */
	public InformativeTextArea(String path) {
		super();
		try {
			br=new BufferedReader(new FileReader(new File(path)));
			
			while(br.ready())
			{
				this.append(br.readLine()+"\n");
			}
			this.setFont(new Font("Serif", Font.ITALIC, 16));
		} catch (IOException e) {
			this.append("Error Loading Information From File...");
		}
		if(br!=null)
			try{br.close();}catch(IOException e){}
		this.setEditable(false);
	}
}
