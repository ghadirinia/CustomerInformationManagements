package dataBaseAccess;

/**
 * Created by Marzieh on 12/24/2014.
 * one type of customers
 */
public class RealCustomer {
    private int nationalId;
    private String first;
    private String last;
    private String fatherName;
    private String birthDate;
    private int customerId;

    public RealCustomer(int nationalId , String first, String last , String fatherName , String birthDate,int customerId){
        this.nationalId = nationalId;
        this.first = first;
        this.last = last;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.customerId = customerId;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getNationalId() {
        return nationalId;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public void setCustomerId(int customerNumber) {
        this.customerId = customerNumber;
    }

    public int getCustomerId() {
        return customerId;
    }
}
