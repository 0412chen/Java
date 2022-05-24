package elsfk;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.ImageIcon;;

public class PanelGame extends JPanel{
	
	public PanelGame() {
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		Image img = new ImageIcon("graphics/background/bg05.jpg").getImage();
		g.drawImage(img, 32, 32, null);
		int imgW = img.getWidth(null);
		int imgH = img.getHeight(null);
	}
}	