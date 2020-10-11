package sql;

import devices.electric.ElectricDevice;
import devices.electric.home.*;

import java.sql.*;
import java.util.List;

public class DataBase {

    /**
     * Function to connect DataBase
     * @return Connection
     */
    private static Connection connect(){
        Connection conn = null;
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:devices.db");
        } catch (ClassNotFoundException | SQLException e){
            System.out.println(e.toString());
        }
        return conn;
    }

    /**
     * Function to read all devices from DataBase
     * @param devices
     */
    public static void readAllData(List<ElectricDevice> devices){
        Connection conn = DataBase.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;

        try{
            //add devices from table Fridge
            sql = "SELECT * FROM Fridge";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            Fridge fridge;

            while(rs.next()){
                String name = rs.getString("Name");
                String company = rs.getString("Company");
                Double power = rs.getDouble("Power");
                Double capacity = rs.getDouble("Capacity");

                fridge = new Fridge(name, company, power, capacity);
                devices.add(fridge);
            }

            //add devices from table Kettle
            sql = "SELECT * FROM Kettle";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            Kettle kettle;

            while(rs.next()){
                String name = rs.getString("Name");
                String company = rs.getString("Company");
                Double power = rs.getDouble("Power");
                Double capacity = rs.getDouble("Capacity");

                kettle = new Kettle(name, company, power, capacity);
                devices.add(kettle);
            }

            //add devices from table Lamp
            sql = "SELECT * FROM Lamp";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            Lamp lamp;

            while(rs.next()){
                String name = rs.getString("Name");
                String company = rs.getString("Company");
                Double power = rs.getDouble("Power");
                Double luminousFlux = rs.getDouble("LuminousFlux");

                lamp = new Lamp(name, company, power, luminousFlux);
                devices.add(lamp);
            }

        } catch (SQLException e){
            System.out.println(e.toString());
        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();
                System.out.println("Devices added.");
            } catch (SQLException e){
                System.out.println(e.toString());
            }
        }
    }

}
