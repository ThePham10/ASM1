import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Customer implements ClaimProcessManager {
    private String customerID;
    private String fullName;
    private InsuranceCard insuranceCard;
    private List<Claim> claimList;
    private List<Customer> dependentList;

    public Customer() {
        this.customerID = "default";
        this.fullName = "default";
        this.insuranceCard = null;
        claimList = new ArrayList<Claim>();
        dependentList = new ArrayList<Customer>();
    }

    public Customer(String customerID, String fullName, InsuranceCard insuranceCard) {
        this.customerID = customerID;
        this.fullName = fullName;
        this.insuranceCard = insuranceCard;
        claimList = new ArrayList<Claim>();
        dependentList = new ArrayList<Customer>();
    }

    public String getCustomerID() { return customerID; }
    public String getFullName() { return fullName; }
    public InsuranceCard getInsuranceCard() { return insuranceCard; }
    public List<Claim> getClaimList() { return claimList; }
    public List<Customer> getDependentList() { return dependentList; }

    public void setCustomerID(String customerID) { this.customerID = customerID; }

    public void setFullName(String fullName) { this.fullName = fullName; }

    public void setInsuranceCard(InsuranceCard insuranceCard) { this.insuranceCard = insuranceCard; }

    public boolean addDependent(Customer dependent) {
        if (!(dependent.equals(this)) && !(dependentList.contains(dependent))) {
            dependentList.add(dependent);
            return true;
        }
        return false;
    }

    @Override
    public boolean addClaim(Claim claim) {
        return claimList.add(claim);
    }

    @Override
    public boolean updateClaim(String claimID) {
        return false;
    }

    @Override
    public void deleteClaim(String claimID) {
        Claim claim = getOneClaim(claimID);
        if (claim != null) {
            claimList.remove(claim);
        }
    }

    @Override
    public Claim getOneClaim(String claimID) {
        for (Claim claim:claimList) {
            if (claim.getClaimID().equals(claimID)) {
                return claim;
            }
        }
        return null;
    }

    @Override
    public List<Claim> getAllClaims() {
        return claimList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", fullName='" + fullName + '\'' +
                ", insuranceCard=" + insuranceCard +
                ", claimList=" + claimList +
                ", dependentList=" + dependentList +
                '}';
    }
}

