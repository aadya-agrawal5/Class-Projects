import javax.swing.JFrame; // learned how to use this tool using https://docs.oracle.com/javase/tutorial/uiswing/index.html
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tennis Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GamePanel());
        frame.pack(); //makes sure all contents are displayed inside window
        frame.setVisible(true);
    }
}