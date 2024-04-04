import java.util.*;

public class PolicyHolder extends Customer implements DependentList, ClaimProcessManager {
    private String policyOwner;
    private List<Dependent> dependentList;

    public PolicyHolder() {
        super();
        this.policyOwner = "default";
        claimList = new ArrayList<Claim>();
        dependentList = new ArrayList<Dependent>();
    }

    public PolicyHolder(String customerID, String fullName, InsuranceCard insuranceCard,
                        String policyOwner) {
        super(customerID, fullName, insuranceCard);
        this.policyOwner = policyOwner;
        dependentList = new ArrayList<Dependent>();
        claimList = new ArrayList<Claim>();
    }

    public String getPolicyOwner() { return policyOwner; }
    public void setPolicyOwner(String policyOwner) { this.policyOwner = policyOwner; }
    public List<Dependent> getDependentList() { return dependentList; }
    public void setDependentList(List<Dependent> dependentList) { this.dependentList = dependentList; }

    public boolean addDependent(Dependent dependent) {
        if (!(dependentList.contains(dependent))) {
            dependentList.add(dependent);
            return true;
        }
        return false;
    }

    @Override
    public void deleteDependent(String dependentID) {
        Dependent dependent = getOneDependent(dependentID);
        if (dependent != null) {
            this.dependentList.remove(dependent);
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

    public String toString() {
        return  "Policy Holder:\n" +
                "Policy Holder ID: " + getCustomerID() + "\n" +
                "FullName: " + getFullName() + "\n" +
                "InsuranceCard: " + getInsuranceCard().getInsuranceCardID() + "\n" +
                "Policy Owner: " + policyOwner + "\n" +
                "ClaimList: " + "\n" + getAllClaims() + "\n" +
                "Dependent List: " + "\n" + dependentList + "\n";
    }
}
