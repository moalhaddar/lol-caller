import java.awt.MouseInfo;

public class Point {
	int x;
	int y;
	
	public Point(){
		x = 0;
		y = 0;
	}
	
	public void setCords(){
		x = MouseInfo.getPointerInfo().getLocation().x;
		y = MouseInfo.getPointerInfo().getLocation().y;
	}
}
