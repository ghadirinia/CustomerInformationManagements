package dataBaseAccess;


/**
 * Created by Marzieh on 12/24/2014.
 * On type of Customers
 */
public class LegalCustomer {
    private int economicId;
    private String name;
    private String registerDate;
    private int customerId;

    public LegalCustomer(int economicId, String name, String registerDate,int customerId){
        this.economicId = economicId;
        this.name = name;
        this.registerDate = registerDate;
        this.customerId = customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setEconomicId(int economicId) {
        this.economicId = economicId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public int getEconomicId() {
        return economicId;
    }
}
