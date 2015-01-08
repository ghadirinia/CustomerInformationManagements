package businessLogical;

/**
 * Created by Dotin school 2 on 1/1/2015.
 * This exception accure when economic code that input for registration has duplicated.
 */
public class DuplicateEconomicId extends Exception {
    String excDuplicateEconomicId;
    public void setDuplicateNationalId(String excDuplicateEconomicId){
        this.excDuplicateEconomicId = excDuplicateEconomicId;
    }
    public String getExcDuplicateEconomicId(){
        return excDuplicateEconomicId;
    }
}
