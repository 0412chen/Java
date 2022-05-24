package elsfk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class ELSFK extends JFrame implements KeyListener{
	//��Ϸ������30������15
	private static final int game_x = 30;
	private static final int game_y = 15;
	//�ı�������
	JTextArea[][] text;
	//��ά����
	int[][] data;
	public void initWindow() {
		//���ô��ڴ�С
	int width = 600;
	int height = 850;
	this.setSize(width,height);
		//���ô����Ƿ�ɼ�
	this.setVisible(true);
		//���ô��ھ���
	this.setLocationRelativeTo(null);
		//�����ͷŴ���
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô��ڴ�С���ɱ�
	this.setResizable(false);
		//���ñ���
	this.setTitle("�����");
	}
	
	//��ʼ����Ϸ����
	public void initGamepanel() {
		JPanel game_main = new JPanel();
		int hgap = 1;
		int vgap = 1;
		game_main.setLayout(new GridLayout(game_x,game_y,hgap,vgap));
		//��ʼ�����
		for(int i = 0 ; i < text.length ; i++) {
			for(int j = 0 ; j < text[i].length ; j++) {
				//�����ı����������
				text[i][j] = new JTextArea(game_x,game_y);
				//�����ı���ı�����ɫ
				text[i][j].setBackground(Color.WHITE);
				//��Ӽ��̼����¼�
				text[i][j].addKeyListener(this);
				//��ʼ����Ϸ�߽�
				if (j == 0 || j == text[i].length-1 || i == text.length-1) {
					text[i][j].setBackground(Color.blue);
					data[i][j] = 1;
				}
				//�����ı����򲻿ɱ༭
				text[i][j].setEditable(false);
				//�ı�������ӵ��������
				game_main.add(text[i][j]);
			}	
		}
		//��ӵ�������
		this.setLayout(new BorderLayout());
		this.add(game_main,BorderLayout.CENTER);
	}
	
	public ELSFK() {
		text = new JTextArea[game_x][game_y];
		data = new int[game_x][game_y];
		initGamepanel();
		initWindow();
		
	}
	public static void main (String[] args) {
		new ELSFK();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
}
