
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {
	private static final long serialVersionUID = 1L; // to prevent serial warning

	// private variables
	GameBoardPanel board = new GameBoardPanel();
	private MenuBar menuBar = new MenuBar(board);
	public static ProgressBar progressBar = new ProgressBar();
	public static PointTimer pointTimer = new PointTimer();
	Random random = new Random();
	Timer timer;
	public static boolean WelcomeScreenState = true;

	public SudokuMain() {

		// Creating welcome screen
		JWindow w = new JWindow(this);
		w.setLayout(new BorderLayout());
		w.setSize(600, 600);
		w.setVisible(true);

		JPanel panel = new JPanel();
		w.add(panel, BorderLayout.CENTER);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		// Title Panel

		JPanel titlePanel = new JPanel();
		JPanel titleMarginPanel = new JPanel();
		titleMarginPanel.setBorder(BorderFactory.createEmptyBorder(100, 20, 20, 20));
		titlePanel.add(titleMarginPanel);
		titleMarginPanel.setBackground(Color.black);

		titlePanel.setBounds(0, 100, 600, 150);
		titlePanel.setBackground(Color.black);
		w.add(titlePanel);

		// Title Label
		JLabel titleLabel = new JLabel("SUDOKU");
		titleLabel.setForeground(Color.white);
		titleLabel.setBackground(Color.black);
		titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 90));
		titleMarginPanel.add(titleLabel);

		// Start Button Panel
		JPanel buttonPanel = new JPanel(new FlowLayout());
		w.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setBackground(Color.black);
		JPanel ButtonMarginPanel = new JPanel();
		ButtonMarginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 100, 20));
		buttonPanel.add(ButtonMarginPanel);
		ButtonMarginPanel.setBackground(Color.black);

		// Username TextField
		JTextField username = new JTextField("Username");
		username.setEditable(true);
		buttonPanel.add(username);
		username.setBackground(Color.WHITE);
		// Start Button
		JButton btnStart = new JButton("Start");
		btnStart.setPreferredSize(new Dimension(200, 70));
		btnStart.setBackground(Color.black);
		btnStart.setForeground(Color.white);
		btnStart.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnStart.setFocusPainted(false);
		buttonPanel.add(btnStart);

		// Difficulty Combo Box
		String[] diff = { "Easy", "Intermediate", "Difficult" };
		JComboBox<String> difficulty = new JComboBox<String>(diff);
		final String[] selectedDifficulty = {""};
		difficulty.addActionListener(e -> {
			selectedDifficulty[0] = (String) difficulty.getSelectedItem();
			System.out.println("Selected difficulty: " + selectedDifficulty[0]);
		});
		buttonPanel.add(difficulty);
		
	
		btnStart.addActionListener(e -> {
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
						if(selectedDifficulty[0].equals("Difficult")){
							int difficultNum = random.nextInt(36, 65);
							board.newGame(difficultNum);
						}else if(selectedDifficulty[0].equals("Intermediate")){
							int intermediateNum = random.nextInt(11, 36);
							board.newGame(intermediateNum);
						}else{
							int easyNum = random.nextInt(1, 11);
							board.newGame(easyNum);
						}
						
					} else {
						progress.setValue(x + 8);
					}
				}
			});
			timer.start();
			;
		});
		// Creating Container for Sudoku
		JPanel panelDisplay = new JPanel(new FlowLayout());
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(panelDisplay, BorderLayout.SOUTH);
		cp.add(board, BorderLayout.CENTER);
		cp.add(menuBar.getMenuBar(), BorderLayout.NORTH);

		panelDisplay.add(progressBar);
		panelDisplay.add(pointTimer);

		pack(); // Pack the UI components, instead of using setSize()
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to handle window-closing
		setTitle("Sudoku");
		setSize(600, 600);

		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SudokuMain();

			}
		});
	}

}