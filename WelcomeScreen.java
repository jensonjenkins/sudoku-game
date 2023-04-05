package sudoku;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WelcomeScreen extends JFrame{
	Timer timer;
	
	public void displayWelcomeScreen() {
		JWindow w = new JWindow(this);
		w.setSize(800,600);
		w.setVisible(true);
		
		JPanel panel = new JPanel();
		w.add(panel);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		//Title Panel
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(100,100,600,150);
		titlePanel.setBackground(Color.black);
		w.add(titlePanel);
		
		//Title Label
		JLabel titleLabel = new JLabel("SUDOKU");
		titleLabel.setForeground(Color.white);
		titleLabel.setBackground(Color.black);
		titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 90));
		titlePanel.add(titleLabel);
		
		//Start Button Panel
		JPanel buttonPanel = new JPanel();
		w.add(buttonPanel);
		buttonPanel.setBounds(200,400,200,400);
		buttonPanel.setBackground(Color.black);
		//Start Button
		JButton btnStart = new JButton("Start");
		btnStart.setSize(100,100);
		btnStart.setBackground(Color.black);
		btnStart.setForeground(Color.white);
		btnStart.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnStart.setFocusPainted(false);
		
		buttonPanel.add(btnStart);
		
		btnStart.addActionListener(e->{
			JProgressBar progress = new JProgressBar(0, 100);
			w.add(BorderLayout.PAGE_END, progress);

			w.revalidate();
			timer = new Timer(100, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int x = progress.getValue();
					if (x == 100) {
						w.dispose();
						timer.stop();
						
					} else {
						progress.setValue(x + 4);
					}
				}
			});
			timer.start();
			;
		});
	}
	
}
