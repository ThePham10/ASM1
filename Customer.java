import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerID;
    private String fullName;
    private InsuranceCard insuranceCard;
    private List<Claim> claimList;

    public Customer() {
        this.customerID = "default";
        this.fullName = "default";
        this.insuranceCard = null;
        claimList = new ArrayList<Claim>();
    }

    public Customer(String customerID, String fullName, InsuranceCard insuranceCard) {
        this.customerID = customerID;
        this.fullName = fullName;
        this.insuranceCard = insuranceCard;
        claimList = new ArrayList<Claim>();
    }

    public String getCustomerID() { return customerID; }
    public String getFullName() { return fullName; }
    public InsuranceCard getInsuranceCard() { return insuranceCard; }
    public List<Claim> getClaimList() { return claimList; }
}

