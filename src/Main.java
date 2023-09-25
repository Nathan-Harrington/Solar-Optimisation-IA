import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //Instantiates Window
        MyFrame window1 = new MyFrame();
        //Instantiates Header
        TitleLabel header1 = new TitleLabel();
        header1.setText("Dashboard");

        //Adds Components to Window
        window1.add(header1);
        window1.setVisible(true);
    }
}