import java.text.SimpleDateFormat;
import java.util.*;

public class Customer implements ClaimDAO{
    private String customerID;
    private String fullName;
    private InsuranceCard insuranceCard;
    protected List<Claim> claimList;

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

    public List<Claim> getClaimList() { return claimList; }
    public String getCustomerID() { return customerID; }
    public String getFullName() { return fullName; }
    public InsuranceCard getInsuranceCard() { return insuranceCard; }
    public void setCustomerID(String customerID) { this.customerID = customerID; }

    public void setFullName(String fullName) { this.fullName = fullName; }

    public void setInsuranceCard(InsuranceCard insuranceCard) { this.insuranceCard = insuranceCard; }

    public InsuranceCard createInsuranceCard(InsuranceCard insuranceCard) {
        String insuranceCardID = "";
        while (insuranceCardID.length() != 10) {
            System.out.print("Create an insurance card's ID (10 number digits): ");
            Scanner scanID = new Scanner(System.in);
            insuranceCardID = scanID.next();
        }
        insuranceCard.setInsuranceCardID(insuranceCardID);

        String policyOwner;
        System.out.println("Enter your Policy Owner/or your Policy Holder's Owner: ");
        Scanner scanPolicyOwner = new Scanner(System.in);
        policyOwner = scanPolicyOwner.nextLine();
        insuranceCard.setPolicyOwner(policyOwner);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        Date expirationDate1 = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String expirationDate2 = dateFormat.format(expirationDate1);
        insuranceCard.setExpirationDate(expirationDate2);
        return new InsuranceCard(insuranceCardID, policyOwner, expirationDate2, this);
    }

    @Override
    public String toString() {
        return "Customer:\n" +
                "CustomerID: " + customerID + "\n" +
                "FullName: " + fullName + "\n" +
                "InsuranceCard: " + insuranceCard.getInsuranceCardID() + "\n" +
                "ClaimList: " + "\n" + claimList + "\n" ;
    }

    @Override
    public void update(Claim claim) {
        System.out.println("1.Amount | 2.Status | 3.Banking Information");
        System.out.print("Select the information you want to update (in number): ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter new amount for the claim: ");
                claim.setAmount(scanner.nextDouble());
                break;
            case 2:
                System.out.print("Enter new Status (New-Done-Processing) for the claim : ");
                claim.setStatus(scanner.next());
                break;
            case 3:
                System.out.println("1.Bank Name | 2.Bank Number");
                System.out.print("Select the information you want to update (in number): ");
                int choice2 = scanner.nextInt();
                if (choice2 == 1) {
                    System.out.println("Enter a new Bank's Name: ");
                    claim.setBankName(scanner.nextLine());
                }
                if (choice2 == 2) {
                    System.out.print("Enter a new Bank's Number: ");
                    claim.setBankNumber(scanner.next());
                }
                break;
        }
    }

    @Override
    public void add(Claim claim) {
        if (this.checkClaimID(claim.getClaimID())) {
            claimList.add(claim);
        } else {
            System.out.println("This claim is already added to the list.");
        }
    }

    @Override
    public void delete(Claim claim) {
        if (this.claimList.contains(claim)) {
            claimList.remove(claim);
        } else {
            System.out.println("This claim is not found on the list.");
        }
    }

    @Override
    public Claim getOne(String claimID) {
       for (Claim claim1:claimList) {
           if (claim1.getClaimID().equals(claimID)) {
               return claim1;
           }
       }
       return null;
    }

    @Override
    public List<Claim> getAll() {
        return claimList;
    }

    public boolean checkClaimID(String claimID) {
        for (Claim claim1:claimList) {
            if (claim1.getClaimID().equals(claimID)) {
                return false;
            }
        }
        return true;
    }
}

