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
    
	
	public SudokuMain() {
		JPanel panelDisplay = new JPanel(new FlowLayout());
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(panelDisplay, BorderLayout.SOUTH);
		cp.add(board, BorderLayout.CENTER);
		cp.add(menuBar.getMenuBar(), BorderLayout.NORTH);
		
		panelDisplay.add(progressBar);
		panelDisplay.add(pointTimer);
		

		int ranGenNumber = random.nextInt(1,65);
		board.newGame(ranGenNumber);

		pack(); // Pack the UI components, instead of using setSize()
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to handle window-closing
		setTitle("Sudoku");
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