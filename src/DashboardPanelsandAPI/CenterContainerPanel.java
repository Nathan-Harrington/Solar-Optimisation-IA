package DashboardPanelsandAPI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static java.awt.Color.red;

public class CenterContainerPanel extends JPanel{
    public CenterContainerPanel(){
        //Sizing
        this.setPreferredSize(new Dimension(100,100));
        this.setLayout(new BorderLayout());

        //Styling
        //Border border = BorderFactory.createLineBorder(new Color(0xc7ecee), 4); //0x4A7C59
        //this.setBorder(border);
        this.setBackground(new Color(0xc7ecee));//#C8D5B9
    }
}
