import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Dependent extends Customer {
    private PolicyHolder policyHolder;

    public Dependent() {
        super();
        this.policyHolder = null;
    }

    public Dependent(String customerID, String fullName, InsuranceCard insuranceCard,
                        PolicyHolder policyHolder) {
        super(customerID, fullName, insuranceCard);
        this.policyHolder = policyHolder;
    }

    public PolicyHolder getPolicyHolder() { return policyHolder; }

    public void setPolicyHolder(PolicyHolder policyHolder) { this.policyHolder = policyHolder; }

    public String toString() {
        return  "Dependent:\n" +
                "Dependent ID: " + getCustomerID() + "\n" +
                "FullName: " + getFullName() + "\n" +
                "InsuranceCard: " + getInsuranceCard().getInsuranceCardID() + "\n" +
                "Policy Holder: " + policyHolder + "\n" +
                "ClaimList: " + "\n" + getClaimList() + "\n" ;
    }
}
