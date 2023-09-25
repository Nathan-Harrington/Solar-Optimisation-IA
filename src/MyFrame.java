import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(){ //Constructor code needs to be written to be personalised
        //Creates Window
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Solar Optimisation Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Sets Icon
        ImageIcon image = new ImageIcon("images/icon.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(0x212121)); // To Be Contrasted with ff4545 and 1e1c1c
    }
}
