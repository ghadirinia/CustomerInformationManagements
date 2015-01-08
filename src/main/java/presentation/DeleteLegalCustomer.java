package presentation;

import dataBaseAccess.DataBaseDropper;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Dotin school 2 on 1/3/2015.
 * In this class servlet has utilized as middle layer to receive data from a html page and do process on them and produce new information and dynamic html page.
 * In this class we delete a legal Customer and get Economic Id from from HTTPServletRequest.
 */
//@WebServlet("/DeleteLegalCustomer")
public class DeleteLegalCustomer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException{
        String economicId = request.getParameter("economicId");
        DataBaseDropper dataBaseDropper=new DataBaseDropper();
        PrintWriter writer = response.getWriter();
        try{
            dataBaseDropper.deleteRecordFromLegalCustomer(economicId);
        }catch(Exception e){
            e.printStackTrace();
        }
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
        htmlResponse +="<p><h3>This customer with economicId "+economicId+" has been deleted.</h3></p>";
        htmlResponse +="</div>";
        htmlResponse +="</body>";
        htmlResponse +="</html>";
        writer.println(htmlResponse);
    }
}
