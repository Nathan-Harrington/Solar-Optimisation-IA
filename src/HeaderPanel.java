import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class HeaderPanel extends JPanel{
    public HeaderPanel(){
        //Sizing
        this.setSize(524, 524); //I think this is redundant at the moment which needs to be ameliorated

        //Styling
        Border border = BorderFactory.createLineBorder(new Color(0xff4545), 2);
        this.setBorder(border);
        this.setBackground(new Color(0x212121));
    }
}
