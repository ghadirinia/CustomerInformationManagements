package dataBaseAccess;

import java.io.IOException;

/**
 * Created by Dotin school 2 on 12/30/2014.
 */
public class Main {
    public static void main(String arg[]) throws IOException {

/*        NewCustomerIdProducer newCustomerIdProducer = new NewCustomerIdProducer();
        newCustomerIdProducer.produceRealCustomer();
        if (true) {
            return;
        }*/
        DataBaseDropper dataBaseDropper = new DataBaseDropper();
        dataBaseDropper.dropDataBase();
        DataBaseCreator dataBaseCreator = new DataBaseCreator();
        dataBaseCreator.createDataBase();
        dataBaseCreator.createRegistrationTableForLegalCustomer();
        dataBaseCreator.createRegistrationTableForRealCustomer();
    }
}
