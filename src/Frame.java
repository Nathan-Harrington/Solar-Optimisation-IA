import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame(){ //Constructor code needs to be written to be personalised
        //Creates Window
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Solar Optimisation Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout()); //Sets vertically aligned box layout

        //Sets Icon
        ImageIcon image = new ImageIcon("images/icon.png");
        this.setIconImage(image.getImage());

    }
}
