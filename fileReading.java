import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class fileReading {
    public static void main(String[] args) throws IOException {
        List<PolicyHolder> policyHolders = new ArrayList<>();
        List<InsuranceCard> insuranceCards = new ArrayList<>();

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

        for (PolicyHolder ApolicyHolder:policyHolders) {
            System.out.println(ApolicyHolder.toString());
        }
    }
}
