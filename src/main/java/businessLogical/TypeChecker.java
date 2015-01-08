package businessLogical;



/**
 * Created by Marzieh on 12/25/2014.
 * In this class we check input information format.
 */
public class TypeChecker {
    public boolean checkInt(String value){
        if(value.isEmpty()) return false;
        for(int i = 0; i < value.length(); i++) {
            if(i == 0 && value.charAt(i) == '-') {
                if(value.length() == 1) return false;
                else continue;
            }
            if(Character.digit(value.charAt(i),10) < 0) return false;
        }
        return true;
    }
    public int convertToInt(String value){
        return Integer.parseInt(value);
    }

    public boolean checkDateFormat(String stringDate){
        String[] date = stringDate.split("/");
        if(date.length==3)
            if(date[0].length()==4)
                if(date[1].length()==2)
                    if(date[2].length()==2)
                        if(checkInt(date[0]) && checkInt(date[1]) && checkInt(date[2]))
                            return true;
                else
                    return false;
            else
                return false;
        else
            return false;
        return false;
    }

}
