import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //Instantiates Window
        MyFrame window1 = new MyFrame();
        //Instantiates Header
        MyLabel header1 = new MyLabel();

        //Adds Components to Window
        window1.add(header1);
        window1.setVisible(true);
    }
}