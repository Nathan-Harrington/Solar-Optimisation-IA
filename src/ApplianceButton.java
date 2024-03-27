import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplianceButton extends JButton{
    public ApplianceButton(String text){
        this.setPreferredSize(new Dimension(200,75));
        this.addActionListener(e -> System.out.println("input appliance received"));
        this.addActionListener(e -> displayAppliancePanel());
        this.setText(text);

        //Styling
        this.setBackground(new Color(0x8FC089));
        this.setForeground(new Color(0xFAF3DD));
        Border border = BorderFactory.createLineBorder(new Color(0x68b0ab), 3);
        this.setBorder(border);

        //
    }
    public void displayAppliancePanel(){  //https://www.youtube.com/watch?v=bvPOZgkhwEk
        JInternalFrame appliancePanel = new JInternalFrame(("Appliance Selector"), true, true, true); //defines panel
        JButton exit = new JButton("Close Window");
        JButton dishwasherButton = new JButton("Dishwasher Settings");
        JButton washingButton = new JButton("Washing Machine Settings");
        JButton airconButton = new JButton("Air Conditioning Settings");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appliancePanel.dispose();
            }
        });
        JPanel t = new JPanel();
        JPanel center = new JPanel(new GridLayout(3,1,0,10));
        center.add(dishwasherButton);
        center.add(washingButton);
        center.add(airconButton);
        t.add(exit);
        appliancePanel.add(center, BorderLayout.CENTER); //Adding buttons
        appliancePanel.add(t, BorderLayout.SOUTH);
        appliancePanel.setVisible(true);
        Scheduler.centerContainerPanel.add(appliancePanel);
        appliancePanel.moveToFront(); // if trying to figure out resizing it is probably because of layout schema maybe a solution here https://stackoverflow.com/questions/19469178/auto-resizing-internal-frame-when-main-frame-maximizes-in-netbeans
        dishwasherButton.addActionListener(e -> new ApplianceSettings("Dishwasher")); //Call tailored settings function
        dishwasherButton.addActionListener(e -> appliancePanel.dispose());
    }
}
