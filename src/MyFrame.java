import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(){ //Constructor code needs to be written to be personalised
        //Creates Window
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Solar Optimisation Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout()); //Sets vertically aligned box layout

        //Sets Icon
        ImageIcon image = new ImageIcon("images/icon.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(0x212121)); // Colour Palette faf3dd, c8d5b9, 8fc0A9, 68B0AB, 4a7c59
    }
}
