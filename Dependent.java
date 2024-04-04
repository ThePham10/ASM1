import java.text.SimpleDateFormat;
import java.util.*;

public class Dependent extends Customer {
    private PolicyHolder policyHolder;

    public Dependent() {
        super();
        this.policyHolder = null;
        claimList = new ArrayList<Claim>();
    }

    public Dependent(String customerID, String fullName, InsuranceCard insuranceCard,
                        PolicyHolder policyHolder) {
        super(customerID, fullName, insuranceCard);
        this.policyHolder = policyHolder;
        claimList = new ArrayList<Claim>();
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
