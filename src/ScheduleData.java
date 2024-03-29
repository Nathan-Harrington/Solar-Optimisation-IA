import java.sql.Connection;
import java.time.LocalDate;

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
    public void updateSchedule(){
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
    public void scheduleAircon(int Cycles, Boolean[] days, int MaxperDay, int Production){
        //RETRIEVE WEATHER AND DEFINE PRODUCTION
        int[] weather = db.return_weather(conn);
        int[] productionArray = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        //CHECK FIRST IF THE CLIENT HAS SET THE DAY TO HAVE APPLIANCES RUN ON
        for(int i = 0; i < days.length; i++){
            if(days[i]){ //if true essentially as days is an array of booleans
                //CHECK IF IT IS SUMMER
                if(month == "December" || month == "January" || month = "February"){

                }
            }
        }
    }

}
