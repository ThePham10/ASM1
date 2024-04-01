import java.text.SimpleDateFormat;
import java.util.*;

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

    public String generateCustomerID() {
        StringBuilder stringBuilder2 = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            int randomNumber = random.nextInt(10);
            stringBuilder2.append(randomNumber);
        }
        String randomString = stringBuilder2.toString();
        return "F" + randomString;
    }

    public InsuranceCard generateInsuranceCard (InsuranceCard insuranceCard) {
        String insuranceCardID = (String) insuranceCard.generateCardID();
        insuranceCard.setInsuranceCardID(insuranceCardID);
        String policyOwner = "RMIT";
        insuranceCard.setPolicyOwner(policyOwner);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        Date expirationDate1 = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String expirationDate2 = dateFormat.format(expirationDate1);
        insuranceCard.setExpirationDate(expirationDate2);

        return new InsuranceCard(insuranceCardID, this, policyOwner, expirationDate2);
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
                "customerID = '" + customerID + '\'' +
                ", fullName = '" + fullName + '\'' +
                ", insuranceCard = " + insuranceCard.getInsuranceCardID() +
                ", claimList = " + claimList +
                ", dependentList = " + dependentList +
                '}';
    }
}

