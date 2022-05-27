package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.*;

import util.Constant;


import model.Block;

/**
 * 自定义类
 *
 */
@SuppressWarnings("serial")
public class Zidingyi extends JDialog implements ActionListener{
	JPanel jp_sudu=new JPanel();
	JPanel jp_rank=new JPanel();
	JPanel jp_she=new JPanel();
	JPanel jp_b=new JPanel();
	JRadioButton jr_rank1=new JRadioButton("初级");
	JRadioButton jr_rank2=new JRadioButton("中级");
	JRadioButton jr_rank3=new JRadioButton("高级");
	JSlider jsl=new JSlider(1,10);//滑动框1-10
	int newspeed;
	Block block;
	GameCanvas gc;
	ButtonGroup bg_rank=new ButtonGroup();	


	
	ImageIcon image=new ImageIcon(Constant.backGround1);
	JLabel label=new JLabel(image);
//	JPanel panel=new JPanel();
	
	public Zidingyi(JFrame j,String s,boolean a,Block block,GameCanvas gc){
		super(j,s,a);
		this.setBounds(0,170, 480, 350);
		this.setVisible(false);
		this.setResizable(false);
		this.setLayout(null);
		this.block=block;
		this.gc=gc;
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
//		panel.add(label);
		
//		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
//		JPanel imagePanel = (JPanel) this.getContentPane();
//		imagePanel.setOpaque(false);
//		panel.setBounds(0, 0, 480, 350);
//		this.add(panel);
		add1();
		add2();
		
		add4();
	}

	/**
	 * 调节速度面板
	 */
	public void add1(){
		jp_sudu.setBounds(0, 40, 500, 80);
			
		
		jsl.setValue(11-Constant.step);
		newspeed=11-jsl.getValue();
		//获取滚动条值
		jsl.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent ce) {
				// TODO Auto-generated method stub
				newspeed=11-jsl.getValue();
//				System.out.println(a);
				
			}
			
		});
//		jsl.setBounds(60, 0, 150, 30);
		jsl.setMajorTickSpacing(9);
		jsl.setMinorTickSpacing(1);
		jsl.setPaintTicks(true);
		jsl.setPaintLabels(true);
		jp_sudu.add(jsl);
	}
	/**
	 * 设置等级面板
	 */
	public void add2(){
		JPanel jp_rank=new JPanel();
		jp_rank.setBounds(90, 140, 300, 30);
		JLabel tj_shape=new JLabel("方块形状");
		tj_shape.setFont(new Font("华文行楷", Font.BOLD, 15));
		
		int i=Block.get_addl();
		
		jr_rank1.addActionListener(this);
		jr_rank1.setActionCommand("初级");

	
		jr_rank2.addActionListener(this);
		jr_rank2.setActionCommand("中级");

		
		jr_rank3.addActionListener(this);
		jr_rank3.setActionCommand("高级");
			
		if(i==7)
			jr_rank1.setSelected(true);
		else if(i==10)
			jr_rank2.setSelected(true);
		else
			jr_rank3.setSelected(true);
		bg_rank.add(jr_rank1);
		bg_rank.add(jr_rank2);
		bg_rank.add(jr_rank3);
		jp_rank.add(tj_shape);
		jp_rank.add(jr_rank1);
		jp_rank.add(jr_rank2);
		jp_rank.add(jr_rank3);
		

		jr_rank1.setBounds(0, 0, 80, 30);
		jr_rank2.setBounds(90, 0, 80, 30);
		jr_rank3.setBounds(180, 0, 80, 30);
		this.add(jp_rank);
		
		}
	

	/**
	 * 确定，取消按钮
	 */
	public void add4(){
		JPanel jp_b=new JPanel();
		jp_b.setBounds(100, 240, 300, 40);
		JButton jb_y=new JButton("确定");
		jb_y.addActionListener(this);
		jp_b.add(jb_y);
		JButton jb_n=new JButton("取消");
		jb_n.addActionListener(this);

		jp_b.add(jb_n);
		JPanel jp_zi=new JPanel();
		  jp_zi.setLayout(null);
		  jp_zi.setBounds(0, 0, this.getWidth(), this.getHeight());
		  jp_zi.add(jp_sudu);
		  jp_zi.add(jp_rank);
		  jp_zi.add(jp_she);
		  jp_zi.add(jp_b);
		  this.add(jp_zi);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JButton) {
			int i=Block.get_addl();
			String buttonCommand = e.getActionCommand();//获取信息
			if (buttonCommand.equals("确定")) {
				String actionCommand = bg_rank.getSelection().getActionCommand();
				if (actionCommand.equals("初级") ) {
					Block.set_addl(7);
					
				} else if (actionCommand.equals("中级")) {
					Block.set_addl(10);

				} else if (actionCommand.equals("高级")) {
					Block.set_addl(13);
				}
				
				else
					{MyFrame.changeBack=false;
					MyFrame.background = new ImageIcon(Constant.backGround1);
				MyFrame.setBackGround();}
				Constant.step=newspeed;
				jsl.setValue(11-Constant.step);
				MyFrame.rank=11-Constant.step;
				MyFrame.jt10.setText("等级："+MyFrame.rank);
				this.dispose();
//				this.setVisible(false);
			} else if (buttonCommand.equals("取消")) {
				// 暂停按钮
				Block.set_addl(i);
				if(i==7)
					jr_rank1.setSelected(true);
				else if(i==10)
					jr_rank2.setSelected(true);
				else
					jr_rank3.setSelected(true);
				this.dispose();
//				this.setVisible(true);
				
				
			}

		}
	}}
