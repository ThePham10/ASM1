import java.util.ArrayList;

public class Dependent extends Customer {
    private String policyHolderName;
    private PolicyHolder policyHolder;

    public Dependent() {
        super();
        this.policyHolderName = "default";
        this.policyHolder = null;
        claimList = new ArrayList<Claim>();
    }

    public Dependent(String customerID, String fullName, InsuranceCard insuranceCard,
                     String policyHolderName, PolicyHolder policyHolder) {
        super(customerID, fullName, insuranceCard);
        this.policyHolderName = policyHolderName;
        this.policyHolder = policyHolder;
        claimList = new ArrayList<Claim>();
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public void setPolicyHolderName(String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }

    public PolicyHolder getPolicyHolder() { return policyHolder; }

    public void setPolicyHolder(PolicyHolder policyHolder) { this.policyHolder = policyHolder; }

    public String toString() {
        return  "\nDependent ID: " + getCustomerID() +
                ", FullName: " + getFullName() +
                ", InsuranceCard: " + getInsuranceCard().getInsuranceCardID() +
                ", Policy Holder: " + policyHolder.getFullName() +
                ", ClaimList: " + "\n" + getClaimList() + "\n" ;
    }
}
