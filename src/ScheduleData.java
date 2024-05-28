import java.sql.Connection;
import java.time.LocalDate;
import java.util.Arrays;

public class ScheduleData{

    float[][] productionArray = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //EACH VALUE DEMARCATES HOW MUCH UNASSIGNED IS PRODUCED
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
    public static LocalDate now = LocalDate.now(); //import Time
    public static int monthIndex = now.getMonthValue(); //import Time
    public static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public static String month = months[monthIndex - 1];
    DbFunctions db = new DbFunctions();
    Connection conn = db.connect_to_db("solardb", "postgres", "solar");
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
    int[] weather = db.return_weather(conn);
    public static Object[][] data = {{"0:00", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device", "No Device"},
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
        for(int i = 0; i < 7; i++){
            //CHECK IF IT IS SUMMER
            if(month == "December" || month == "January" || month == "February"){
                System.out.println("Summer");
                //Check Cloudiness
                if(weather[i] < 42){
                    //ASSIGN PRODUCTION TO DAY
                    System.out.println("SummerLC");
                    productionArray[i] = db.return_seasonal_production(conn, "summer_low_cloud");
                }
                else if(weather[i] < 72){
                    System.out.println("SummerMC");
                    productionArray[i] = db.return_seasonal_production(conn, "summer_medium_cloud");
                }
                else{
                    System.out.println("SummerHC");
                    productionArray[i] = db.return_seasonal_production(conn, "summer_high_cloud");
                }
            }
            //AUTUMN
            if(month == "March" || month == "April" || month == "May"){
                //Check Cloudiness
                if(weather[i] < 29){
                    //ASSIGN PRODUCTION TO DAY
                    System.out.println("AutumnLC");
                    productionArray[i] = db.return_seasonal_production(conn, "autumn_low_cloud");
                }
                else{
                    System.out.println("AutumnHC");
                    productionArray[i] = db.return_seasonal_production(conn, "autumn_high_cloud");
                }
            }
            //AUTUMN
            if(month == "June" || month == "July" || month == "August"){
                //ASSIGN PRODUCTION TO DAY
                System.out.println("Winter");
                productionArray[i] = db.return_seasonal_production(conn, "winter");
            }
            //SPRING
            if(month == "September" || month == "October" || month == "November"){
                System.out.println("Spring");
                if(weather[i] < 42){
                    //ASSIGN PRODUCTION TO DAY
                    System.out.println("SpringLC");
                    productionArray[i] = db.return_seasonal_production(conn, "spring_low_cloud");
                }
                else if(weather[i] < 80){
                    System.out.println("SpringMC");
                    productionArray[i] = db.return_seasonal_production(conn, "spring_medium_cloud");
                }
                else{
                    System.out.println("SpringHC");
                    productionArray[i] = db.return_seasonal_production(conn, "spring_high_cloud");
                }
            }
        }
       // for(int i = 0; i < 2; i ++){
            scheduleAircon(AirconCycles, AirconDays, AirconMaxQuota, AirconConsumption);
            //if(i == 0){
                //Scheduler.resetTable();
            //}
        //}
    }
    //FIRST INSTANCE OF SCHEDULING
    static float[][] batteryWh = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //EACH VALUE DEMARCATES AVAILABLE POWER IN THAT HOUR SLOT
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

    public void scheduleAircon(int Cycles, Boolean[] days, int MaxperDay, int Consumption){
        int totalCount = 0; //number of times Air Con has been scheduled in the week
        outerLoop:
        for(int i = 0; i < 7; i++){
            int count = 0; //number of times Air Con has been scheduled in the day
            for(int j = 6; j < 20; j++){
                if (!days[i]) {
                    // IF USER HAS SET DAY TO FALSE AUTOMATICALLY INCREMENT
                    continue outerLoop;
                }
                //CHECKS IF PREDICTED ENERGY IN THE HOUR IS GREATER THAN CONSUMPTION
                if((productionArray[i][j] > Consumption) && (count < MaxperDay)  && (totalCount < Cycles)){  //&& days[i]
                    count += 1;
                    totalCount += 1;
                    data[j][i+1] = "Airconditioner";
                    batteryWh[i][j + 1] = batteryWh[i][j] + productionArray[i][j] - Consumption;
                    productionArray[i][j] = productionArray[i][j] - Consumption;
                }
                //CHECKS IF STORED BATTERY ENERGY IS SUFFICIENT
                else if ((batteryWh[i][j] > Consumption) && (count < MaxperDay) && (totalCount < Cycles)) {
                    count += 1;
                    totalCount += 1;
                    data[j][i + 1] = "Airconditioner";
                    batteryWh[i][j + 1] = batteryWh[i][j] - Consumption + productionArray[i][j];
                }
                //IF NEITHER CASE IS APPLICABLE
                else{
                    batteryWh[i][j + 1] = batteryWh[i][j] + productionArray[i][j];
                }

            }
        }
        //CALLS THE DISHWASHER FUNCTION
        scheduleDishwasher(DishwasherCycles, DishwasherDays, DishwasherMaxQuota, DishwasherConsumption);
        Scheduler.setTable();
    }
    public void scheduleDishwasher(int Cycles, Boolean[] days, int MaxperDay, int Consumption){
        int totalCount = 0;
        for(int i = 0; i < 7; i++){
            int count = 0;
            for(int j = 6; j < 20; j++){
                if((data[j][i+1] != "Airconditioner") && productionArray[i][j] > Consumption && count < MaxperDay  && totalCount < Cycles && days[i]){
                    data[j][i+1] = "Dishwasher";
                    count += 1;
                    totalCount += 1;
                    batteryWh[i][j + 1] = batteryWh[i][j] + productionArray[i][j] - Consumption;
                    productionArray[i][j] = productionArray[i][j] - Consumption;
                }
                else if ((data[j][i+1] != "Airconditioner") && batteryWh[i][j] > Consumption && count < MaxperDay && totalCount < Cycles && days[i]) {
                    data[j][i + 1] = "Dishwasher";
                    //System.out.println(data);
                    batteryWh[i][j+1] = batteryWh[i][j + 1] - Consumption;
                    count += 1;
                    totalCount += 1;
                }
                else if (data[j][i + 1].equals("Airconditioner")){
                    batteryWh[i][j + 1] = batteryWh[i][j] + productionArray[i][j] - AirconConsumption;
                }
                else{
                    batteryWh[i][j+1] = batteryWh[i][j] + productionArray[i][j];
                }
            }
        }
        scheduleWashingMachine(WashingMachineCycles, WashingMachineDays, WashingMachineMaxQuota, WashingMachineConsumption);
    }

    public void scheduleWashingMachine(int Cycles, Boolean[] days, int MaxperDay, int Consumption){
        int totalCount = 0;
        for(int i = 0; i < 7; i++){
            int count = 0;
            for(int j = 6; j < 20; j++){
                if((data[j][i+1] != "Airconditioner" && data[j][i+1] != "Dishwasher") && productionArray[i][j] > Consumption && count < MaxperDay  && totalCount < Cycles && days[i]){
                    data[j][i+1] = "Washing Machine";
                    count += 1;
                    totalCount += 1;
                    batteryWh[i][j + 1] = batteryWh[i][j] + productionArray[i][j] - Consumption;
                    productionArray[i][j] = productionArray[i][j] - Consumption;
                    //System.out.println(Arrays.deepToString(data));
                }
                else if ((data[j][i+1] != "Airconditioner" && data[j][i+1] != "Dishwasher") && batteryWh[i][j] > Consumption && count < MaxperDay && totalCount < Cycles && days[i]) {
                    data[j][i + 1] = "Washing Machine";
                    //System.out.println(data);
                    batteryWh[i][j+1] = batteryWh[i][j + 1] - Consumption;
                    count += 1;
                    totalCount += 1;
                }
                else if(data[j][i + 1].equals("Airconditioner")){
                    batteryWh[i][j + 1] = batteryWh[i][j] + productionArray[i][j] - DishwasherConsumption;
                }
                else if(data[j][i + 1].equals("Dishwasher")){
                    batteryWh[i][j + 1] = batteryWh[i][j] + productionArray[i][j] - DishwasherConsumption;
                }
                else{
                    batteryWh[i][j+1] = batteryWh[i][j] + productionArray[i][j];
                }

            }
        }
        System.out.println(Arrays.deepToString(batteryWh));
    }
}

