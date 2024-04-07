import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
 @author <Pham Thanh The - S3981133>
*/

public class Generator {

    public static Claim createClaim(Claim claim, Customer customer, ReceiverBankingInfo bankingInfo) {
        String claimID = "";
        while (claimID.length() != 11 && customer.checkClaimID(claimID)) {
            System.out.print("Create a claim's ID ('F' + 10 number digits): ");
            Scanner scanID = new Scanner(System.in);
            claimID = scanID.next();
            boolean checkedClaimID = customer.checkClaimID(claimID);
            while (!checkedClaimID) {
                System.out.print("Create a claim's ID ('F' + 10 number digits): ");
                claimID = scanID.next();
                checkedClaimID = customer.checkClaimID(claimID);
            }
        }
        claim.setClaimID(claimID);

        claim.setInsuredPerson(customer);

        String insuranceCardID = String.valueOf(customer.getInsuranceCard().getInsuranceCardID());
        claim.setCardID(insuranceCardID);

        System.out.print("Enter the amount for the claim: ");
        Scanner scanAmount = new Scanner(System.in);
        double amount = scanAmount.nextDouble();
        claim.setAmount(amount);

        String status = "New";
        claim.setStatus(status);

        System.out.print("Enter the Exam Date (yyyy/MM/dd) : ");
        Scanner scanExamDate = new Scanner(System.in);
        String examDate1 = scanAmount.next();
        claim.setExamDate(examDate1);

        String claimDate1 = generateDate();
        claim.setClaimDate(claimDate1);

        String documentList = claimID + "_" + customer.getFullName() + "_" +customer.getCustomerID() +".pdf";
        claim.setDocumentList(documentList);

        claim.setBankingInfo(bankingInfo);
        String customerName = customer.getFullName();
        claim.setNameInBank(customerName);

        System.out.println("Enter Bank's Name: ");
        Scanner scanBank = new Scanner(System.in);
        String bankName = scanBank.nextLine();
        claim.setBankName(bankName);

        String bankNumber = "";
        while (bankNumber.length() != 10) {
            System.out.print("Enter Bank's Number (10 number digits): ");
            Scanner scanBankNumber = new Scanner(System.in);
            bankNumber = scanBankNumber.next();
        }
        claim.setBankNumber(bankNumber);

        return new Claim(claimID, insuranceCardID, amount, status, examDate1, claimDate1, new ReceiverBankingInfo(bankName, customerName, bankNumber), documentList, customer);
    }

    public static String generateDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return (String) dateFormat.format(date);
    }

    public static String generateExpirationDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        Date expirationDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return (String) dateFormat.format(expirationDate);
    }

    public static PolicyHolder createPolicyHolder(PolicyHolder policyHolder) {
        InsuranceCard insuranceCard = new InsuranceCard();
        policyHolder.createInsuranceCard(insuranceCard);
        policyHolder.setInsuranceCard(insuranceCard);

        String customerID = "";
        while (customerID.length()!= 11) {
            System.out.print("Create a customer's ID ('C' + 10 number digits): ");
            Scanner scanID = new Scanner(System.in);
            customerID = scanID.next();
        }
        policyHolder.setCustomerID(customerID);

        String fullName;
        System.out.println("Enter customer's name: ");
        Scanner scanName = new Scanner(System.in);
        fullName = scanName.nextLine();
        policyHolder.setFullName(fullName);

        String policyOwner = policyHolder.getInsuranceCard().getPolicyOwner();
        policyHolder.setPolicyOwner(policyOwner);

        return new PolicyHolder(customerID, fullName,policyOwner, insuranceCard);
    }

    public static Dependent createDependent(Dependent dependent) {
        InsuranceCard insuranceCard = new InsuranceCard();
        dependent.createInsuranceCard(insuranceCard);
        dependent.setInsuranceCard(insuranceCard);

        String customerID = "";
        while (customerID.length()!= 11) {
            System.out.print("Create a customer's ID ('C' + 10 number digits): ");
            Scanner scanID = new Scanner(System.in);
            customerID = scanID.next();
        }
        dependent.setCustomerID(customerID);

        String fullName;
        System.out.println("Enter customer's name: ");
        Scanner scanName = new Scanner(System.in);
        fullName = scanName.nextLine();
        dependent.setFullName(fullName);

        String policyHolderName;
        System.out.println("Enter policy holder's name: ");
        Scanner scanpHName = new Scanner(System.in);
        policyHolderName = scanpHName.nextLine();
        dependent.setPolicyHolderName(policyHolderName);

        return new Dependent(customerID, fullName, insuranceCard, policyHolderName, null);
    }

    public static void setClaimToPolicyHolder(List<PolicyHolder> policyHolders, List<Claim> claims) {
        for (PolicyHolder aPolicyHolder:policyHolders) {
            for (Claim aClaim:claims) {
                if ((aClaim.getCardID().equals(aPolicyHolder.getInsuranceCard().getInsuranceCardID())) &&
                        aClaim.getBankingInfo().getName().equals(aPolicyHolder.getFullName())) {
                    aClaim.setInsuredPerson(aPolicyHolder);
                    aPolicyHolder.add(aClaim);
                }
            }
        }
    }

    public static void setClaimToDependent(List<Dependent> dependents, List<Claim> claims) {
        for (Dependent aDependent:dependents) {
            for (Claim aClaim:claims) {
                if ((aClaim.getCardID().equals(aDependent.getInsuranceCard().getInsuranceCardID())) &&
                        aClaim.getBankingInfo().getName().equals(aDependent.getFullName())) {
                    aClaim.setInsuredPerson(aDependent);
                    aDependent.add(aClaim);
                }
            }
        }
    }

    public static void setDependentToPolicyHolder(List<PolicyHolder> policyHolders, List<Dependent> dependents) {
        for (PolicyHolder aPolicyHolder:policyHolders) {
            for (Dependent aDependent:dependents) {
                if (aDependent.getPolicyHolderName().equals(aPolicyHolder.getFullName())) {
                    aDependent.setPolicyHolder(aPolicyHolder);
                    aPolicyHolder.addDependent(aDependent);
                }
            }
        }
    }
}
