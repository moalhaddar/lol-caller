import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
		
public class JRadioEx extends JRadioButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static ImageIcon radioDisabled = new ImageIcon(Start.class.getResource("/Pictures/RadioDisabled.png"));
	static ImageIcon radioEnabled = new ImageIcon(Start.class.getResource("/Pictures/RadioEnabled.png"));
	static ImageIcon radioPressed = new ImageIcon(Start.class.getResource("/Pictures/RadioPressed.png"));
	static Color foregroundC = new Color (196,182,139);
	static Color backgroundC = new Color (196,182,139);
	public JRadioEx(String a){
		super(a);
		this.setRequestFocusEnabled(false);
		this.setForeground(foregroundC);
		this.setOpaque(false);
		this.setIcon(radioDisabled);
		this.setSelectedIcon(radioEnabled);
		this.setPressedIcon(radioPressed);
		putListeners();
	}
	public void putListeners(){
		this.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	outter().setForeground(foregroundC);
		    	
		    }
		    public void mouseExited(MouseEvent evt) {
		    	outter().setForeground(backgroundC);
		    	
		    }
		    

		});
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					AudioTes.clickSound("Sounds/clickSound.wav");
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException
						| InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
	}
	public JRadioEx outter(){ // Spaghetti...can't access "this" inside MouseAdapter
		return this;
	}
}
