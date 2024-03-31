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

    public boolean addDependent(Customer dependent) {
        if (!dependent.equals(this)) {
            dependentList.add(dependent);
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Claim claim) {
        return claimList.add(claim);
    }

    @Override
    public boolean update(String claimID) {
        return false;
    }

    @Override
    public void delete(String claimID) {
        Claim claim = getOne(claimID);
        if (claim != null) {
            claimList.remove(claim);
        }
    }

    @Override
    public Claim getOne(String claimID) {
        for (Claim claim:claimList) {
            if (claim.getClaimID().equals(claimID)) {
                return claim;
            }
        }
        return null;
    }

    @Override
    public Set<Claim> getAll() {
        return null;
    }
}

