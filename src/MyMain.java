import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class MyMain extends JFrame implements ActionListener {

	MyCanvas1 myCanvas ;
	JPanel panelNorth,panelPreview;
	Button start,preview,set;
    Container container;
	public MyMain(){
		container=this.getContentPane();
		//添加三个按钮事件并设置事件。
		start =new Button("开始");
		start.addActionListener(this);
		preview=new Button("预览");
		preview.addActionListener(this);
		set =new  Button("设置");
		set.addActionListener(this);
		int k=0;
		//为面板赋值并设置。
		panelPreview=new JPanel();
		panelPreview.setLayout(null);
		Icon icon=new ImageIcon("pictrue/pic_"+MyCanvas1.pictrueID*10+".jpg");
		JLabel label=new JLabel(icon);
		label.setBounds(0,0,300,300);
		panelPreview.add(label);
		//按钮处的面板设置
		panelNorth =new JPanel();
		panelNorth.setBackground(Color.red);
		panelNorth.add(start);
		panelNorth.add(preview);
		panelNorth.add(set);
		
		myCanvas=new MyCanvas1();
		container.add(myCanvas,BorderLayout.CENTER);
		container.add(panelNorth,BorderLayout.NORTH);
		this.setTitle("拼图小游戏");
		this.setLocation(300,200);
		this.setSize(308,365);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		
	}
	
	
	public static void main(String [] args)
	{
		new MyMain();
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		Button button=(Button)arg0.getSource();
		//获取按钮事件并进行判断，相应相应的事件。
		if(button==start){
			myCanvas.Start();
		}else if(button==preview){
			if(button.getLabel()=="预览"){
				container.remove(myCanvas);
				container.add(panelPreview);
				panelPreview.updateUI();
				container.repaint();
				button.setLabel("还回");		
			}else{
				container.remove(panelPreview);
				container.add(myCanvas);
				container.repaint();
				button.setLabel("预览");
			}
		}else if(button==set){
			Choice pic=new Choice();
			pic.add("小白兔");
			pic.add("小猫咪");
			//缺德复选框里面的值并加载图片。设置面板位置大小。
			int i=JOptionPane.showConfirmDialog(this,pic,"选择图片",JOptionPane.OK_CANCEL_OPTION);
			if(i==JOptionPane.YES_OPTION);{
				MyCanvas1.pictrueID=pic.getSelectedIndex()+1;
				myCanvas.reLoadPictrue();
				Icon icon=new ImageIcon("pictrue/pic_"+MyCanvas1.pictrueID*10+".jpg");
				JLabel label=new JLabel(icon);
				label.setBounds(0,0,300,300);
				panelPreview.removeAll();
				panelPreview.add(label);
				panelPreview.repaint();
				
			}
		}
		// TODO Auto-generated method stub
		
	}

}
