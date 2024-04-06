import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class fileReading {
    public static void main(String[] args) throws IOException {
        List<PolicyHolder> policyHolders = new ArrayList<>();
        List<Claim> claims = new ArrayList<>();
        List<Dependent> dependents = new ArrayList<>();

        String filePath = "PolicyHolder.txt";
        String customerID, fullName, policyOwner, insuranceCardID, expirationDate, each_line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((each_line = reader.readLine()) != null) {
                StringTokenizer inReader = new StringTokenizer(each_line, "\t");
                if (inReader.countTokens() == 5) {
                    customerID = inReader.nextToken();
                    fullName = inReader.nextToken();
                    policyOwner = inReader.nextToken();
                    insuranceCardID = inReader.nextToken();
                    expirationDate = inReader.nextToken();

                    InsuranceCard insuranceCard = new InsuranceCard(insuranceCardID, policyOwner, expirationDate, null);
                    PolicyHolder pH = new PolicyHolder(customerID, fullName, policyOwner, insuranceCard);
                    policyHolders.add(pH);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        String filePath1 = "Claim.txt";
        String claimID, cardID, status, examDate, claimDate, bankName, fullNameInBank, bankNumber, each_line1;
        double amount;

        try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath1))) {
            while ((each_line1 = reader1.readLine()) != null) {
                StringTokenizer inReader1 = new StringTokenizer(each_line1, "\t");
                if (inReader1.countTokens() == 9) {
                    claimID = inReader1.nextToken();
                    cardID = inReader1.nextToken();
                    amount = Double.parseDouble(inReader1.nextToken());
                    status = inReader1.nextToken();
                    examDate = inReader1.nextToken();
                    claimDate = inReader1.nextToken();
                    bankName = inReader1.nextToken();
                    fullNameInBank = inReader1.nextToken();
                    bankNumber = inReader1.nextToken();

                    Claim claim = new Claim(claimID, cardID, amount, status, examDate, claimDate, new ReceiverBankingInfo(bankName, fullNameInBank, bankNumber), null);
                    claims.add(claim);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
       for (PolicyHolder aPolicyHolder:policyHolders) {
           for (Claim aClaim:claims) {
               if ((aClaim.getCardID().equals(aPolicyHolder.getInsuranceCard().getInsuranceCardID())) &&
               aClaim.getBankingInfo().getName().equals(aPolicyHolder.getFullName())) {
                   aClaim.setInsuredPerson(aPolicyHolder);
                   aPolicyHolder.add(aClaim);
               }
           }
       }

        for (PolicyHolder ApolicyHolder:policyHolders) {
            System.out.println(ApolicyHolder.toString());
        }

    }
}
