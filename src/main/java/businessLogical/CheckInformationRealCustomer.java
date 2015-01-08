package businessLogical;

/**
 * Created by Marzieh on 12/25/2014.
 * In this class check input information format for real customer.
 * In checkInformation method we invoke checkDateFormat and checkInt in typeChecker class.
 */
public class CheckInformationRealCustomer {
    TypeChecker typeChecker = new TypeChecker();
    public boolean checkInformation(String birthDate, String nationalId){
        if(typeChecker.checkInt(nationalId))
            if(typeChecker.checkDateFormat(birthDate))
                return  true;
            else
                return  false;
        return true;
    }
}
