

import javax.swing.*;
import java.awt.event.*;

public class PointTimer extends JPanel {
    private int second, minute, hour;
    private Timer timer;
    private ActionListener listener;
    public static boolean stateOfTimer = false;
    private JTextField TimerField;

    public PointTimer() {
        TimerField = new JTextField(8);
        super.add(TimerField);
        TimerField.setEditable(false);
        second = 0;minute = 0;hour = 0;
        listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                second++;
                if(second==100){
                    second=0;
                    minute++;
                    if(minute==60){
                        minute=0;
                        hour++;
                    }
                }
                TimerField.setText(String.format("%02d:%02d:%02d", hour, minute, second));
                
            }
        };
        timer = new Timer(1000, listener);
    }

    public void start() {
        timer.start();
        stateOfTimer = true;
    }

    public void stop() {
        timer.stop();
        stateOfTimer = false;
    }
    public void reset(){
        timer.stop();
        second = 0;minute = 0;hour = 0;
        TimerField.setText("00:00:00");
    }
    public String getText(){
        return TimerField.getText();
    }
}
