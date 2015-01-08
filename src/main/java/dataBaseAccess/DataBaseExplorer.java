package dataBaseAccess;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marzieh on 12/24/2014.
 * In this class we search real and legal customers in tables of database and retrieve customer number for legal and real customers.
 */
public class DataBaseExplorer {
    //todo port:3306, user:root, pass:root
    public static String DB_URLNew = "jdbc:mysql://localhost:3306/CUSTOMERS";
    public static String USER = "root";
    public static String PASS = "root";
    public static Connection connection ;
    public List<LegalCustomer> legalCustomersList= new ArrayList<LegalCustomer>();
    public List<RealCustomer> realCustomersList= new ArrayList<RealCustomer>();
    public ResultSet rs;
    //public ResultSet returnRs;

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


    public boolean searchLegalCustomer(String name, int economicId, int customerId){
        int index = 1;
    PreparedStatement preparedStatement = null;
        LegalCustomer legalCustomer;
        String sql ;//= "SELECT economicId, name, registerDate, customerId FROM";
        try{
            sql = "SELECT * FROM  REGISTRATION_LEGAL_CUSTOMER WHERE 1=1 ";
            if(!name.equals("")){
                sql += "AND name=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(index,name);
            }
            if(economicId!=0){
                sql += "AND economicId=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(index,economicId);
            }
            if(customerId!=0){
                sql += "AND customerId=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(index,customerId);
            }
            rs = null;
            if(preparedStatement!= null)
                rs = preparedStatement.executeQuery();
            int counter = 0;
            if(rs!=null)
            while(rs.next())
            {
                legalCustomer = new LegalCustomer(rs.getInt("economicId"),rs.getString("name"),rs.getString("registerDate"),rs.getInt("customerId"));
                counter+=1;
                legalCustomersList.add(legalCustomer);
            }
            if(counter>0){
                return true;
            }
            rs.close();

        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean searchRealCustomer(String first, String last,int nationalId, int customerId){
        PreparedStatement preparedStatement= null;
        RealCustomer realCustomer;
        String sql = "";
        int index = 1;
        try{
            sql = "SELECT * FROM REGISTRATION_REAL_CUSTOMER WHERE 1=1 ";
            if(!first.equals("")){
                sql += "AND first=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(index,first);
            }
            if(!last.equals("")){
                sql += "AND last=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(index,last);
            }
            if(nationalId!=0){
                sql += "AND nationalId=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(index,nationalId);
            }
            if(customerId!=0){
                sql += "AND customerId=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(index,customerId);
            }

            rs = null;
            if (preparedStatement!= null)
               rs = preparedStatement.executeQuery();
            int counter = 0;
            if (rs!=null)
            while(rs.next())
            {
                realCustomer = new RealCustomer(rs.getInt("nationalId"),rs.getString("first"),rs.getString("last"),rs.getString("fatherName"),rs.getString("birthDate"),rs.getInt("customerId"));
                realCustomersList.add(realCustomer);
                counter+=1;
            }
            if(counter>0){
                return true;
            }
            rs.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public int returnRealCustomerNumber(){
        Statement statement = null;
        int customerId = 1;
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            statement = connection.createStatement();
            String sql ="SELECT customerId FROM REGISTRATION_REAL_CUSTOMER ORDER BY customerId DESC LIMIT 1";
            rs = null;
            rs = statement.executeQuery(sql);
            while(rs.next())
            {
                customerId = rs.getInt("customerId");
                customerId+=1;
            }
            rs.close();

        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }

        return customerId;
    }

    public int returnLegalCustomerNumber(){
        Statement statement = null;
        int customerId = 1;
        try{
           // Class.forName("com.mysql.jdbc.Driver");
            statement = connection.createStatement();
            String sql = "SELECT customerId FROM REGISTRATION_LEGAL_CUSTOMER ORDER BY customerId DESC LIMIT 1";
            rs = null;
            rs = statement.executeQuery(sql);
            while(rs.next())
            {
                customerId = rs.getInt("customerId");
                customerId+=1;
            }

            rs.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }


        return customerId;
    }

    public void updateLegalCustomerTable(String economicId,String name,String registerDate,String customerId){
        Statement statement = null;

        //int index=1;
        try{
            statement = connection.createStatement();
            String sql = "UPDATE REGISTRATION_LEGAL_CUSTOMER SET ";
            if(!name.equals("")){
                sql+="  name='"+name+"'";
                if(!customerId.equals("")){
                    sql+=" , customerId="+customerId+"";
                    if(!registerDate.equals("")){
                        sql+=" , registerDate="+registerDate+"";
                    }
                }
            }
            else if(!customerId.equals("")){
                sql+=" customerId="+customerId+"";
                if(!registerDate.equals("")){
                    sql+=" , registerDate='"+registerDate+"'";
                }
            }
            else if(!registerDate.equals("")){
                sql+="  registerDate='"+registerDate+"'";
            }
            sql +=" WHERE economicId="+economicId+"";
            statement.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateRealCustomerTable(String nationalId,String first,String last,String fatherName,String birthDate,String customerId){
        Statement statement = null;
        int index=1;
        try{
            statement = connection.createStatement();
            String sql = "UPDATE REGISTRATION_REAL_CUSTOMER SET";
            if(!first.equals("")){
                sql+="  first='"+first+"'";
                if(!last.equals("")){
                    sql+=" , last='"+last+"'";
                    if(!fatherName.equals("")){
                        sql+=" , fatherName='"+fatherName+"'";
                        if(!customerId.equals("")){
                            sql+=" , customerId="+customerId+"";
                            if(!birthDate.equals("")){
                                sql+=" , birthDate='"+birthDate+"'";
                            }
                        }
                    }
                }
            }
            else if(!last.equals("")){
                sql+="  last='"+last+"'";
                if(!fatherName.equals("")){
                    sql+=" , fatherName='"+fatherName+"'";
                    if(!customerId.equals("")){
                        sql+=" , customerId="+customerId+"";
                        if(!birthDate.equals("")){
                            sql+=" , birthDate='"+birthDate+"'";
                        }
                    }
                }
            }
            else if(!fatherName.equals("")){
                sql+=" fatherName='"+fatherName+"'";
                if(!customerId.equals("")){
                    sql+=" , customerId="+customerId+"";
                    if(!birthDate.equals("")){
                        sql+=" , birthDate='"+birthDate+"'";
                    }
                }
            }
            else if(!customerId.equals("")){
                sql+=" customerId="+customerId+"";
                if(!birthDate.equals("")){
                    sql+=" , birthDate='"+birthDate+"'";
                }
            }
            else if(!birthDate.equals("")){
                sql+=" birthDate='"+birthDate+"'";
            }
            sql +=" WHERE nationalId="+nationalId+"";
            statement.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
