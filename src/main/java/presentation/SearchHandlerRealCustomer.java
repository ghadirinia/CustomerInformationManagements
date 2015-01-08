package presentation;

import dataBaseAccess.DataBaseExplorer;
import dataBaseAccess.RealCustomer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marzieh on 12/25/2014.
 * In this class servlet has utilized as middle layer to receive data from a html page and do process on them and produce new information and dynamic html page.
 * In this class we search Real Customer's Information by utilizing  HttpServletRequest.
 */
//@WebServlet("/SearchHandlerRealCustomer")
public class SearchHandlerRealCustomer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String first = request.getParameter("first");
        String last = request.getParameter("last");
        String fatherName = request.getParameter("fatherName");
        String customerId = request.getParameter("customerId");
        String nationalId = request.getParameter("nationalId");
        List<RealCustomer> realCustomersList= new ArrayList<RealCustomer>();


        // do some processing here...
        // checking input validation type in logic layer
        //make response.

        // get response writer
        PrintWriter writer = response.getWriter();
        ResultSet rs ;
        DataBaseExplorer dataBaseExplorer = new DataBaseExplorer();
        if (nationalId.equals(""))
            nationalId="0";
        if(customerId.equals(""))
            customerId="0";
        boolean checkExist = dataBaseExplorer.searchRealCustomer(first,last,Integer.parseInt(nationalId),Integer.parseInt(customerId));
        String firstExtract;
        String lastExtract;
        String fatherNameExtract;
        int nationalIdExtract;
        String birthDateExtract;
        int customerIdExtract;
        String htmlResponse = "<!DOCTYPE html>";
        htmlResponse +="<html>";
        htmlResponse +="<head lang=\"en\">";
        htmlResponse +="<meta charset=\"UTF-8\">";
        htmlResponse +="<title></title>";
        htmlResponse +="<style>";
        htmlResponse +="table, th, td { border: 1px solid ; border-collapse: collapse; border-color: yellow;}";
        htmlResponse +="th, td { padding: 5px; color : yellow}";
        htmlResponse +="caption {color:yellow}";
        htmlResponse +="th { text-align: left; }";
        htmlResponse +="body {background-color:midnightblue}";
        htmlResponse +="div { border:2px solid ;border-color: yellow ;margin:20px; padding:20px; width: 93%}";
        htmlResponse += "h3 {color: yellow}";
        htmlResponse +="</style>";
        htmlResponse +="</head>";
        htmlResponse +="<body>";
        htmlResponse +="<div>";
        if(checkExist){
            realCustomersList = dataBaseExplorer.realCustomersList;
            htmlResponse +="<table style=\"width:90%\">";
            htmlResponse +="<caption color=yellow>Real Customer</caption>";
            htmlResponse +="<tr>";
            htmlResponse +="<th>firstName</th>";
            htmlResponse +="<th>lastName</th>";
            htmlResponse +="<th>fatherName</th>";
            htmlResponse +="<th>birth Date</th>";
            htmlResponse +="<th>National Code</th>";
            htmlResponse +="<th>Customer Number</th>";
            htmlResponse +="<th>Delete</th>";
            htmlResponse +="<th>Modification</th>";
            htmlResponse +="</tr>";
            try {
                for(int i = 0 ; i < realCustomersList.size(); i++){
                    //Retrieve by column name
                    firstExtract  = realCustomersList.get(i).getFirst();
                    lastExtract  = realCustomersList.get(i).getLast();
                    fatherNameExtract  = realCustomersList.get(i).getFatherName();
                    birthDateExtract = realCustomersList.get(i).getBirthDate();
                    nationalIdExtract = realCustomersList.get(i).getNationalId();
                    customerIdExtract = realCustomersList.get(i).getCustomerId();

                    htmlResponse +="<tr>";
                    htmlResponse +="<th>" + firstExtract + "</th>";
                    htmlResponse +="<th>" + lastExtract+ "</th>";
                    htmlResponse +="<th>" + fatherNameExtract + "</th>";
                    htmlResponse +="<th>" + birthDateExtract + "</th>";
                    htmlResponse +="<th >" + nationalIdExtract + "</th>";
                    htmlResponse +="<th>" + customerIdExtract + "</th>";
                    htmlResponse +="<th><form method=\"post\" action=\"DeleteRealCustomer\"><button>Delete</button><input type=\"hidden\" name=\"nationalId\" value=\""+ nationalIdExtract +"\"/></form></th>";
                    htmlResponse +="<th><form method=\"post\" action=\"UpdateRealCustomer\" ><input type=\"hidden\" name=\"nationalId\" value=\""+ nationalIdExtract +"\"/><button>Modification</button></form></th>";
                    htmlResponse +="</tr>";

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else
        {
            htmlResponse +="<p><h3>There is no such a customer</h3></p>";
        }
        htmlResponse +="</table>";
        htmlResponse +="</div>";
        htmlResponse +="</body>";
        htmlResponse +="</html>";
        writer.println(htmlResponse);

    }
}
