import java.sql.Connection;

public class Main {
    // Colour Palette faf3dd, c8d5b9, 8fc0A9, 68B0AB, 4a7c59
    static Frame window1 = new Frame();
    public static void main(String args[]){
        Dashboard dashboard = new Dashboard();
        DbFunctions db = new DbFunctions();
        Connection conn = db.connect_to_db("solardb", "postgres", "solar");
        //db.createTable(conn, "SeasonalModelHourly");
        System.out.println("run");
    }
    public static void SchedulerOff(){
        Dashboard.dashboardwindow.setVisible(false);
        SchedulerOn();
    }
    public static void SchedulerOn(){
        Scheduler.schedulerwindow.setVisible(true);
        Scheduler scheduler = new Scheduler();
    }
}
