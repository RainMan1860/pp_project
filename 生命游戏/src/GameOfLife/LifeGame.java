package GameOfLife;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LifeGame extends JFrame{/*界面设计*/
	private final World world;
	public LifeGame(int rows,int columns)    /*创建线程，游戏开始*/
	{
		world=new World(rows, columns);
		new Thread(world).start();
		add(world);
	}
	
	public static void main(String[]args)
	{
		LifeGame frame=new LifeGame(40, 50);
		
		JMenuBar menu=new JMenuBar();
		frame.setJMenuBar(menu);
		
		JMenu options =new JMenu("选择图形");/*从自定义的图案中选择一个进行游戏*/
		menu.add(options);/*菜单主界面添加options*/
		
		JMenuItem arrow=options.add("Arrow");
		arrow.addActionListener(frame.new ArrowActionListener());/*自定义图案，放到options中*/
		JMenuItem square=options.add("Square");
		square.addActionListener(frame.new SquareActionListener());
		JMenuItem wd=options.add("wd");
		wd.addActionListener(frame.new wdActionListener());
		
		JMenu help=new JMenu("Help");
		menu.add(help);
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1007,859);
		frame.setTitle("生命游戏");
		frame.setVisible(true);
		frame.setVisible(true);
		frame.setResizable(false);/*界面设计的参数 从上到下依次为 将窗口设置为中央，
		添加关闭选项，设置窗口大小，标题  设置刷新时不闪烁 设置为不可自由调整大小 */
	}
	class ArrowActionListener implements ActionListener
	{                                                 /*arrow继承侦听器*/
		public void actionPerformed(ActionEvent e)
		{
			world.setArrow();
		}
	}
	class SquareActionListener implements ActionListener /*square继承侦听器*/
	{
		public void actionPerformed(ActionEvent e) 
		{
			world.setSquare();
		}
	}
	class wdActionListener implements ActionListener /*wd继承侦听器*/
	{
		public void actionPerformed(ActionEvent e)
		{
			world.setwd();
		}
	}
}
