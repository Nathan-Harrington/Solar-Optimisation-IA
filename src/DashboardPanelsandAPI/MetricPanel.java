package DashboardPanelsandAPI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.sql.Connection;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetricPanel extends JPanel {
    public static LocalDateTime now = LocalDateTime.now(); //import Time
    public static DayOfWeek dayofWeek = DayOfWeek.from(now);
    public static int dayNum = dayofWeek.getValue();
    public static String currentday = dayofWeek.name();
    //OTHER METRICS SIMPLY NOT PROVIDED BY DashboardPanels.API PERHAPS PROVIDE ALTERNATE METRICS
    //JLabel testRaw = new JLabel(DashboardPanels.API.GetRawReturn()); Test Returns entire response
    static String[] cloudCoverArray = WeatherAPI.getCloudCoverArray();
    static Object[][] WeatherData = {{"0:00", "22%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"1:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"2:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"3:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"4:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"5:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"6:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"7:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"8:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"9:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"10:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"11:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"12:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"13:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"14:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"15:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"16:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"17:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"18:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"19:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"20:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"21:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"22:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"},
            {"23:00", "75%", "35%", "56%", "23%", "12%", "52%", "98%"}
    };

    static JLabel batteryLevel = new JLabel("Battery Percentage (%) : " + API.GetBatteryLevel() + "%");
    static JLabel energyProduced = new JLabel("Energy Produced (kwh) : " + API.GetEnergyProduced() + "kwh");
    static JTable weatherTable = new JTable(WeatherData, new String[]{"Hour", "Monday (% Cloud Coverage)", "Tuesday (% Cloud Coverage)", "Wednesday (% Cloud Coverage)", "Thursday (% Cloud Coverage)", "Friday (% Cloud Coverage)", "Saturday (% Cloud Coverage)", "Sunday (% Cloud Coverage)"});

    static DbFunctions db = new DbFunctions();
    static Connection conn = db.connect_to_db("solardb", "postgres", "solar");
    public MetricPanel(){
        //Style table
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0;x<8;x++){
            weatherTable.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }
        //this.setBackground(new Color(0x95afc0));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        batteryLevel.setAlignmentX(Component.CENTER_ALIGNMENT);
        energyProduced.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Adds Components
        //this.add(testRaw);
        this.add(Box.createRigidArea(new Dimension(0, 50))); //Spacer Components
        this.add(batteryLevel);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(energyProduced);
        this.add(Box.createRigidArea(new Dimension(0, 50)));

        this.add(new JScrollPane(weatherTable));
        cloudCoverArray = setCloudCoverArray();
        System.out.print("CLoud cover: " +Arrays.toString(cloudCoverArray));
        WeatherData = setWeatherData(WeatherData); //Sets Table
        //TESTING
        System.out.println(dayNum);
        System.out.println(dayofWeek);
        //System.out.println(WeatherData[0][0]); //[x][y], [x] = row & [y] = column
        //System.out.println(WeatherData[0][1]);
        //System.out.println(WeatherData[1][0]);
        //SETS Database Values
        updateWeatherDb(cloudCoverArray);
    }
    //Displays PV METRICS
    public static void displayStatistics(){
        API.QueryAPI();
        batteryLevel.setText("Battery Percentage (%) : " + API.GetBatteryLevel() + "%");
        System.out.println("Battery Percentage (%) : " + API.GetBatteryLevel() + "%");

        energyProduced.setText("Energy Produced (kwh) : " + API.GetEnergyProduced() + "kwh");
        System.out.println("Energy Produced (kwh) : " + API.GetEnergyProduced() + "kwh");
    }
    public String[] setCloudCoverArray() {
        int startIndex = 0;
        int endIndex = 0;
        //Displays Table by Assigning values from Array
        if (dayNum != 1) { //Checks if it is not Monday
            startIndex = ((8 - dayNum)*24); //sets the index of the API from which the cloud coverage
            endIndex = startIndex + 168;
        }
        if(dayNum == 1){ //if Monday
            startIndex = 0;
            endIndex = 168;
        }
        String[] slice = new String[endIndex - startIndex];
        for(int i = 0; i < slice.length; i ++){
            slice[i] = cloudCoverArray[startIndex + i];
            System.out.println(Arrays.toString(cloudCoverArray));
        }
        return slice;
    }
        public Object[][] setWeatherData(Object[][] sampleData) {
            int count = 0;
        for(int i = 1; i < 8; i ++){ //want to assign first element to [0] [1], second element to [0] [2]... [0][8] then [1][1]
            for(int j = 0; j < 24; j++){ //loops through hours of j first before moving to i
                sampleData[j][i] = cloudCoverArray[count];
                count = count + 1; //count needs to increment after accessing value
            }
        }
        return sampleData;
    }


    //Updates Cloud Coverage Value for each Given Day to the Database
    public static void updateWeatherDb(String [] data){
        String[] days = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}; //Not Really Monday, Not Really Tuesday so forth!!!
        List<Integer> averages = new ArrayList<Integer>();
        int count = 0;
        for(int i = 0; i < 7; i++){
            int total = 0; //reset total after each group of 24
            for(int j = 0; j < 24; j++){
                total = Integer.parseInt(data[count]) + total; //sums up
                count += 1;
                //System.out.println(total); check total function
            }
            averages.add(i, (total/24)); //goes after for loop and adds element to position in list
            //System.out.println(Arrays.toString(averages.toArray()));
        }
        for(int i = 0; i < averages.size(); i++){
            db.update_column_int(conn, "weather", days[i], averages.get(i),"average_cloud_coverage" );
        }
    }
}
