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
    public void displayAppliancePanel(){
        JInternalFrame appliancePanel = new JInternalFrame(("Appliance Selector"), true, true, true);
        JButton exit = new JButton("Close Window");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appliancePanel.dispose();
            }
        });
        JPanel t = new JPanel();
        appliancePanel.add(t, BorderLayout.NORTH);
        appliancePanel.setVisible(true);
        appliancePanel.setSize(200,200);
        Scheduler.centerContainerPanel.add(appliancePanel);
        appliancePanel.moveToFront();
    }
}
