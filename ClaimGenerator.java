import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ClaimGenerator {

    public static Claim createClaim(Claim claim, Customer customer) {
        int ID;
        System.out.print("Create a claim's ID (10 digits): ");
        Scanner scanID = new Scanner(System.in);
        ID = scanID.nextInt();
        String claimID = (String) "F" + ID;
        claim.setClaimID(claimID);

        claim.setInsuredPerson(customer);

        String insuranceCardID = String.valueOf(customer.getInsuranceCard().getInsuranceCardID());
        claim.setCardID(insuranceCardID);

        double amount;
        System.out.print("Enter the amount for the claim: ");
        Scanner scanAmount = new Scanner(System.in);
        amount = scanAmount.nextDouble();
        claim.setAmount(amount);

        String status = "New";
        claim.setStatus(status);

        Date claimDate1 = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String claimDate2 = (String) dateFormat.format(claimDate1);
        claim.setClaimDate(claimDate2);

        return new Claim(claimID, customer, insuranceCardID, amount, status, claimDate2);
    }

    public static Customer createCustomer(Customer customer) {
        InsuranceCard insuranceCard1 = new InsuranceCard();
        customer.generateInsuranceCard(insuranceCard1);
        customer.setInsuranceCard(insuranceCard1);

        int ID;
        System.out.print("Create a customer's ID (10 digits): ");
        Scanner scanID = new Scanner(System.in);
        ID = scanID.nextInt();
        String customerID = (String) "C" + ID;
        customer.setCustomerID(customerID);

        String fullName;
        System.out.println("Enter customer's name: ");
        Scanner scanName = new Scanner(System.in);
        fullName = scanName.nextLine();
        customer.setFullName(fullName);

        return new Customer(customerID, fullName, insuranceCard1);
    }
}
