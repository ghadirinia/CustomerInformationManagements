package businessLogical;

import dataBaseAccess.DataBaseExplorer;

/**
 * Created by Marzieh on 12/25/2014.
 * In this class we read customer  codes from database and produce new customer code for real and legal customer.
 * These codes produced serially.
 */
public class NewCustomerIdProducer {

    public int produceRealCustomer(){
        int customerId = 0;
        DataBaseExplorer dataBaseExplorer= new DataBaseExplorer();
        try {
            customerId = dataBaseExplorer.returnRealCustomerNumber();
        }catch(Exception e){
            e.printStackTrace();
        }
        return customerId;
    }
    public int produceLegalCustomer(){
        int customerId = 0;
        DataBaseExplorer dataBaseExplorer= new DataBaseExplorer();
        try {
            customerId = dataBaseExplorer.returnLegalCustomerNumber();
        }catch(Exception e){
            e.printStackTrace();
        }
        return customerId;
    }
}
