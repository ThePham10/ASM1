import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class fileWriting {
    public static void writePolicyHolderIntoFile(List<PolicyHolder> policyHolders) throws IOException {
        String filePath = "PolicyHolder.txt";
        File file = new File(filePath);
        try {
            // Create the file
            boolean isPolicyHolderTXTCreated = file.createNewFile();

            if (isPolicyHolderTXTCreated) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    for (PolicyHolder policyHolder : policyHolders) {
                        writer.write(policyHolder.getCustomerID() + "\t" +
                                policyHolder.getFullName() + "\t" +
                                policyHolder.getPolicyOwner() + "\t" +
                                policyHolder.getInsuranceCard().getInsuranceCardID() + "\t" +
                                policyHolder.getInsuranceCard().getExpirationDate());
                        writer.newLine();
                    }
                    System.out.println("Policy Holders are written to PolicyHolder.txt successfully.");
                } catch (IOException e) {
                    System.out.println("There is an error while writing to PolicyHolder.txt.");
                    e.printStackTrace();
                }
                System.out.println("PolicyHolder.txt is opened/created successfully.");
            } else {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    for (PolicyHolder policyHolder : policyHolders) {
                        writer.write(policyHolder.getCustomerID() + "\t" +
                                policyHolder.getFullName() + "\t" +
                                policyHolder.getPolicyOwner() + "\t" +
                                policyHolder.getInsuranceCard().getInsuranceCardID() + "\t" +
                                policyHolder.getInsuranceCard().getExpirationDate());
                        writer.newLine();
                    }
                    System.out.println("Policy Holders written to PolicyHolder.txt successfully.");
                } catch (IOException e) {
                    System.out.println("There is an error while writing to PolicyHolder.txt.");
                    e.printStackTrace();
                }
                System.out.println("PolicyHolder.txt is opened/created successfully.");
            }
        } catch (IOException e) {
            System.out.println("There is an error while opening/creating PolicyHolder.txt.");
            e.printStackTrace();
        }
    }

    public static void writeClaimIntoFile(List<Claim> claims) throws IOException {
        String filePath1 = "Claim.txt";
        File file1 = new File(filePath1);
        try {
            // Create the file
            boolean isClaimTXTCreated = file1.createNewFile();

            if (isClaimTXTCreated) {
                try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(filePath1))) {
                    for (Claim aClaim:claims) {
                        writer1.write(aClaim.getClaimID() + "\t" +
                                aClaim.getCardID() + "\t" +
                                aClaim.getAmount() + "\t" +
                                aClaim.getStatus() + "\t" +
                                aClaim.getExamDate() + "\t" +
                                aClaim.getClaimDate() + "\t" +
                                aClaim.getBankingInfo().getBank() + "\t"+
                                aClaim.getBankingInfo().getName() + "\t"+
                                aClaim.getBankingInfo().getBankNumber());
                        writer1.newLine();
                    }
                    System.out.println("Claims are written to Claim.txt successfully.");
                } catch (IOException e) {
                    System.out.println("There is an error while writing to Claim.txt.");
                    e.printStackTrace();
                }
                System.out.println("Claim.txt is opened/created successfully.");
            } else {
                try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(filePath1))) {
                    for (Claim aClaim:claims) {
                        writer1.write(aClaim.getClaimID() + "\t" +
                                aClaim.getCardID() + "\t" +
                                aClaim.getAmount() + "\t" +
                                aClaim.getStatus() + "\t" +
                                aClaim.getExamDate() + "\t" +
                                aClaim.getClaimDate() + "\t" +
                                aClaim.getBankingInfo().getBank() + "\t"+
                                aClaim.getBankingInfo().getName() + "\t"+
                                aClaim.getBankingInfo().getBankNumber());
                        writer1.newLine();
                    }
                    System.out.println("Claims are written to Claim.txt successfully.");
                } catch (IOException e) {
                    System.out.println("There is an error while writing to Claim.txt.");
                    e.printStackTrace();
                }
                System.out.println("Claim.txt is opened/created successfully.");
            }
        } catch (IOException e) {
            System.out.println("There is an error while opening/creating to Claim.txt.");
            e.printStackTrace();
        }
    }

    public static void writeDependentIntoFile(List<Dependent> dependents) throws IOException {
        String filePath2 = "Dependent.txt";
        File file2 = new File(filePath2);
        try {
            // Create the file
            boolean isDependentTXTCreated = file2.createNewFile();

            if (isDependentTXTCreated) {
                try (BufferedWriter writer2 = new BufferedWriter(new FileWriter(filePath2))) {
                    for (Dependent aDependent:dependents) {
                        writer2.write(aDependent.getCustomerID() + "\t" +
                                aDependent.getFullName() + "\t" +
                                aDependent.getPolicyHolder().getPolicyOwner() + "\t" +
                                aDependent.getInsuranceCard().getInsuranceCardID() + "\t" +
                                aDependent.getInsuranceCard().getExpirationDate() + "\t" +
                                aDependent.getPolicyHolderName());
                        writer2.newLine();
                    }
                    System.out.println("Dependents are written to Dependent.txt successfully.");
                } catch (IOException e) {
                    System.out.println("There is an error while writing to Dependent.txt.");
                    e.printStackTrace();
                }
                System.out.println("Dependent.txt is opened/created successfully.");
            } else {
                try (BufferedWriter writer2 = new BufferedWriter(new FileWriter(filePath2))) {
                    for (Dependent aDependent:dependents) {
                        writer2.write(aDependent.getCustomerID() + "\t" +
                                aDependent.getFullName() + "\t" +
                                aDependent.getPolicyHolder().getPolicyOwner() + "\t" +
                                aDependent.getInsuranceCard().getInsuranceCardID() + "\t" +
                                aDependent.getInsuranceCard().getExpirationDate() + "\t" +
                                aDependent.getPolicyHolderName());
                        writer2.newLine();
                    }
                    System.out.println("Dependents are written to Dependent.txt successfully.");
                } catch (IOException e) {
                    System.out.println("There is an error while writing to Dependent.txt.");
                    e.printStackTrace();
                }
                System.out.println("Dependent.txt is opened/created successfully.");
            }
        } catch (IOException e) {
            System.out.println("There is an error while opening/creating to Dependent.txt.");
            e.printStackTrace();
        }
    }
}
