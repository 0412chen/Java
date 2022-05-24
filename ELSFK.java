package elsfk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class ELSFK extends JFrame implements KeyListener{
	//游戏的行数30，列数15
	private static final int game_x = 30;
	private static final int game_y = 15;
	//文本域数组
	JTextArea[][] text;
	//二维数组
	int[][] data;
	public void initWindow() {
		//设置窗口大小
	int width = 600;
	int height = 850;
	this.setSize(width,height);
		//设置窗口是否可见
	this.setVisible(true);
		//设置窗口居中
	this.setLocationRelativeTo(null);
		//设置释放窗口
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口大小不可变
	this.setResizable(false);
		//设置标题
	this.setTitle("块快消");
	}
	
	//初始化游戏界面
	public void initGamepanel() {
		JPanel game_main = new JPanel();
		int hgap = 1;
		int vgap = 1;
		game_main.setLayout(new GridLayout(game_x,game_y,hgap,vgap));
		//初始化面板
		for(int i = 0 ; i < text.length ; i++) {
			for(int j = 0 ; j < text[i].length ; j++) {
				//设置文本域的行列数
				text[i][j] = new JTextArea(game_x,game_y);
				//设置文本域的背景颜色
				text[i][j].setBackground(Color.WHITE);
				//添加键盘监听事件
				text[i][j].addKeyListener(this);
				//初始化游戏边界
				if (j == 0 || j == text[i].length-1 || i == text.length-1) {
					text[i][j].setBackground(Color.blue);
					data[i][j] = 1;
				}
				//设置文本区域不可编辑
				text[i][j].setEditable(false);
				//文本区域添加到主面板上
				game_main.add(text[i][j]);
			}	
		}
		//添加到窗口中
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
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
}
