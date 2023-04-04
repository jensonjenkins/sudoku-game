import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {
   private static final long serialVersionUID = 1L; // to prevent serial warning

   // private variables
   GameBoardPanel board = new GameBoardPanel();
   JButton btnNewGame = new JButton("New Game");
   MenuBar menuBar = new MenuBar();

   // Constructor
   public SudokuMain() {
      JPanel panelDisplay = new JPanel(new FlowLayout());
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());
      cp.add(panelDisplay, BorderLayout.SOUTH);
      cp.add(board, BorderLayout.CENTER);
      cp.add(menuBar.getMenuBar(), BorderLayout.NORTH);
      // Add a button to the south to re-start the game via board.newGame()
      // ......
      panelDisplay.add(btnNewGame);
      btnNewGame.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            board.newGame();
         }
      });

      // Initialize the game board to start the game
      board.newGame();

      pack(); // Pack the UI components, instead of using setSize()
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to handle window-closing
      setTitle("Sudoku");
      setVisible(true);

   }

   /** The entry main() entry method */
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new SudokuMain();
         }
      });
   }

}