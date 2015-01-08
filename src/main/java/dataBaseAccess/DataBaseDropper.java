package dataBaseAccess;

import java.sql.*;

/**
 * Created by Marzieh on 12/24/2014.
 * In this class we delete database, and tables and delete records in these tables.
 */
public class DataBaseDropper {
    public static String DB_URLNew = "jdbc:mysql://localhost:3306/CUSTOMERS";
    public static String USER = "root";
    public static String PASS = "root";
    public static Connection connection ;


    static {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URLNew, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void dropDataBase() {
        Statement statement;
        try{
           // Class.forName("com.mysql.jdbc.Driver");
            statement = connection.createStatement();
            String sql = "DROP DATABASE CUSTOMERS";
            statement.executeUpdate(sql);
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
    public void dropTableFromDataBase( String tableName){
        Statement statement;
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            statement = connection.createStatement();
            String sql = "DROP TABLE "+tableName;
            statement.executeUpdate(sql);
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void deleteRecordFromLegalCustomer(String economicId){
        Statement statement;
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            statement = connection.createStatement();
            String sql = "DELETE FROM REGISTRATION_lEGAL_CUSTOMER " +
                    "WHERE economicId = "+economicId;
            statement.executeUpdate(sql);
            //sql = "SELECT id, first, last, age FROM REGISTRATION_lEGAL_CUSTOMER ";
            //ResultSet rs = statement.executeQuery(sql);
            //rs.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void deleteRecordFromRealCustomer(String nationalId){
        Statement statement;
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            statement = connection.createStatement();
            String sql = "DELETE FROM REGISTRATION_REAL_CUSTOMER " +
                    "WHERE nationalId = "+nationalId;
            statement.executeUpdate(sql);
            //sql = "SELECT id, first, last, age FROM REGISTRATION_lEGAL_CUSTOMER ";
            //ResultSet rs = statement.executeQuery(sql);

            //rs.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
