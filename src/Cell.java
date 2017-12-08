import javax.swing.Icon;
import javax.swing.JButton;


public class Cell extends JButton {
	//构造函数   设置按钮的大小（图片的大小）
	Cell(Icon icon){
		super(icon);
		this.setSize(100,100);
		
	}
	//方向上移动的方法 
	public void move (String direction,int sleep){
		if(direction=="UP"){
			this.setLocation(this.getBounds().x,this.getBounds().y-100);
		}else if(direction=="DOWN")
		{
			this.setLocation(this.getBounds().x,this.getBounds().y+100);
		}else if(direction=="LEFT")
		{
				this.setLocation(this.getBounds().x-100,this.getBounds().y);
		}
		else{
			this.setLocation(this.getBounds().x+100,this.getBounds().y);
		}
	}
}
