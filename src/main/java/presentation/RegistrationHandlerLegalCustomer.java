package presentation;

import businessLogical.CustomerProcessor;
import dataBaseAccess.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



/**
 * Created by Marzieh on 12/25/2014.
 * In this class servlet has utilized as middle layer to receive data from a html page and do process on them and produce new information and dynamic html page.
 * In this class we Register Legal Customer's Information by utilizing  HttpServletRequest.
 */
//@WebServlet("/RegistrationHandlerLegalCustomer")
public class RegistrationHandlerLegalCustomer extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // read form fields
        String name = request.getParameter("name");
        String registerDate = request.getParameter("registerDate");
        String economicId = request.getParameter("economicId");
        CustomerProcessor customerProcessor = new CustomerProcessor();
        LegalCustomer legalCustomer = null;
        try {
            customerProcessor.produceLegalCustomer(name, registerDate, economicId);
            legalCustomer =customerProcessor.legalCustomer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //make response.

        // get response writer
        PrintWriter writer = response.getWriter();

        DataBaseCreator dataBaseCreator = new DataBaseCreator();
        dataBaseCreator.insertRecordToLegalCustomer( legalCustomer);

        String htmlRespone = "<!DOCTYPE html>";
        htmlRespone += "<html>";
        htmlRespone += "<head lang=\"en\">";
        htmlRespone += "<meta charset=\"UTF-8\">";
        htmlRespone += "<title> Registration </title>";
        htmlRespone += "<style>";
        htmlRespone += "body {background-color:midnightblue}";
        htmlRespone += "h1   {color:yellow}";
        htmlRespone += "h3 {color: yellow}";
        htmlRespone += "h3 {color: yellow}";
        htmlRespone += "div.one { border:2px solid ;border-color: yellow ;margin:20px; padding:20px; width: 93%}";
        htmlRespone += "p.one {color: yellow ; align-content: center ;}";
        htmlRespone += "</style>";
        htmlRespone += "</head>";
        htmlRespone += "<body>";
        htmlRespone += "<h1>Registration</h1>";
        htmlRespone += "<div class=\"one\">";
        if(legalCustomer!=null){
            htmlRespone +="<p.one><h3>"+"Real customer Number:"+legalCustomer.getCustomerId();
        }else {
            htmlRespone += "<p.one><h3>"+"Input values are incorrect or the Economic ID is duplicate";
        }
        htmlRespone += "</h3></p>";
        htmlRespone += "</div>";
        htmlRespone += "</body>";
        writer.print(htmlRespone);

    }
}

