package businessLogical;

/**
 * Created by Dotin school 2 on 1/1/2015.
 * This exception accure when national code that input for registration has duplicated.
 */
public class DuplicateNationalId extends Exception {
    String excDuplicateNationalId;
    public void setDuplicateNationalId(String excDuplicateNationalId){
        this.excDuplicateNationalId = excDuplicateNationalId;
    }
    public String getExcDuplicateNationalId(){
        return excDuplicateNationalId;
    }
}
