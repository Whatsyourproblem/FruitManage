package com.pdsu.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;

public class FrameModel extends JFrame{
	private JLayeredPane background;
	
	private Icon bgImage;
	int xOld = 0;
	int yOld = 0;
	
	public JLayeredPane getBackgroundPane() {
		return background;
	}
	
	private FrameModel() {}
	
	public FrameModel(String url) {
		this.bgImage = new ImageIcon(url);
		building();
	}
	
	/**
	 *	构建窗体方法
	 */
	private void building() {
		titleIcon();
		base();
		moveFrame();
		buildBackground();
		titleBar();
	}

	private void titleIcon() {
		ImageIcon icon = new ImageIcon("image//booktitle.png");
		this.setIconImage(icon.getImage());
	}

	public void titleBar() {
		// 关闭键
		JButton close = new JButton("X");
		close.setFont(new Font("圆体", Font.BOLD, 15));
		close.setBounds(bgImage.getIconWidth() - 45, -8, 45, 45);
		close.setContentAreaFilled(false);
		close.setBackground(Color.RED);
		close.setBorderPainted(false);
		close.setForeground(Color.GRAY);
		close.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				close.setForeground(Color.GRAY);
				close.setContentAreaFilled(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				close.setForeground(Color.BLACK);
				close.setContentAreaFilled(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		background.add(close, new Integer(101));
		
		// 最小化
		JButton mini = new JButton("—");
		mini.setFont(new Font("圆体", Font.BOLD, 10));
		mini.setBounds(bgImage.getIconWidth() - 90, -8, 45, 45);
		mini.setContentAreaFilled(false);
		mini.setBorderPainted(false);
		mini.setForeground(Color.GRAY);
		mini.setBackground(Color.GRAY);
		//mini.setBorderPainted(false);
		mini.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				mini.setForeground(Color.GRAY);
				mini.setContentAreaFilled(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				mini.setForeground(Color.BLACK);
				mini.setContentAreaFilled(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				FrameModel.this.setExtendedState(JFrame.ICONIFIED);
			}
		});
		background.add(mini, new Integer(101));
	}

	private void buildBackground() {
		JLabel bg = new JLabel(bgImage);
		bg.setBounds(new Rectangle(bgImage.getIconWidth(),bgImage.getIconHeight()));
		background = new JLayeredPane();
		background.add(bg, new Integer(100));
		this.setLayeredPane(background);
	}

	/**
	 * 	设置窗体
	 */
	private void base() {
		this.setLayout(null);
		this.setSize(bgImage.getIconWidth(),bgImage.getIconHeight());
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
	}

	/**
	 * 	窗体可拖动
	 */
	private void moveFrame() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			xOld = e.getX();//记录鼠标按下时的坐标
			yOld = e.getY();
			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xOnScreen = e.getXOnScreen();
				int yOnScreen = e.getYOnScreen();
				int xx = xOnScreen - xOld;
				int yy = yOnScreen - yOld;
				FrameModel.this.setLocation(xx, yy);//设置拖拽后，窗口的位置
			}
		});
	}
	
	public static JButton getButton(String text,int x,int y,int width,int height) {
		JButton jButton = new JButton(text);
		jButton.setFont(new Font("圆体", Font.BOLD, 30));
		jButton.setBackground(new Color(0,191,255));
		jButton.setForeground(Color.WHITE);
		jButton.setBounds(x,y,width,height);
		return jButton;
	}
	
	public static JTextField getTextField(String text,int x,int y,int width,int height) {
		JTextField textField = new JTextField(text);
		textField.setOpaque(false);
		textField.setFont(new Font("圆体", Font.BOLD, 30));
		textField.setBounds(x, y, width, height);
		return textField;
	}
	
	public static JLabel getLabel(String text,int x,int y,int width,int height) {
		JLabel label = new JLabel(text);
		label.setFont(new Font("圆体", Font.BOLD, 30));
		label.setBounds(x, y, width, height);
		return label;
	}
}

