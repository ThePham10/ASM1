import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

/*
 @author <Pham Thanh The - S3981133>
*/

public class fileReading {

    public static void readPolicyHolderFromFile(List<PolicyHolder> policyHolders) throws IOException {
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
            System.out.println("There is an error while reading PolicyHolder.txt.");
            e.printStackTrace();
        }
    }
    public static void readClaimFromFile(List<Claim> claims) throws IOException {
        String filePath1 = "Claim.txt";
        String claimID, cardID, status, examDate, claimDate, bankName, fullNameInBank, bankNumber, documentList, each_line1;
        double amount;

        try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath1))) {
            while ((each_line1 = reader1.readLine()) != null) {
                StringTokenizer inReader1 = new StringTokenizer(each_line1, "\t");
                if (inReader1.countTokens() == 10) {
                    claimID = inReader1.nextToken();
                    cardID = inReader1.nextToken();
                    amount = Double.parseDouble(inReader1.nextToken());
                    status = inReader1.nextToken();
                    examDate = inReader1.nextToken();
                    claimDate = inReader1.nextToken();
                    bankName = inReader1.nextToken();
                    fullNameInBank = inReader1.nextToken();
                    bankNumber = inReader1.nextToken();
                    documentList = inReader1.nextToken();

                    Claim claim = new Claim(claimID, cardID, amount, status, examDate, claimDate, new ReceiverBankingInfo(bankName, fullNameInBank, bankNumber), documentList, null);
                    claims.add(claim);
                }
            }
        } catch (IOException e) {
            System.out.println("There is an error while reading Claim.txt.");
            e.printStackTrace();
        }
    }
    public static void readDependentFromFile(List<Dependent> dependents) throws IOException {
        String filePath2 = "Dependent.txt";
        String customerID, fullName, policyOwner, insuranceCardID, expirationDate, policyHolderName, each_line2;

        try (BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))) {
            while ((each_line2 = reader2.readLine()) != null) {
                StringTokenizer inReader2 = new StringTokenizer(each_line2, "\t");
                if (inReader2.countTokens() == 6) {
                    customerID = inReader2.nextToken();
                    fullName = inReader2.nextToken();
                    policyOwner = inReader2.nextToken();
                    insuranceCardID = inReader2.nextToken();
                    expirationDate = inReader2.nextToken();
                    policyHolderName = inReader2.nextToken();

                    InsuranceCard insuranceCard = new InsuranceCard(insuranceCardID, policyOwner, expirationDate, null);
                    Dependent dP = new Dependent(customerID, fullName, insuranceCard, policyHolderName, null);
                    dependents.add(dP);
                }
            }
        } catch (IOException e) {
            System.out.println("There is an error while reading PolicyHolder.txt.");
            e.printStackTrace();
        }
    }
}
