import java.util.ArrayList;
import java.util.List;

/*
 @author <Pham Thanh The - S3981133>
*/

public class PolicyHolder extends Customer implements DependentList {
    private String policyOwner;
    private List<Dependent> dependentList;

    public PolicyHolder() {
        super();
        this.policyOwner = "default";
        claimList = new ArrayList<Claim>();
        dependentList = new ArrayList<Dependent>();
    }

    public PolicyHolder(String customerID, String fullName, String policyOwner, InsuranceCard insuranceCard) {
        super(customerID, fullName, insuranceCard);
        this.policyOwner = policyOwner;
        dependentList = new ArrayList<Dependent>();
        claimList = new ArrayList<Claim>();
    }

    public String getPolicyOwner() { return policyOwner; }
    public void setPolicyOwner(String policyOwner) { this.policyOwner = policyOwner; }
    public List<Dependent> getDependentList() { return dependentList; }
    public void setDependentList(List<Dependent> dependentList) { this.dependentList = dependentList; }

    public String toString() {
        return  "\nPolicy Holder:\n" +
                "Policy Holder ID: " + getCustomerID() + "\n" +
                "FullName: " + getFullName() + "\n" +
                "InsuranceCard: " + getInsuranceCard().getInsuranceCardID() + "\n" +
                "Policy Owner: " + policyOwner + "\n" +
                "ClaimList: " + "\n" + getClaimList() + "\n" +
                "Dependent List: " + "\n" + dependentList;
    }

    @Override
    public void addDependent(Dependent dependent) {
        if (!(dependentList.contains(dependent)) && dependent.getPolicyHolderName().equals(this.getFullName())) {
            dependentList.add(dependent);
        } else {
            System.out.println("Dependent is already on the list!");
        }
    }

    @Override
    public void deleteDependent(Dependent dependent) {
        if (dependentList.contains(dependent)) {
            dependentList.remove(dependent);
        } else {
            System.out.println("Dependent is not found on the list!");
        }
    }

    @Override
    public Dependent getOneDependent(String dependentID) {
        for (Dependent dependent:dependentList) {
            if (dependent.getCustomerID().equals(dependentID)) {
                return dependent;
            }
        }
        return null;
    }

    @Override
    public List<Dependent> getAllDependents() {
        return dependentList;
    }
}
