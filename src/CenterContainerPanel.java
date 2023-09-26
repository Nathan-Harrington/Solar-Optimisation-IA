import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CenterContainerPanel extends JPanel{
    public CenterContainerPanel(){
        //Sizing
        this.setPreferredSize(new Dimension(100,100));
        this.setLayout(new BorderLayout());

        //Styling
        Border border = BorderFactory.createLineBorder(new Color(0x4A7C59), 4);
        this.setBorder(border);
        this.setBackground(new Color(0xC8D5B9));
    }
}
