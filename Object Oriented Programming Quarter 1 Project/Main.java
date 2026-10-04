import javax.swing.JFrame; // learned how to use this tool using https://docs.oracle.com/javase/tutorial/uiswing/index.html

import java.awt.Color;
import javax.swing.JPanel;
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tennis Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GamePanel());

        frame.setVisible(true);
    }
}