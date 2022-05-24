package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class FrameGame extends JFrame {
	
	public FrameGame() {
		//���ñ���
		 this.setTitle("Java����˹����");
		//���Ĭ�Ϲر����ԣ����������
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô��ڴ�С
		 this.setSize(1200, 700);
		//�������û��ı䴰�ڴ�С
		 this.setResizable(false);
		//���þ�������
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width - this.getWidth()) / 2;
		int y = (screen.height - this.getHeight()) / 2 - 32;
		this.setLocation(x,y);
		//���Ĭ��Panel
		this.setContentPane(new PanelGame());
	}
	

	
	

}