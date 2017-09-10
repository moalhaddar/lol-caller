import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JButton;


public class JButtonEx extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color hoverBackgroundColor;
	private Color pressedBackgroundColor;


	public JButtonEx(String text) {
		super(text);
		super.setContentAreaFilled(false);
		this.setBorder(BorderFactory.createLineBorder(new Color(8, 191, 182)));
		this.setBackground(new Color(24, 35, 43));
		this.setForeground(new Color(163, 199, 199));
		this.setHoverBackgroundColor(new Color(22, 94, 108, 0));
		this.setPressedBackgroundColor(new Color(22, 94, 108, 255));
		this.setRequestFocusEnabled(false);
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				try {
					AudioTes.clickSound("/Sounds/hoverSound.wav");
					
				
					
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException
						| InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		
		this.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					AudioTes.clickSound("/Sounds/buttonClickSound.wav");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
	}

	public JButtonEx outter() { // Spaghetti...can't access "this" inside
								// MouseAdapter
		return this;
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (getModel().isPressed()) {
			g.setColor(pressedBackgroundColor);
		} else if (getModel().isRollover()) {
			g.setColor(hoverBackgroundColor);
		} else {

			g.setColor(getBackground());
		}
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}

	@Override
	public void setContentAreaFilled(boolean b) {
	}

	public Color getHoverBackgroundColor() {
		return hoverBackgroundColor;
	}

	public void setHoverBackgroundColor(Color hoverBackgroundColor) {
		this.hoverBackgroundColor = hoverBackgroundColor;
	}

	public Color getPressedBackgroundColor() {
		return pressedBackgroundColor;
	}

	public void setPressedBackgroundColor(Color pressedBackgroundColor) {
		this.pressedBackgroundColor = pressedBackgroundColor;
	}
}
