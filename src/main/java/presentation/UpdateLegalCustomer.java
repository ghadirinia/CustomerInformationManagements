package presentation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Dotin school 2 on 1/4/2015.
 * In this class servlet has utilized as middle layer to receive data from a html page and do process on them and produce new information and dynamic html page.
 * In this class we get Economic Id and go to a dynamic html page to change Legal Customer's Information by utilizing  HttpServletRequest and send them to another servlet.
 */
//@WebServlet("/UpdateLegalCustomer")
public class UpdateLegalCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException{
        String economicId = request.getParameter("economicId");
        PrintWriter writer = response.getWriter();
        String htmlResponse = "<!DOCTYPE html>\n" +
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
                "</head>\n" +
                "<body>\n" +
                "<h1>Registration</h1>\n" +
                "<form method=\"post\" action=\"ModificationLegalCustomer\">\n" +
                "<input type=\"hidden\" name=\"economicId\" value=\""+economicId+"\">\n"+
                "<div class=\"one\">\n" +
                "    <h3>Registration a \"Legal customer\"</h3>\n" +
                "    <p>\n" +
                "     <div class=\"two\">\n" +
                "         <p class=\"one\">\n" +
                "             Name:  <input cols=\"50\" rows=\"1\" name=\"name\"/>\n" +
                "         </p>\n" +
                "        <p class=\"one\">\n" +
                "            Registration Date:  <input cols=\"50\" rows=\"1\" name=\"registerDate\"/>\n" +
                "        </p>\n" +
                "        <p class=\"one\">\n" +
                "            Economic Code:  <input cols=\"50\" rows=\"1\" name=\"customerId\"/>\n" +
                "        </p>\n" +
                "        <p class=\"one\">\n" +
                "            <button cols=\"50\" rows=\"1\">Sign Up!</button>\n" +
                "        </p>\n" +
                "     </div>\n" +
                "    </p>\n" +
                "</div>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>" ;
        writer.println(htmlResponse);
    }
}
