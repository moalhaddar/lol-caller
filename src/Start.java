import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;

public class Start {
	final static String version = "LoL Caller 1.1.2";
	static boolean isTheCallerActive = false;
	static int delay = 0; // delay in ms for Thread.Sleep
	static int choosenRadioButton = 5; // the selected radioButton from 0 to 5
	static String [] laneStrings = {"top","jungle","mid","adc","support"};
	static Point topLeftPoint = new Point();
	static Point bottomRightPoint = new Point();
	static Point textTypingPoint = new Point();
	static Point mouseBeforeMovingPoint = new Point();

	// =============JFrame============//
	static JFrame mainContainer = new JFrame(version);
	// =============TextFields============//
	static JTextFieldEx repeatField = new JTextFieldEx();
	static JTextFieldEx t2 = new JTextFieldEx();
	static JTextFieldEx t3 = new JTextFieldEx();
	// =============Buttons============//
	static JButtonEx callButton = new JButtonEx("Call !!");
	static JButtonEx setLocationButton = new JButtonEx("Set Location");
	static JButtonEx setDelayButton = new JButtonEx("Set");
	// =============Labels============//
	static JLabel st = new JLabel("1.Set location of the textbox:");
	static JLabel delayMs = new JLabel("2.Delay(ms)");
	static JLabel numRep = new JLabel("3.Repeat times: ");
	static JLabel InfoLabel = new JLabel("X: " + textTypingPoint.x + "  Y: " + textTypingPoint.y + "  Delay: " + delay);
	// =============RadioButtons============//
	static ButtonGroup radioButtonGroup = new ButtonGroup(); // to group the radio buttons
	static JRadioEx midR = new JRadioEx("mid");
	static JRadioEx topR = new JRadioEx("top");
	static JRadioEx adcR = new JRadioEx("adc");
	static JRadioEx supportR = new JRadioEx("support");
	static JRadioEx jungleR = new JRadioEx("jungle");
	static JRadioEx customR = new JRadioEx("Custom :");
	// =============Created by WindowBuilder Extension============//
	static JLabel label = new JLabel("");
	static JLabel label_1 = new JLabel("");
	static JLabel label_2 = new JLabel("");
	static JLabel label_3 = new JLabel("");
	static JLabel label_4 = new JLabel("");
	static JLabel label_5 = new JLabel("");
	// ****//
	static Region regionToRead = new Region(0, 0, 0, 0); //Using OCR

	public static void main(String[] args) throws AWTException, IOException {
			//The following is needed to be enabled to use sikuli OCR.
			Settings.OcrTextRead = true;
			Settings.OcrTextSearch = true;		
			//The following is to initialize the GUI
			initializeFrame();
			initializeListeners();
			callButton.setEnabled(false); //Disable the call button until user chooses lane
			customR.setEnabled(false); //Disable custom Radio button (Not ready)
			t3.setEnabled(false);
			mainContainer.setVisible(true);
			mainContainer.requestFocus();	
	}

	public static void mouseMove() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		boolean isOk = true;
		int repeatTimes = 0;
		try {
			repeatTimes = Integer.parseInt(repeatField.getText());
		} catch (NumberFormatException e) {
			isOk = false;
			final JDialog dialog = new JDialog();
			dialog.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(dialog, "Enter a Number !", "Error", JOptionPane.ERROR_MESSAGE);
		}
		if (isOk) {
			mouseBeforeMovingPoint.setCords();
			robot.mouseMove(textTypingPoint.x,textTypingPoint.y);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseMove(mouseBeforeMovingPoint.x, mouseBeforeMovingPoint.y);
			sendKeys(robot, laneStrings[choosenRadioButton],repeatTimes);
		}
	}
	
	public static void setDelay() {
		boolean isOk = true;
		try {
			delay = Integer.parseInt(t2.getText());
		} catch (NumberFormatException e) {
			isOk = false;
			final JDialog dialog = new JDialog();
			dialog.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(dialog, "Enter a Number !", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		if (isOk) {
			updateInfoLabel();
		}
	}

	public static void initializeFrame() {
		mainContainer.setIconImage(Toolkit.getDefaultToolkit().getImage(Start.class.getResource("Spammer.png")));
		mainContainer.setResizable(false);
		mainContainer.setSize(350, 235);
		mainContainer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainContainer.setAlwaysOnTop(true);
		mainContainer.setLocationRelativeTo(null);
		mainContainer.getContentPane().setLayout(null);
		mainContainer.setContentPane(new JLabel(new ImageIcon(Start.class.getResource("/Pictures/background.jpg"))));
		// k.setUndecorated(true);

		// Adding TextFields
		repeatField.setBounds(146, 145, 46, 20); //the repeat times
		repeatField.setText("3");
		mainContainer.getContentPane().add(repeatField);

		t2.setBounds(146, 111, 46, 20); //delay
		t2.setText("0");
		mainContainer.getContentPane().add(t2);

		t3.setBounds(155, 46, 116, 20); //custom string
		mainContainer.getContentPane().add(t3);

		// Adding Labels
		st.setBounds(45, 81, 167, 14);
		mainContainer.getContentPane().add(st);
		st.setForeground(new Color(196, 182, 139));

		label_2.setBounds(262, 16, 0, 0);
		mainContainer.getContentPane().add(label_2);
		label_2.setForeground(new Color(196, 182, 139));

		label_5.setBounds(267, 16, 0, 0);
		mainContainer.getContentPane().add(label_5);
		label_5.setForeground(new Color(196, 182, 139));

		label_1.setBounds(272, 16, 0, 0);
		mainContainer.getContentPane().add(label_1);
		label_1.setForeground(new Color(196, 182, 139));

		InfoLabel.setBounds(133, 178, 157, 14);
		mainContainer.getContentPane().add(InfoLabel);
		InfoLabel.setForeground(new Color(196, 182, 139));

		delayMs.setBounds(45, 114, 91, 14);
		mainContainer.getContentPane().add(delayMs);
		delayMs.setForeground(new Color(196, 182, 139));

		numRep.setBounds(45, 148, 91, 14);
		mainContainer.getContentPane().add(numRep);
		numRep.setForeground(new Color(196, 182, 139));

		label_4.setBounds(202, 44, 0, 0);
		mainContainer.getContentPane().add(label_4);
		label_4.setForeground(new Color(196, 182, 139));

		label.setBounds(273, 44, 0, 0);
		mainContainer.getContentPane().add(label);
		label.setForeground(new Color(196, 182, 139));

		label_3.setBounds(278, 44, 0, 0);
		mainContainer.getContentPane().add(label_3);
		label_3.setForeground(new Color(196, 182, 139));

		// Adding radio buttons
		midR.setBounds(141, 16, 60, 23);
		mainContainer.getContentPane().add(midR);

		topR.setBounds(5, 16, 60, 23);
		mainContainer.getContentPane().add(topR);

		adcR.setBounds(200, 16, 60, 23);
		mainContainer.getContentPane().add(adcR);

		supportR.setBounds(260, 16, 82, 23);
		mainContainer.getContentPane().add(supportR);

		jungleR.setBounds(63, 16, 76, 23);
		mainContainer.getContentPane().add(jungleR);

		customR.setBounds(63, 44, 109, 23);
		mainContainer.getContentPane().add(customR);

		// Putting radio buttons in a group
		radioButtonGroup.add(topR); // 0
		radioButtonGroup.add(jungleR); // 1
		radioButtonGroup.add(midR); // 2
		radioButtonGroup.add(adcR); // 3
		radioButtonGroup.add(supportR); // 4
		radioButtonGroup.add(customR); // 5

		// Adding buttons
		callButton.setBounds(202, 144, 70, 23);
		mainContainer.getContentPane().add(callButton);

		setLocationButton.setBounds(215, 77, 113, 23);
		mainContainer.getContentPane().add(setLocationButton);

		setDelayButton.setBounds(202, 110, 70, 23);
		mainContainer.getContentPane().add(setDelayButton);
	}


	public static void initializeListeners() {

		// ==================Button Listeners================//
		callButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isTheCallerActive){
					regionToRead.setRect(topLeftPoint.x,topLeftPoint.y, bottomRightPoint.x, bottomRightPoint.y);
					flipTheSwitch();
					OCR.readScreen();
				}else{			
					flipTheSwitch();
				}
			}
		});
		setLocationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ScreenCapture.full();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setDelayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDelay();
			}
		});

		// ====================Radio Button Listeners======================//
		topR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choosenRadioButton = 0;
				callButton.setEnabled(true);
			}
		});

		jungleR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choosenRadioButton = 1;
				callButton.setEnabled(true);
			}
		});
		midR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choosenRadioButton = 2;
				callButton.setEnabled(true);
			}
		});
		adcR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choosenRadioButton = 3;
				callButton.setEnabled(true);
			}
		});
		supportR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choosenRadioButton = 4;
				callButton.setEnabled(true);
			}
		});
		customR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choosenRadioButton = 5;
				callButton.setEnabled(true);
			}
		});
	}
	
	public static void updateInfoLabel(){
		InfoLabel.setText("X: " + textTypingPoint.x + "  Y: " + textTypingPoint.y + "  Delay: " + delay);
	}
	
	public static void updateCallingButton(){
		if (isTheCallerActive){
			callButton.setBackground(new Color(66, 35, 43));
			callButton.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
			callButton.setText("Stop");
		}else{
			callButton.setBorder(BorderFactory.createLineBorder(new Color(8, 191, 182)));
			callButton.setBackground(new Color(24, 35, 43));
			callButton.setText("Call");
		}
	}
	
	public static void flipTheSwitch(){
		if (isTheCallerActive){
			isTheCallerActive = false;
			updateCallingButton();
		}else{
			isTheCallerActive = true;
			updateCallingButton();
		}
	}
	
	public static void sendKeys(Robot robot, String keys, int repeatTimes) {
		for (int i = 0; i < repeatTimes; i++) {
			for (char c : keys.toCharArray()) {
				int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
				if (KeyEvent.CHAR_UNDEFINED == keyCode) {
					throw new RuntimeException(
							"Key code not found for character '" + c + "'");
				}
				robot.keyPress(keyCode);  
				robot.keyRelease(keyCode);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
		}
	}
}
