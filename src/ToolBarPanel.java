import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarPanel extends JPanel {
    public ToolBarPanel(){
        //Sizing
        this.setPreferredSize(new Dimension(100,100));
        this.setLayout(new GridLayout());
        //Styling
        this.setBackground(new Color(0x6AB0AB));
    }

}
