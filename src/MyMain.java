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
		//���������ť�¼��������¼���
		start =new Button("��ʼ");
		start.addActionListener(this);
		preview=new Button("Ԥ��");
		preview.addActionListener(this);
		set =new  Button("����");
		set.addActionListener(this);
		int k=0;
		//Ϊ��帳ֵ�����á�
		panelPreview=new JPanel();
		panelPreview.setLayout(null);
		Icon icon=new ImageIcon("pictrue/pic_"+MyCanvas1.pictrueID*10+".jpg");
		JLabel label=new JLabel(icon);
		label.setBounds(0,0,300,300);
		panelPreview.add(label);
		//��ť�����������
		panelNorth =new JPanel();
		panelNorth.setBackground(Color.red);
		panelNorth.add(start);
		panelNorth.add(preview);
		panelNorth.add(set);
		
		myCanvas=new MyCanvas1();
		container.add(myCanvas,BorderLayout.CENTER);
		container.add(panelNorth,BorderLayout.NORTH);
		this.setTitle("ƴͼС��Ϸ");
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
		//��ȡ��ť�¼��������жϣ���Ӧ��Ӧ���¼���
		if(button==start){
			myCanvas.Start();
		}else if(button==preview){
			if(button.getLabel()=="Ԥ��"){
				container.remove(myCanvas);
				container.add(panelPreview);
				panelPreview.updateUI();
				container.repaint();
				button.setLabel("����");		
			}else{
				container.remove(panelPreview);
				container.add(myCanvas);
				container.repaint();
				button.setLabel("Ԥ��");
			}
		}else if(button==set){
			Choice pic=new Choice();
			pic.add("С����");
			pic.add("Сè��");
			//ȱ�¸�ѡ�������ֵ������ͼƬ���������λ�ô�С��
			int i=JOptionPane.showConfirmDialog(this,pic,"ѡ��ͼƬ",JOptionPane.OK_CANCEL_OPTION);
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
