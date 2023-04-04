import java.awt.*;
import javax.swing.*;

public class MenuBar extends JPanel {
    JMenuBar menuBar = new JMenuBar();

    public MenuBar() {
        JMenu file = new JMenu("File");
        JMenu options = new JMenu("Options");
        JMenu help = new JMenu("Help");

        JMenuItem i1 = new JMenuItem("New Game");
        JMenuItem i2 = new JMenuItem("Reset Game");
        JMenuItem i3 = new JMenuItem("Exit");
        file.add(i1);
        file.add(i2);
        file.add(i3);
        menuBar.add(file);
        menuBar.add(options);
        menuBar.add(help);

    }

    public Component getMenuBar() {
        JRootPane rootPane = new JRootPane();
        rootPane.setJMenuBar(menuBar);
        return rootPane;
    }
}