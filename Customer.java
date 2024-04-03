import java.text.SimpleDateFormat;
import java.util.*;

public class Customer implements ClaimProcessManager{
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
    public void setCustomerID(String customerID) { this.customerID = customerID; }

    public void setFullName(String fullName) { this.fullName = fullName; }

    public void setInsuranceCard(InsuranceCard insuranceCard) { this.insuranceCard = insuranceCard; }

    @Override
    public boolean addClaim(Claim claim) {
        if (checkClaimID(claim.getClaimID())) {
            return false;
        }
        claimList.add(claim);
        return true;
    }

    public boolean checkClaimID(String claimID1) {
        for (Claim claim:claimList) {
            if (claimID1.equals(claim.getClaimID())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean updateClaim(String claimID) {
        return false;
    }

    @Override
    public void deleteClaim(String claimID) {
        Claim claim = getOneClaim(claimID);
        if (claim != null) {
            this.claimList.remove(claim);
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
        return "Customer:\n" +
                "CustomerID: " + customerID + "\n" +
                "FullName: " + fullName + "\n" +
                "InsuranceCard: " + insuranceCard.getInsuranceCardID() + "\n" +
                "ClaimList: " + "\n" + claimList + "\n" ;
    }
}

