    package com.sxt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

@SuppressWarnings("serial")
public class Tertris extends JFrame implements KeyListener{
    //游戏的行数40,列数20
    private static final int game_x = 40;
    private static final int game_y = 20;
    //文本域数组
    JTextArea[][] text;
    //二维数组
    int[][] data;
    //显示游戏状态的标签
    JLabel label1;
    //显示游戏分数的标签
    JLabel label;
    //用于判断游戏是否结束
    boolean isrunning;
    //用于存储所有的方块的数组
    int[] allRect;
    //用于存储当前方块的变量
    int rect;

    public void initWindow() {
        //设置窗口大小
        this.setSize(600,850);
        //设置窗口是否可见
        this.setVisible(true);
        //设置窗口居中
        this.setLocationRelativeTo(null);
        //设置释放窗体
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小不可变
        this.setResizable(false);
        //设置标题
        this.setTitle("块快消");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击关闭按钮是关闭程序
    }

    //初始化游戏界面
    public void initGamePanel() {
        JPanel game_main = new JPanel();
        game_main.setLayout(new GridLayout(game_x,game_y,1,1));
        //初始化面板
        for (int i = 0 ; i < text.length ; i++) {
            for (int j = 0 ; j < text[i].length ;j++) {
                //设置文本域的行列数
                text[i][j] = new JTextArea(game_x,game_y);
                //设置文本域的背景颜色
                text[i][j].setBackground(Color.WHITE);
                //添加键盘监听事件
                text[i][j].addKeyListener(this);
                //初始化游戏边界
                if (j == 0 || j == text[i].length-1 || i == text.length-1) {
                	text[i][j].setBorder((BorderFactory.createMatteBorder(1, 5, 1, 1, Color.ORANGE)));
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

    //初始化游戏的说明面板
    public void initExplainPanel() { 
        //创建游戏的说明面板
    
    	 JPanel explain_right = new JPanel();
    	 JPanel explain_low = new JPanel();
    	 
        explain_right.setLayout(new GridLayout(5,1));
        explain_low.setLayout(new GridLayout(2,1));
        
        explain_right.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.YELLOW, 5), "游戏说明"));
        explain_low.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.YELLOW, 4), "游戏状态"));
    
     
        
        explain_right.add(new JLabel("方块变形:按空格键"));
        explain_right.add(new JLabel("方块左移:按左箭头"));
        explain_right.add(new JLabel("方块右移:按右箭头"));
        explain_right.add(new JLabel("方块下落:按下箭头"));
       
        //设置标签的内容为红色字体
        label1.setForeground(Color.RED);
        //把游戏状态标签,游戏分数标签,添加到说明面板
        explain_low.add(label);
        explain_low.add(label1);
       //将说明面板添加到窗口的右侧
        
        this.add(explain_right,BorderLayout.EAST);
        this.add(explain_low,BorderLayout.NORTH);
    }

    public Tertris() {
        text = new JTextArea[game_x][game_y];
        data = new int[game_x][game_y];
        //初始化表示游戏状态的标签
        label1 = new JLabel("游戏状态: 正在游戏中!");
        //初始化表示游戏分数的标签
        label = new JLabel("游戏得分为: 0");
        initGamePanel();
        initExplainPanel();
        initWindow();
        //初始化开始游戏的标志
        isrunning = true;
        //初始化存放方块的数组
        allRect = new int[]{0x00cc,0x8888,0x000f,0x888f,0xf888,0xf111,0x111f,
        		0x0eee,0x6ff6,0x0008,0x0888,0x000e,0x0088,0x000c,0x08c8,0x00e4,
        		0x04c4,0x004e,0x08c4,0x006c,0x04c8,0x00c6,0x04ee,0x0cec,0x0ee4,
        		0x06e6,0x0e44,0x02e2,0x08e8,0x044e,0x04e4,0x0c44,0x0e20,0x044c,
        		0x08e0,0x02e0,0x088c,0x0e80,0x0c88,0x004a,0x00a4,0x0848,0x0484,
        		0x0ccc,0x00ee,0x026e,0x08ce,0x0ec8,0x0e62};
    }

    @SuppressWarnings("unused")
	public static void main(String[] args) {
        Tertris tertris = new Tertris();
    }

    //开始游戏的方法
    public void game_begin() {
        while (true){
            //判断游戏是否结束
            if (!isrunning) {
                break;
            }

            //进行游戏
            game_run();
        }
        //在标签位置显示"游戏结束"
        label1.setText("游戏状态: 游戏结束!");
    }

    private void game_run() {
		// TODO 自动生成的方法存根
		
	}

	//随机生成下落方块形状的方法
    public void ranRect() {
        Random random = new Random();

        rect = allRect[random.nextInt(49)];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

    
