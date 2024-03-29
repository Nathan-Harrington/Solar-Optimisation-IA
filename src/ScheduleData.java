import java.sql.Connection;
import java.time.LocalDate;
import java.util.Arrays;

public class ScheduleData{
    public static LocalDate now = LocalDate.now(); //import Time
    public static int monthIndex = now.getMonthValue(); //import Time
    public static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public static String month = months[monthIndex - 1];
    DbFunctions db = new DbFunctions();
    Connection conn = db.connect_to_db("solardb", "postgres", "solar");
    static Object[][] data = {{"0:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"1:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"2:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"3:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"4:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"5:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"6:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"7:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"8:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"9:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"10:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"11:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"12:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"13:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"14:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"15:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"16:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"17:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"18:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"19:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"20:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"21:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"22:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
            {"23:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"}
    };
    public void retrieveVariables(){
        //Retrieve Values from Database
        int DishwasherCycles = db.return_appliances_num(conn, "appliance_cycles_num","Dishwasher");
        int AirconCycles = db.return_appliances_num(conn, "appliance_cycles_num", "Airconditioning");
        int WashingMachineCycles = db.return_appliances_num(conn, "appliance_cycles_num", "Washing Machine");
        Boolean[] DishwasherDays = {db.return_bool_day(conn, "appliances", "monday", "Dishwasher"), db.return_bool_day(conn, "appliances", "tuesday", "Dishwasher"), db.return_bool_day(conn, "appliances", "wednesday", "Dishwasher"), db.return_bool_day(conn, "appliances", "thursday", "Dishwasher"), db.return_bool_day(conn, "appliances", "friday", "Dishwasher"), db.return_bool_day(conn, "appliances", "saturday", "Dishwasher"), db.return_bool_day(conn, "appliances", "sunday", "Dishwasher")};
        Boolean[] AirconDays = {db.return_bool_day(conn, "appliances", "monday", "Airconditioning"), db.return_bool_day(conn, "appliances", "tuesday", "Airconditioning"), db.return_bool_day(conn, "appliances", "wednesday", "Airconditioning"), db.return_bool_day(conn, "appliances", "thursday", "Airconditioning"), db.return_bool_day(conn, "appliances", "friday", "Airconditioning"), db.return_bool_day(conn, "appliances", "saturday", "Airconditioning"), db.return_bool_day(conn, "appliances", "sunday", "Airconditioning")};
        Boolean[] WashingMachineDays = {db.return_bool_day(conn, "appliances", "monday", "Washing Machine"), db.return_bool_day(conn, "appliances", "tuesday", "Washing Machine"), db.return_bool_day(conn, "appliances", "wednesday", "Washing Machine"), db.return_bool_day(conn, "appliances", "thursday", "Washing Machine"), db.return_bool_day(conn, "appliances", "friday", "Washing Machine"), db.return_bool_day(conn, "appliances", "saturday", "Washing Machine"), db.return_bool_day(conn, "appliances", "sunday", "Washing Machine")};
        int DishwasherMaxQuota = db.return_appliances_num(conn, "max_daily","Dishwasher");
        int AirconMaxQuota = db.return_appliances_num(conn, "max_daily", "Airconditioning");
        int WashingMachineMaxQuota = db.return_appliances_num(conn, "max_daily", "Washing Machine");
        int DishwasherConsumption = db.return_appliances_num(conn, "device_consumption","Dishwasher");
        int AirconConsumption = db.return_appliances_num(conn, "device_consumption", "Airconditioning");
        int WashingMachineConsumption = db.return_appliances_num(conn, "device_consumption", "Washing Machine");
        scheduleAircon(AirconCycles, AirconDays, AirconMaxQuota, AirconConsumption);
    }
    //FIRST INSTANCE OF SCHEDULING
    public void scheduleAircon(int Cycles, Boolean[] days, int MaxperDay, int Consumption){ //MYSTERY ERROR BUT WORKS?
        //RETRIEVE WEATHER AND DEFINE PRODUCTION
        int[] weather = db.return_weather(conn);
        float[][] productionArray = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
        //CHECK FIRST IF THE CLIENT HAS SET THE DAY TO HAVE APPLIANCES RUN ON
        for(int i = 0; i < 7; i++){
            if(days[i]){ //if true essentially as days is an array of booleans
                //CHECK IF IT IS SUMMER
                if(month == "December" || month == "January" || month == "February"){
                    //Check Cloudiness
                    if(weather[i] < 42){
                        //ASSIGN PRODUCTION TO DAY
                            productionArray[i] = db.return_seasonal_production(conn, "summer_low_cloud");
                    }
                    else if(weather[i] < 72){
                            productionArray[i] = db.return_seasonal_production(conn, "summer_medium_cloud");
                    }
                    else{
                            productionArray[i] = db.return_seasonal_production(conn, "summer_high_cloud");
                    }
                }
                //AUTUMN
                if(month == "March" || month == "April" || month == "May"){
                    //Check Cloudiness
                    if(weather[i] < 29){
                        //ASSIGN PRODUCTION TO DAY
                        productionArray[i] = db.return_seasonal_production(conn, "autumn_low_cloud");
                    }
                    else{
                        productionArray[i] = db.return_seasonal_production(conn, "autumn_high_cloud");
                    }
                }
                //AUTUMN
                if(month == "June" || month == "July" || month == "August"){
                    //ASSIGN PRODUCTION TO DAY
                    productionArray[i] = db.return_seasonal_production(conn, "winter");
                }
                //SPRING
                if(month == "September" || month == "October" || month == "November"){
                    if(weather[i] < 42){
                        //ASSIGN PRODUCTION TO DAY
                        productionArray[i] = db.return_seasonal_production(conn, "spring_low_cloud");
                    }
                    else if(weather[i] < 80){
                        productionArray[i] = db.return_seasonal_production(conn, "spring_medium_cloud");
                    }
                    else{
                        productionArray[i] = db.return_seasonal_production(conn, "spring_high_cloud");
                    }
                }
            }
        }
        for(int i = 0; i < 7; i++){
            int count = 0;
            for(int j = 6; j < 20; j++){
                if(productionArray[i][j] > Consumption && count < MaxperDay){
                    data[j][i+1] = "Airconditioner";
                    System.out.println(Arrays.deepToString(data));
                }
            }
        }
        Scheduler.setTable();
    }

}
