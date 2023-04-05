
import java.awt.*;
import javax.swing.*;

public class WelcomeScreen extends JFrame{
	Timer timer;
	public static boolean WelcomeScreenState = true;
	public void displayWelcomeScreen() {
		JWindow w = new JWindow(this);
		w.setLayout(new BorderLayout());
		w.setSize(600, 600);
		w.setVisible(true);
		
		JPanel panel = new JPanel();
		w.add(panel, BorderLayout.CENTER);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		//Title Panel
		
		
		JPanel titlePanel = new JPanel();
		JPanel TitleMarginPanel = new JPanel(); 
		TitleMarginPanel.setBorder(BorderFactory.createEmptyBorder(100, 20, 20, 20)); 
		titlePanel.add(TitleMarginPanel);
		TitleMarginPanel.setBackground(Color.black);

		titlePanel.setBounds(0,100,600,150);
		titlePanel.setBackground(Color.black);
		w.add(titlePanel);
		
		//Title Label
		JLabel titleLabel = new JLabel("SUDOKU");
		titleLabel.setForeground(Color.white);
		titleLabel.setBackground(Color.black);
		titleLabel.setFont(new Font("Times New Roman", Font.PLAIN,90));
		TitleMarginPanel.add(titleLabel);
		
		//Start Button Panel
		JPanel buttonPanel = new JPanel();
		w.add(buttonPanel, BorderLayout.SOUTH);

		buttonPanel.setBackground(Color.black);
		//Start Button
		JPanel ButtonMarginPanel = new JPanel(); 
		ButtonMarginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 100, 20)); 
		buttonPanel.add(ButtonMarginPanel);
		ButtonMarginPanel.setBackground(Color.black);

		JButton btnStart = new JButton("Start");
		btnStart.setPreferredSize(new Dimension(200, 70));
		btnStart.setBackground(Color.black);
		btnStart.setForeground(Color.white);
		btnStart.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnStart.setFocusPainted(false);
		
		ButtonMarginPanel.add(btnStart);
		btnStart.addActionListener(e->{
			w.dispose();
			new SudokuMain();
		});
		

	}
	
}
