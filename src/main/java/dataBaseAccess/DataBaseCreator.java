package dataBaseAccess;


import java.sql.*;
/**
 * Created by Marzieh on 12/24/2014.
 * In this class We create database,2 type tables and insert records in these two tables.
 */
public class DataBaseCreator {
    //todo port:3306, user:root, pass:root
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

    public void createDataBase(){
        Statement statement;
        try{
            statement = connection.createStatement();

            String sql = "CREATE DATABASE CUSTOMERS";
            statement.executeUpdate(sql);
        }catch(SQLException se){
            se.printStackTrace();
        }
    }

    public void createRegistrationTableForRealCustomer(){
        Statement statement;
        try{
            statement = connection.createStatement();

            String sql = "CREATE TABLE REGISTRATION_REAL_CUSTOMER " +
                    "(nationalId INTEGER not NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " fatherName VARCHAR(225), "+
                    " birthDate VARCHAR(225), " +
                    " customerId INTEGER, "+
                    " PRIMARY KEY ( nationalId ))";

            statement.executeUpdate(sql);
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void createRegistrationTableForLegalCustomer(){
        Statement statement;
        try{
            connection = DriverManager.getConnection(DB_URLNew, USER, PASS);
            statement = connection.createStatement();
            String sql = "CREATE TABLE REGISTRATION_LEGAL_CUSTOMER " +
                    "(economicId INTEGER not NULL, " +
                    " name VARCHAR(255), " +
                    " registerDate VARCHAR(225), " +
                    " customerId INTEGER, "+
                    " PRIMARY KEY ( economicId ))";

            statement.executeUpdate(sql);
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertRecordToLegalCustomer(LegalCustomer legalCustomer){

        Statement statement ;
        try{
            connection = DriverManager.getConnection(DB_URLNew, USER, PASS);
            statement = connection.createStatement();
            String sql = "INSERT INTO REGISTRATION_LEGAL_CUSTOMER (economicId,name,registerDate,customerId) " +
                    "VALUES ("+legalCustomer.getEconomicId()+
                    ", '"+legalCustomer.getName()+
                    "', '"+legalCustomer.getRegisterDate()+
                    "',"+legalCustomer.getCustomerId()+")";
            System.out.println(sql);
            statement.executeUpdate(sql);
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertRecordToRealCustomer(RealCustomer realCustomer){
        Statement statement;
        try{
            connection = DriverManager.getConnection(DB_URLNew, USER, PASS);
            statement = connection.createStatement();
            String sql = "INSERT INTO REGISTRATION_REAL_CUSTOMER " +
                    "VALUES ("+realCustomer.getNationalId()+
                    ", '"+realCustomer.getFirst()+
                    "', '"+realCustomer.getLast()+
                    "', '"+realCustomer.getFatherName()+
                    "', '"+realCustomer.getBirthDate()+
                    "',"+realCustomer.getCustomerId()+")";
            statement.executeUpdate(sql);
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}

