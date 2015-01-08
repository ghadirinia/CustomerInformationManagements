package businessLogical;

import dataBaseAccess.DataBaseExplorer;
import dataBaseAccess.LegalCustomer;
import dataBaseAccess.RealCustomer;

/**
 * Created by Marzieh on 12/25/2014.
 * In this class we produce legal customer and real customer.
 * In  produceLegalCustomer() method we produce customer code for legal customer.
 * In  produceRealCustomer() method we produce customer code for real customer.Class newCustomerIdProducer object create and invoke produceLegalCustomer and produceRealCustomer to
 * produce customers' codes.
 */
public class CustomerProcessor {
    public LegalCustomer legalCustomer;
    public RealCustomer realCustomer;

    public void produceLegalCustomer(String name,String registerDate,String economicId) throws Exception{
        //LegalCustomer legalCustomer = null;
        TypeChecker typeChecker = new TypeChecker();
        CheckInformationLegalCustomer checkInformationLegalCustomer = new CheckInformationLegalCustomer();
        NewCustomerIdProducer newCustomerIdProducer = new NewCustomerIdProducer();
        DataBaseExplorer dataBaseExplorer = new DataBaseExplorer();
        if(checkInformationLegalCustomer.checkInformation(registerDate, economicId))
        {
            if(!dataBaseExplorer.searchLegalCustomer("",Integer.parseInt(economicId),0)) {
                legalCustomer = new LegalCustomer(typeChecker.convertToInt(economicId), name, registerDate, newCustomerIdProducer.produceLegalCustomer());
            }else{
                System.out.println("economicId is duplicated.");
                throw new DuplicateNationalId();}
        }else{
            System.out.println("Input values are incorrect");
            throw new InputValuesIncorrect();
        }

    }
    public void produceRealCustomer(String first, String last, String fatherName, String birthDate, String nationalId) throws Exception{
        //RealCustomer realCustomer = null;
        TypeChecker typeChecker = new TypeChecker();
        CheckInformationRealCustomer checkInformationRealCustomer = new CheckInformationRealCustomer();
        NewCustomerIdProducer newCustomerIdProducer = new NewCustomerIdProducer();
        DataBaseExplorer dataBaseExplorer = new DataBaseExplorer();
        if(checkInformationRealCustomer.checkInformation(birthDate,nationalId))
        {
            if(!dataBaseExplorer.searchRealCustomer("","",Integer.parseInt(nationalId),0)) {
                realCustomer = new RealCustomer(typeChecker.convertToInt(nationalId), first, last, fatherName, birthDate, newCustomerIdProducer.produceRealCustomer());
            }else{
                System.out.println("economicId is duplicated.");
                throw new DuplicateEconomicId();}
        }else{
            System.out.println("Input values are incorrect");
            throw new InputValuesIncorrect();
        }

    }
}
