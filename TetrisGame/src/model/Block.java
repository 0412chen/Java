package model;

import java.util.TimerTask;
import java.util.Timer;

import util.Constant;
import view.GameCanvas;
import view.MyFrame;

/**
 * �� 4 * 4 ������Box������һ���飬 ���ƿ���ƶ������䡢���ε�
 */

@SuppressWarnings("unused")
public class Block {

	private GameCanvas gc;
	private Box[][] boxs = new Box[4][4];
//	public static int[][] yinying=new int[4][4];
	public int  y, x,x1,y1;
	public int style;
	public int newH = 0;
	public int newL = 0;
	private static int st = 7;//Ĭ�����ڳ���
	public boolean isAlive = false;//�жϷ����Ƿ���
	public boolean pausing = false;//��ͣΪ��

	/**
	 * ���÷�������
	 */
	public static void set_addl(int a) {
		Block.st = a;
	}

	/**
	 * ��ȡ��������
	 */
	public static int get_addl() {
		return st;
	}

	/**
	 * �չ��캯��
	 */
	public Block() {

	}

	/**
	 * ���캯��������һ���ض��Ŀ�
	 * 
	 * @param style
	 *            �����ʽ����ӦSTYLES��28��ֵ�е�һ��
	 * @param y
	 *            ��ʼλ�ã����Ͻ���canvas�е�������
	 * @param x
	 *            ��ʼλ�ã����Ͻ���canvas�е�������
	 * @param level
	 *            ��Ϸ�ȼ������ƿ�������ٶ�
	 * @param canvas
	 *            ����
	 */
	public Block(int style, int y, int x,  GameCanvas gc) {
		this.style = style;
		this.y = y;
		this.x = x;
		this.gc = gc;
		// this.high=high;
		int key = 0x8000;// ƥ����
		// ���һ�ַ���
		for (int i = 0; i < boxs.length; i++) {
			for (int j = 0; j < boxs[i].length; j++) {
				boolean isColor = ((style & key) != 0);
				boxs[i][j] = new Box(isColor);
				key >>= 1;
			}
		}
		display();// ������ʾ����

	}

	/**
	 * ����ǰ��ӻ����Ķ�Ӧλ���Ƴ���Ҫ�ȵ��´��ػ�����ʱ���ܷ�ӳ����
	 */
	public void earse() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (boxs[i][j].isColorBox()) {
					Box box = gc.getBox(i + y, j + x);
					if (box == null)
						continue;
					box.setColor(false);
				}
			}
		}
	}

	/**
	 * �õ�ǰ������ڻ����Ķ�Ӧλ���ϣ�Ҫ�ȵ��´��ػ�����ʱ���ܿ���
	 */
	public void display() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (boxs[i][j].isColorBox()) {
					Box box = gc.getBox(y + i, x + j);// �������Ϸ�����λ��
					if (box == null)
						continue;
					else
						box.setColor(true);
				}
			}
		}
	}

	/**
	 * ���Ʒ���
	 */
	public void moveLeft() {

		newL = x - 1;
		newH = y;
		if (isMoveAble(newH, newL) && !pausing) {
			earse();
			x--;
			display();
			gc.repaint();
		}
	}

	/**
	 * ���Ʒ���
	 */
	public void moveRight() {

		newL = x + 1;
		newH = y;
		if (isMoveAble(newH, newL) && !pausing) {
			earse();
			x++;
			display();
			gc.repaint();
		}
	}


	/**
	 * ˲�䵽��ײ�
	 */
	public void quickDown() {
		newL = x;
		newH = y + 1;
		while (isMoveAble(newH, newL)) {
			earse();
			y++;
			display();
			gc.repaint();
			newL = x;
			newH = y + 1;
		}
		isAlive = false;
	}


	/**
	 * ��ת���ܵ�ʵ��
	 */
	public void moveUp() {
		earse();
		if (pausing == true)
			return;
		if (isChangeAble()) {
			// ��ȡ��һ��̬
			int key = 0x8000;
			for (int a = 0; a < 4; a++) {
				for (int b = 0; b < 4; b++) {
					boolean isColor = ((this.style & key) != 0);
					boxs[a][b].setColor(isColor);
					key >>= 1;
				}
			}
			display();
			gc.repaint();
		}
	}

	/**
	 * 
	 * �ж��Ƿ�����ƶ� ��ȡ�¸�λ���Ƿ�Ϊ�գ������Ѿ�������ɫ��
	 */
	public boolean isMoveAble(int newH, int newL) {
		earse();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (boxs[i][j].isColorBox()) {
					Box box = gc.getBox(newH + i, newL + j);
					if (box == null || (box.isColorBox())) {
						display();// ��ʾԭ�ȵ�λ��
						return false;
					}
				}
			}
		}
		display();
		return true;
	}

	/**
	 * �ж��Ƿ���Խ��б���
	 */
	private boolean isChangeAble() {
		int key = 0x8000;
		int newStyle = 0;
		earse();
		for (int i = 0; i < st; i++) {
			for (int j = 0; j < 4; j++) {
				if (Constant.STYLES[i][j] == this.style) {
					newStyle = Constant.STYLES[i][(j + 1) % 4];// ȡ����һ��״̬
					break;
				}

				// display();
			}
		}
		// �жϴ�״̬����Ϸ��������ʾ�Ƿ����ϰ�
		for (int a = 0; a < boxs.length; a++) {
			for (int b = 0; b < boxs[a].length; b++) {
				if ((newStyle & key) != 0) {
					Box box = gc.getBox(y + a, x + b);
					if (box == null || box.isColorBox()) {
						// display();
						return false;
					}
				}
				key >>= 1;
			}
		}
		this.style = newStyle;
		return true;
	}

	/**
	 * ��ͣ
	 */
	public void pause() {
		// TODO Auto-generated method stub
		if (MyFrame.playing == true) {
			pausing = true;
			// isMoveAble(newH, newL);
			gc.pau = true;
			gc.repaint();
		}
	}

	/**
	 * ����
	 */
	public void jixu() {
		if (MyFrame.playing == true) {
			pausing = false;
			gc.pau = false;
			gc.repaint();
			;
		}
	}

}