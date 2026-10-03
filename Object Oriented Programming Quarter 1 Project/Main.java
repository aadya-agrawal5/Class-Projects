import javax.swing.JFrame; // learned how to use this tool using https://docs.oracle.com/javase/tutorial/uiswing/index.html

import java.awt.Color;
import javax.swing.JPanel;
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tennis Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);

        javax.swing.JPanel panel = new JPanel();
        panel.setBackground(Color.green);

        frame.add(panel);

        frame.setVisible(true);
    }
}