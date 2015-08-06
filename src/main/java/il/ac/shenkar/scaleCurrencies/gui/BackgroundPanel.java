package main.java.il.ac.shenkar.scaleCurrencies.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author Golan Sabo and Yaniv Sapir
 */
public class BackgroundPanel extends JPanel {

	
	private Image backgroundImage=null;

	public BackgroundPanel() {
	}

	/** 
	 *
	 *	uses {@link BackgroundPanel#setBackgroundImage(String)}
	 *  @param fileName	holds the path of the background
	 *  image you want to set.
	 *  @throws may throw IOExeption if file not found
	 * 
	 * */
	public BackgroundPanel(String fileName) throws IOException {
		this.setBackgroundImage(fileName);
	}
	/**
	 * changes the background of the BackgroundPanel
	 * @param fileName holds the path of the background
	 * @throws IOException if file not found
	 */
	public void setBackgroundImage(String fileName) throws IOException{
		this.backgroundImage = ImageIO.read(new File(fileName));
		this.backgroundImage=this.backgroundImage.getScaledInstance(500, 89, 0);
		this.repaint();
	}


	/**
	 * @see {@link java.awt.Container#paintComponent(Graphics g)}
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, this);
	}
}
