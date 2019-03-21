import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;

public class main {

	private JFrame frmFunMathWaj;
	public JSpinner spinner = new JSpinner();
	private JSpinner spinner_2;
	private JSpinner spinner_1;
	private JSpinner spinner_3;

	public JLabel lblKeychain = new JLabel("Keychain");

	JButton bg = new JButton("");

	public static String[] ans;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frmFunMathWaj.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFunMathWaj = new JFrame();
		frmFunMathWaj.setTitle("Fun Math w/AJ. Paitoon");
		frmFunMathWaj.getContentPane().setBackground(new Color(240, 240, 240));
		frmFunMathWaj.setBackground(Color.DARK_GRAY);
		frmFunMathWaj.setBounds(0, 0, 800, 600);
		frmFunMathWaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFunMathWaj.getContentPane().setLayout(null);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmFunMathWaj.getContentPane().setBackground(new Color(240, 240, 240));
				try {
					java.awt.Toolkit.getDefaultToolkit().beep();
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if ((int) spinner.getValue() == 69)
					System.exit(0);

				int anse = Integer.parseInt(ans[(int) spinner.getValue() - 1]);
				int ansu = ((int) spinner_1.getValue() * 100) + ((int) spinner_2.getValue() * 10)
						+ ((int) spinner_3.getValue());
				System.out.println(anse + " " + ansu);
				if (anse == ansu) {
					frmFunMathWaj.getContentPane().setBackground(Color.GREEN);
					soundDir("yes.wav");
				} else {
					if (ansu == 44 || ansu == 69 || ansu == 30 || ansu == 103) {
						spinner_1.setValue((int) 0);
						spinner_2.setValue((int) 3);
						spinner_3.setValue((int) 0);
						lblKeychain.setText("WOW, YOU FOUND AN EASTER EGG!");
						frmFunMathWaj.getContentPane().setBackground(Color.PINK);
					} else {
						frmFunMathWaj.getContentPane().setBackground(Color.RED);
					}
					int r = new Random().nextInt(6); System.out.println(r); 
					switch(r) {
					case 0:
						soundDir("no.wav");
						break;
					case 1:
						soundDir("no2.wav");
						break;
					case 2:
						soundDir("no3.wav");
						break;
					case 3:
						soundDir("no4.wav");
						break;
					case 4:
						soundDir("no5.wav");
						break;
					case 5:
						soundDir("no6.wav");
						break;
					default:
						soundDir("no.wav");
					}
				}
				java.awt.Toolkit.getDefaultToolkit().beep();
			}
		});
		btnSubmit.setBounds(300, 400, 200, 50);
		frmFunMathWaj.getContentPane().add(btnSubmit);

		spinner.setFont(new Font("Tahoma", Font.BOLD, 20));
		spinner.setBounds(393, 27, 71, 32);
		spinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				frmFunMathWaj.getContentPane().setBackground(new Color(240, 240, 240));
				lblKeychain.setText("Keychain");
			}
		});
		frmFunMathWaj.getContentPane().add(spinner);

		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 200));
		spinner_1.setBounds(165, 139, 150, 250);
		spinner_1.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				frmFunMathWaj.getContentPane().setBackground(new Color(240, 240, 240));
				lblKeychain.setText("Keychain");
			}
		});
		frmFunMathWaj.getContentPane().add(spinner_1);

		spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 200));
		spinner_2.setBounds(325, 140, 150, 250);
		spinner_2.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				frmFunMathWaj.getContentPane().setBackground(new Color(240, 240, 240));
				lblKeychain.setText("Keychain");
			}
		});
		frmFunMathWaj.getContentPane().add(spinner_2);

		spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spinner_3.setFont(new Font("Tahoma", Font.PLAIN, 200));
		spinner_3.setBounds(486, 139, 150, 250);
		spinner_3.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				frmFunMathWaj.getContentPane().setBackground(new Color(240, 240, 240));
				lblKeychain.setText("Keychain");
			}
		});
		frmFunMathWaj.getContentPane().add(spinner_3);

		JLabel label = new JLabel("\u0E02\u0E49\u0E2D\u0E17\u0E35\u0E48");
		label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label.setBounds(325, 0, 116, 81);
		frmFunMathWaj.getContentPane().add(label);

		lblKeychain.setHorizontalAlignment(SwingConstants.CENTER);
		lblKeychain.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblKeychain.setBounds(10, 70, 764, 81);
		frmFunMathWaj.getContentPane().add(lblKeychain);

		JLabel lblDevelopedByPalapon = new JLabel("Developed by PALAPON SOONTORNPAS (with his 10 minutes code)");
		lblDevelopedByPalapon.setForeground(Color.GRAY);
		lblDevelopedByPalapon.setHorizontalAlignment(SwingConstants.CENTER);
		lblDevelopedByPalapon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDevelopedByPalapon.setBounds(165, 529, 471, 32);
		frmFunMathWaj.getContentPane().add(lblDevelopedByPalapon);

		File tempFile = new File("answer.txt");
		if (!tempFile.exists()) {
			try {
				FileWriter writer = new FileWriter(tempFile, true);
				writer.write("#Please Write Down each answers in order and sperate it with new line (ENTER)");
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			List<String> temp_array = new ArrayList<String>();
			FileInputStream fstream_school = new FileInputStream("answer.txt");
			DataInputStream data_input = new DataInputStream(fstream_school);
			@SuppressWarnings("resource")
			BufferedReader buffer = new BufferedReader(new InputStreamReader(data_input));
			String str_line;
			while ((str_line = buffer.readLine()) != null) { // Not EOF
				str_line = str_line.trim(); // Separate Line
				if ((str_line.length() != 0 && (!str_line.startsWith("#")) && isInteger(str_line)))
					temp_array.add(str_line); // Not empty or # -> Add to List<>
			}

			ans = (String[]) temp_array.toArray(new String[temp_array.size()]); // Change List<> to array of answer
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (ans.length == 0) {
			lblKeychain.setText("Please add any ans in answer.txt, then restart program.");
			lblKeychain.setForeground(Color.RED);
			spinner.setValue(444);
			spinner_2.setValue(3);
			spinner.setEnabled(false);
			spinner_1.setEnabled(false);
			spinner_2.setEnabled(false);
			spinner_3.setEnabled(false);
			btnSubmit.setText("You shouldn't seen this");
			btnSubmit.setEnabled(false);
			btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
			frmFunMathWaj.getContentPane().setBackground(Color.MAGENTA);
			java.awt.Toolkit.getDefaultToolkit().beep();
		} else
			spinner.setModel(
					new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(ans.length), new Integer(1)));

	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}
	
	public static void reset() {
		
	}

	public static void soundDir(String a) {
		try {
			URL url = main.class.getClassLoader().getResource(a);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
}
