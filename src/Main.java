import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main { //COULD MAKE THIS MAIN CLASS ITS OWN DASHBOARD CLASS WHICH IS THEN CALLED IN THE MAIN CLASS WHICH WOULD HAVE TO BE MADE AGAIN
    public static void main(String[] args) {
        //Instantiates Window
        MyFrame window1 = new MyFrame();

        //Instantiates Panels
        HeaderPanel headerPanel1 = new HeaderPanel();
        CenterContainerPanel centerContainerPanel1 = new CenterContainerPanel();
        ToolBarPanel toolBarPanel1 = new ToolBarPanel();
        DecorativePanel decorativePanel1 = new DecorativePanel();
        DecorativePanel decorativePanel2 = new DecorativePanel();
        DecorativePanel decorativePanel3 = new DecorativePanel();

        //Instantiates Header
        HeaderLabel header1 = new HeaderLabel();
        header1.setText("Dashboard");

        //Instantiates Button
        DashboardButton takeToScheduler = new DashboardButton();

        //Adds Components to Panel
        headerPanel1.add(header1, BorderLayout.CENTER);
        toolBarPanel1.add(takeToScheduler);
        centerContainerPanel1.add(toolBarPanel1, BorderLayout.NORTH);

        //Adds Panel to Window
        window1.add(headerPanel1, BorderLayout.NORTH); //Formatted to top
        window1.add(centerContainerPanel1);
        window1.add(decorativePanel1, BorderLayout.WEST);
        window1.add(decorativePanel2, BorderLayout.EAST);
        window1.add(decorativePanel3, BorderLayout.SOUTH);

        window1.setVisible(true);
    }
}