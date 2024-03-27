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
    public void createTable(Connection conn, String table_name){
        Statement statement;
        try{
            String query = "create table "+table_name+"(time SERIAL, SummerHC numeric(6, 2),  SummerMCnumeric(6, 2), SummerLC numeric(6, 2), AutumnHC numeric(6, 2), AutumnLC numeric(6, 2), Winter numeric(6, 2), SpringHC numeric(6, 2), SpringMC numeric(6, 2), SpringLC  numeric(6, 2));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void insert_row(Connection conn, String table_name, String name, String address){
        Statement statement;
        try{
            String query = String.format("insert into %s(name, address) values('%s', '%s');", table_name, name, address);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void read_data(Connection conn, String table_name){
        Statement statement;
        ResultSet rs = null;
        try{
            String query = String.format("select * from %s", table_name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getString("empid")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("Address")+" ");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
//COULD GENERALISE WITH MORE ARGUMENTS TO A GENERAL UPDATE
    public static void update_appliance_cycles_num(Connection conn, String table_name, String appliance_name, int new_value){
        Statement statement;
        try{
            String query = String.format("update %s set appliance_cycles_num = %s where appliance_name = '%s'", table_name, new_value, appliance_name); //name can be changed to id for example
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void search_by_name(Connection conn, String table_name, String name){
        Statement statement;
        ResultSet rs = null;
        try{
            String query = String.format("select * from %s where name = '%s'", table_name, name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getString("empid"));
                System.out.print(rs.getString("name"));
                System.out.println(rs.getString("address"));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public  void delete_row_by_name(Connection conn, String table_name, String name){
        Statement statement;
        try{
            String query = String.format("delete from %s where name = '%s'", table_name, name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Deleted");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void delete_table(Connection conn, String table_name){
        Statement statement;
        try{
            String query = String.format("drop table %s", table_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Deleted");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

