import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ScreenCapture {
	static Rectangle area;
	static BufferedImage bufferedImage;
	static JLabel JImage;
	static int cordNumber = 0; //used to set specific coordinates based on clicks;
	public static void full() throws Exception {
		cordNumber = 0;
		JFrame k= new JFrame();
		Robot robot = new Robot();
		// Capture the whole screen
		area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		bufferedImage = robot.createScreenCapture(area);
		k.add(new JLabel(new ImageIcon(bufferedImage)));
		k.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		k.setUndecorated(true);
		k.setAlwaysOnTop(true);
		k.setVisible(true);
		k.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				k.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				//TODO: do the dragging thing
			}
		});
		
		k.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e){
		    	if (cordNumber == 0){
		    		Start.topLeftPoint.setCords();
		    		cordNumber++;
		    	}else if (cordNumber == 1){
		    		Start.bottomRightPoint.setCords();
		    		cordNumber++;
		    	}else {
		    		Start.textTypingPoint.setCords();
		    		Start.updateInfoLabel();
		    		k.dispose();		    		
		    	}

		    }
		});
		    
	}
}
