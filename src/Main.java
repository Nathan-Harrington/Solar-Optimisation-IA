import javax.swing.*;
import java.awt.*;

public class Main { //COULD MAKE THIS MAIN CLASS ITS OWN DASHBOARD CLASS WHICH IS THEN CALLED IN THE MAIN CLASS WHICH WOULD HAVE TO BE MADE AGAIN
    public static void main(String[] args) {
        //Instantiates Panels
        HeaderPanel headerPanel1 = new HeaderPanel();
        headerPanel1.setSize(524, 524);

        //Instantiates Window
        MyFrame window1 = new MyFrame();

        //Instantiates Header
        HeaderLabel header1 = new HeaderLabel();
        header1.setText("Dashboard");

        //Adds Components to Panel
        headerPanel1.add(header1);

        //Adds Panel to Window
        window1.add(headerPanel1, BorderLayout.PAGE_START); //PAGE START KEY to Allowing formatting at start
        window1.setVisible(true);
    }
}