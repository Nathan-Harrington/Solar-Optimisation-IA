import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MetricPanel extends JPanel {
    JLabel batteryLevel = new JLabel("Battery Percentage (%) : ");
    JLabel energyConsumed = new JLabel("Energy Consumed (kwh) : ");
    JLabel energyProduced = new JLabel("Energy Produced (kwh) : ");
    JLabel selfReliantProduction = new JLabel("Self Reliant Energy Production (%) : ");
    JLabel selfReliantConsumption = new JLabel("Self Reliant Energy Consumption (%) : ");

    public MetricPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        batteryLevel.setAlignmentX(Component.CENTER_ALIGNMENT);
        energyConsumed.setAlignmentX(Component.CENTER_ALIGNMENT);
        energyProduced.setAlignmentX(Component.CENTER_ALIGNMENT);
        selfReliantProduction.setAlignmentX(Component.CENTER_ALIGNMENT);
        selfReliantConsumption.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Adds Components
        this.add(batteryLevel);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(energyConsumed);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(energyProduced);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(selfReliantProduction);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(selfReliantConsumption);

    }
}
