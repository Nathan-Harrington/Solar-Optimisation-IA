package DashboardPanelsandAPI;

import javax.swing.*;
import java.awt.*;

public class ToolBarPanel extends JPanel {
    public ToolBarPanel(){
        //Sizing
        this.setPreferredSize(new Dimension(100,100));
        this.setLayout(new GridLayout());
        //Styling
        this.setBackground(new Color(0x6AB0AB));
    }

}
