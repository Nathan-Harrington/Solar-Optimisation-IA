import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class TitleLabel extends JLabel { //REMEMBER LABELS TAKE UP AS MUCH SPACE AS POSSIBLE
    public TitleLabel(){
        //Creates Border
        Border border = BorderFactory.createLineBorder(new Color(0xff4545), 2);
        this.setBorder(border);
        //Styling
        this.setForeground(Color.white);
        this.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.TOP);
    }
}
