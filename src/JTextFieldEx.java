import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class JTextFieldEx extends JTextField {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTextFieldEx(){
		super();
		this.setBorder(BorderFactory.createLineBorder(new Color(53,45,0)));
		this.setBackground(new Color (0,9,18));
		this.setForeground(Color.white);
	}


}
