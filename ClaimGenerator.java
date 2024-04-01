import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ClaimGenerator {

    public Claim createClaim(Claim claim, Customer customer, InsuranceCard insuranceCard) {
        String claimID = (String) claim.generateClaimID();
        claim.setClaimID(claimID);

        String insuranceCardID = String.valueOf(customer.getInsuranceCard().getInsuranceCardID());
        claim.setCardID(insuranceCardID);

        double amount;
        System.out.print("Enter the amount for the claim: ");
        Scanner scanAmount = new Scanner(System.in);
        amount = scanAmount.nextDouble();
        claim.setAmount(amount);

        String status = "New";
        claim.setStatus(status);

        Date examDate1 = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String examDate2 = (String) dateFormat.format(examDate1);
        claim.setClaimDate(examDate2);

        return new Claim(claimID, customer, insuranceCardID, amount, status, examDate2);
    }

    public static Customer createCustomer(Customer customer) {
        InsuranceCard insuranceCard1 = new InsuranceCard();
        customer.generateInsuranceCard(insuranceCard1);
        customer.setInsuranceCard(insuranceCard1);

        String customerID = customer.generateCustomerID();
        customer.setCustomerID(customerID);

        String fullName;
        System.out.println("Enter customer's name: ");
        Scanner scanName = new Scanner(System.in);
        fullName = scanName.nextLine();
        customer.setFullName(fullName);

        return new Customer(customerID, fullName, insuranceCard1);
    }
}
