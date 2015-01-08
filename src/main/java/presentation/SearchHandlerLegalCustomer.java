package presentation;

import dataBaseAccess.DataBaseExplorer;
import dataBaseAccess.LegalCustomer;
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
 * In this class we search Legal Customer's Information by utilizing  HttpServletRequest.
 */
//@WebServlet("/SearchHandlerLegalCustomer")
public class SearchHandlerLegalCustomer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String customerId = request.getParameter("customerId");
        String economicId = request.getParameter("economicId");
        List<LegalCustomer> legalCustomersList= new ArrayList<LegalCustomer>();

        PrintWriter writer = response.getWriter();
        ResultSet rs ;
        DataBaseExplorer dataBaseExplorer = new DataBaseExplorer();
        if (economicId.equals(""))
            economicId="0";
        if(customerId.equals(""))
            customerId="0";
        boolean checkExist = dataBaseExplorer.searchLegalCustomer(name,Integer.parseInt(economicId),Integer.parseInt(customerId));
        String nameExtract;
        int economicIdExtract;
        String registerDateExtract;
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
            legalCustomersList = dataBaseExplorer.legalCustomersList;
            htmlResponse +="<table style=\"width:90%\">";
            htmlResponse +="<caption>Legal Customer</caption>";
            htmlResponse +="<tr>";
            htmlResponse +="<th>Name</th>";
            htmlResponse +="<th>Economic Code</th>";
            htmlResponse +="<th>Register Date</th>";
            htmlResponse +="<th>Customer Number</th>";
            htmlResponse +="<th>Delete</th>";
            htmlResponse +="<th>Modification</th>";
            htmlResponse +="</tr>";
            try {
                for(int i = 0 ; i < legalCustomersList.size();i++){
                    //Retrieve by column name
                    nameExtract  = legalCustomersList.get(i).getName();
                    economicIdExtract = legalCustomersList.get(i).getEconomicId();
                    registerDateExtract = legalCustomersList.get(i).getRegisterDate();
                    customerIdExtract = legalCustomersList.get(i).getCustomerId();

                    htmlResponse +="<tr name=\"i\">";
                    htmlResponse +="<th>" + nameExtract + "</th>";
                    htmlResponse +="<th>" + economicIdExtract + "</th>";
                    htmlResponse +="<th>" + registerDateExtract + "</th>";
                    htmlResponse +="<th>" + customerIdExtract + "</th>";
                    htmlResponse +="<th><form method=\"post\" action=\"DeleteLegalCustomer\"><button>Delete</button><input type=\"hidden\" name=\"economicId\" value=\""+ economicIdExtract +"\"/></form></th>";
                    htmlResponse +="<th><form method=\"post\"action=\"UpdateLegalCustomer\" ><button>Modification</button><input type=\"hidden\" name=\"economicId\" value=\""+ economicIdExtract +"\"/></form></th>";
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
