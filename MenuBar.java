package sudoku;

import java.awt.event.*;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;
import com.sun.tools.javac.Main;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Desktop;

public class MenuBar extends JPanel {
	private Desktop desktop = Desktop.getDesktop();
	private JMenuBar menuBar = new JMenuBar();

	public MenuBar(GameBoardPanel board) {
		JMenu file = new JMenu("File");
		JMenu options = new JMenu("Options");
		JMenu help = new JMenu("Help");

		JMenuItem newGame = new JMenuItem("New Game");
		JMenuItem resetGame = new JMenuItem("Reset Game");
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem easy = new JMenuItem("Easy");
		JMenuItem intermediate = new JMenuItem("Intermediate");
		JMenuItem difficult = new JMenuItem("Difficult");

		file.add(newGame);
		file.add(resetGame);
		file.add(exit);
		options.add(easy);
		options.add(intermediate);
		options.add(difficult);

		menuBar.add(file);
		menuBar.add(options);
		menuBar.add(help);

		help.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					desktop.browse(java.net.URI
							.create("https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaGame_Sudoku.html"));
				} catch (IOException ex) {
					Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		
		//File
		//New Game
		newGame.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				board.newGame();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		//Exit game
		exit.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent evt) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		//Reset game
		resetGame.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				board.resetGame();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});

	}

	public Component getMenuBar() {
		JRootPane rootPane = new JRootPane();
		rootPane.setJMenuBar(menuBar);
		return rootPane;
	}

}