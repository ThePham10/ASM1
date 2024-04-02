import java.text.SimpleDateFormat;
import java.util.*;

public class Customer implements ClaimProcessManager, DependentList {
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
    public void deleteDependent(String customerID) {
        Customer dependent = getOneDependent(customerID);
        if (dependent != null) {
            this.dependentList.remove(dependent);
        }
    }

    @Override
    public Customer getOneDependent(String dependentID) {
        for (Customer dependent:dependentList) {
            if (dependent.getCustomerID().equals(dependentID)) {
                return dependent;
            }
        }
        return null;
    }

    @Override
    public List<Customer> getAllDependents() {
        return dependentList;
    }

    public InsuranceCard generateInsuranceCard (InsuranceCard insuranceCard) {
        String insuranceCardID = "";
        while (insuranceCardID.length() != 10) {
            System.out.print("Create an insurance card's ID (10 number digits): ");
            Scanner scanID = new Scanner(System.in);
            insuranceCardID = scanID.next();
        }
        insuranceCard.setInsuranceCardID(insuranceCardID);

        String policyOwner = "RMIT";
        insuranceCard.setPolicyOwner(policyOwner);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        Date expirationDate1 = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String expirationDate2 = dateFormat.format(expirationDate1);
        insuranceCard.setExpirationDate(expirationDate2);
        return new InsuranceCard(insuranceCardID, this, policyOwner, expirationDate2);
    }

    @Override
    public boolean addClaim(Claim claim) {
        return claimList.add(claim);
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
                "ClaimList: " + "\n" + claimList + "\n" +
                "DependentList: " + dependentList + "\n";
    }
}

