import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunctions {
    public Connection connect_to_db(String dbname, String user, String pass){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname, user, pass);
            if (conn != null){
                System.out.println("Connection Established");
            }
            else{
                System.out.println("Connection Failed");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }
//COULD GENERALISE WITH MORE ARGUMENTS TO A GENERAL UPDATE
    public static void update_column_int(Connection conn, String table_name, String appliance_name, int new_value, String column_name){
        Statement statement;
        try{
            String query = String.format("update %s set %s = %s where appliance_name = '%s'", table_name, column_name,new_value, appliance_name); //name can be changed to id for example
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated Type: (Int)");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void update_column_bool(Connection conn, String table_name, String column_name, boolean new_value, String appliance_name){
        Statement statement;
        try{
            String query = String.format("update %s set %s = %s where appliance_name = '%s'", table_name, column_name, new_value, appliance_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated Type: (Bool)");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public boolean return_bool_day(Connection conn, String table_name, String day, String appliance_name){
        Statement statement;
        ResultSet rs = null;
        boolean returnBool = true;
        try{
            String query = String.format("select appliance_%s from %s where appliance_name = '%s'", day, table_name, appliance_name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){ //.next() required to read from database otherwise rs set not positioned correctly!
                returnBool = rs.getBoolean(String.format("appliance_%s", day));
            }
            System.out.println(returnBool);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return returnBool;
    }
    public int return_appliances_num(Connection conn, String column_name, String appliance_name){
        Statement statement;
        ResultSet rs = null;
        int returnInt = 0;
        try{
            String query = String.format("select %s from appliances where appliance_name = '%s'", column_name, appliance_name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){
                returnInt = rs.getInt(column_name);
            }
            System.out.println(returnInt);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return returnInt;
    }
    public int[] return_weather(Connection conn){
        Statement statement;
        ResultSet rs = null;
        int count = 0;
        int[] returnInt = {0,0,0,0,0,0,0};
        try{
            String query = String.format("select average_cloud_coverage from weather");
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){ //.next() required to read from database otherwise rs set not positioned correctly!
                returnInt[count] = rs.getInt("average_cloud_coverage");
                count += 1;
            }
            System.out.println(returnInt);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return returnInt;
    }
    public float[] return_seasonal_production(Connection conn, String column_name){
        Statement statement;
        ResultSet rs = null;
        int count = 0;
        float[] returnInt = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        try{
            String query = String.format("select %s from seasonal_models", column_name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){ //.next() required to read from database otherwise rs set not positioned correctly!
                returnInt[count] = rs.getInt(column_name);
                count += 1;
            }
            System.out.println(returnInt);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return returnInt;
    }
}

