package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.ImageIcon;;

public class PanelGame extends JPanel{
	
	public PanelGame() {
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		Image img = new ImageIcon("graphics/window/Window.png").getImage();
		g.drawImage(img, 32, 32, null);
		int x = 32;
		int y = 32;
		int w = 256;
		int h = 128;
		int size = 7;
		int imgW = img.getWidth(null);
		int imgH = img.getHeight(null);
		
		//左上
		g.drawImage(img, x, y, x + size, y + size, 0, 0, size, size, null);
		//中上
		g.drawImage(img, 64, 64, 64 + size, 64 + size, 0, 0, size, size, null);
		//右上
	}

}
