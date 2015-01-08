package presentation;

import dataBaseAccess.DataBaseExplorer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Dotin school 2 on 1/4/2015.
 * In this class servlet has utilized as middle layer to receive data from a html page and do process on them and produce new information and dynamic html page.
 * In this class we change Legal Customer's Information by utilizing  HttpServletRequest.
 */
//@WebServlet("/ModificationLegalCustomer")
public class ModificationLegalCustomer extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

        String economicId = request.getParameter("economicId");
        String name = request.getParameter("name");
        String registerDate = request.getParameter("registerDate");
        String customerId = request.getParameter("customerId");
        DataBaseExplorer dataBaseExplorer = new DataBaseExplorer();
        dataBaseExplorer.updateLegalCustomerTable(economicId,name,registerDate,customerId);
        PrintWriter writer = response.getWriter();
        String htmlResponse = "";
        htmlResponse += "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head lang=\"en\">\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Registration</title>\n" +
                "    <style>\n" +
                "        body {background-color:midnightblue}\n" +
                "        h1   {color:yellow}\n" +
                "        button    {color:black ; background-color: lightyellow}\n" +
                "        h3 {color: yellow}\n" +
                "        div.one { border:2px solid ;border-color: yellow ;margin:20px; padding:20px; width: 93%}\n" +
                "        p.one {color: yellow ; align-content: center}\n" +
                "        textarea {background-color: lightyellow ; }\n" +
                "    </style>\n" +
                "</head>";
        htmlResponse += "\n" +
                "<body>\n" +
                "<h1>Modification</h1>\n" +
                "<form>\n" +
                "    <div class=\"one\">\n" +
                "        <p>\n" +
                "        <div class=\"two\">\n" +
                "            <p class=\"one\">\n" +
                "The Legal customer's informations has modified"+
                "            </p>\n" +

                "            </p>\n" +
                "        </div>\n" +
                "        </p>\n" +
                "    </div>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>";
        writer.println(htmlResponse);
    }
}
