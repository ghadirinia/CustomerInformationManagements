package businessLogical;

/**
 * Created by Marzieh on 12/25/2014.
 * In this class check input information format for legal customer.
 * In checkInformation method we invoke checkDateFormat and checkInt in typeChecker class.
 */
public class CheckInformationLegalCustomer {
    TypeChecker typeChecker = new TypeChecker();
    public boolean checkInformation(String registerDate, String economicId){
        if(typeChecker.checkDateFormat(registerDate))
            if(typeChecker.checkInt(economicId))
                return  true;
        else
            return  false;

        return true;
    }
}
