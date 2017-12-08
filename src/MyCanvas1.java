import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyCanvas1 extends JPanel implements MouseListener{
	boolean hasAddActionListener=false;
	Cell cell[];
	//Rectangle cellNull;
	public static int pictrueID=1;
	public MyCanvas1(){
		this.setLayout(null);
		this.setSize(400,400);
     //	cellNull=new Rectangle(200,200,100,100);
		cell =new Cell[9];              //Դ����cell =new Cell[9]
		Icon icon;
		//Ϊ9��ͼƬ����ͼƬ �����ҳ�ʼ�����ꡣ
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++)
			{
				icon=new ImageIcon("pictrue/pic_"+pictrueID+"-"+(i*3+j+1)+".png");
				cell[i*3+j]=new Cell(icon);
				cell[i*3+j].setLocation(j*100,i*100);
				this.add(cell[i*3+j]);
			}
		}
		//this.remove(cell[8]);
	}
	
	//ѡ������ͼƬʱ���ٴμ���ͼƬ��
		public void reLoadPictrue(){
			Icon icon;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					icon=new ImageIcon("pictrue/pic_"+pictrueID+"-"+(i*3+j+1)+".png");
					cell[i*3+j].setIcon(icon);
					
				}
			}		
		}
//�ж��Ƿ�ƴͼ�ɹ��Ĵ��룿
		public boolean isFinish(){
			for(int i=0;i<8;i++){
				int x=cell[i].getBounds().x;
				int y=cell[i].getBounds().y;
				if(y/100*3+x/100!=i)
					 return false;
			}
			return true;
		}
	//�����ʼ��  ˳����ҵĴ��룿
		public void  Start(){
			
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++)
				{
					System.out.println(cell[i*3+j].getBounds().x+"kaishi "+cell[i*3+j].getBounds().y);
				}
			}
			//�������0��9 ���� ������ͼƬ�հ��� ������
			int m,n,x,y;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++)
				{
					m=(int)(Math.random()*9);
					n=(int)(Math.random()*9);
					x=cell[m].getBounds().x;
					y=cell[m].getBounds().y;
					
					cell[m].setLocation(cell[n].getBounds().x,cell[n].getBounds().y);
					cell[n].setLocation(x,y);
				}
			}
			if(!hasAddActionListener)
				for(int i=0;i<8;i++)
					cell[i].addMouseListener(this);
			hasAddActionListener=true;
			return ;
			
	}

	public void mouseClicked(MouseEvent e) {
		//System.out.println("û�п�ʼ1����");// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent e) {
		//System.out.println("����2����");// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		//System.out.println("����3����");// TODO Auto-generated method stub
		
	}
	//��갴�µ��¼�  ƴͼ�ǵ�ͼƬ����������
	public void mousePressed(MouseEvent e) {
		Cell button=(Cell)e.getSource();
		int x1=button.getBounds().x; 
		int y1=button.getBounds().y;
		
		
		System.out.println("x1="+x1);
		System.out.println("y1="+y1);
		
		
		int x2=cell[8].getBounds().x;
		int y2=cell[8].getBounds().y;
		
		
		System.out.println("x2="+x2);
		System.out.println("y2="+y2);
		
		
		if(x1==x2&&y1-y2==100){
			cell[8].setLocation(x1,y1);
			button.move("UP", 100);
		}
		else if(x1==x2&&y1-y2==-100){
			cell[8].setLocation(x1,y1);
			button.move("DOWN", 100);
		}
		else if(x1-x2==100&&y1==y2){
			button.move("LEFT", 100);
			cell[8].setLocation(x1,y1);
		}
		else if(x1-x2==-100&&y1==y2){
			button.move("RIGHT", 100);
			cell[8].setLocation(x1,y1);
		}
		else return;
		//cellNull.setLocation(x1,y1);
		if(this.isFinish()){
			JOptionPane.showMessageDialog(this,"��ϲ�����ƴͼ��Ϸ����");
			for(int i=0;i<8;i++)
				cell[i].removeMouseListener(this);
			hasAddActionListener=false;
		}// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent e) {
		//System.out.println("����4����");// TODO Auto-generated method stub
		
	}

}
