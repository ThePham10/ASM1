import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fileWriting {
    public static void main(String[] args) throws IOException {
        List<PolicyHolder> policyHolders = new ArrayList<>();
        List<Claim> claims = new ArrayList<>();

        String filePath = "PolicyHolder.txt";
        File file = new File(filePath);

        String customerID, fullName, policyOwner, insuranceCardID, expirationDate;
        Scanner scanInfo = new Scanner(System.in);

        PolicyHolder pH1 = new PolicyHolder();
        pH1 = new PolicyHolder("C0000000001", "JANG WONYOUNG", "STARSHIP ENT", new InsuranceCard("1111111101", "STARSHIP ENT", "2025/04/04", pH1));
        PolicyHolder pH2 = new PolicyHolder();
        pH2 = new PolicyHolder("C0000000002", "LEE HYUNSEO", "STARSHIP ENT", new InsuranceCard("1111111102", "STARSHIP ENT", "2025/04/04", pH2));
        PolicyHolder pH3 = new PolicyHolder();
        pH3 = new PolicyHolder("C0000000003", "KIM MINJEONG", "SM ENT", new InsuranceCard("1111111103", "SM ENT", "2025/04/04", pH3));
        PolicyHolder pH4 = new PolicyHolder();
        pH4 = new PolicyHolder("C0000000004", "AERI UCHINAGA", "SM ENT", new InsuranceCard("1111111104", "SM ENT", "2025/04/04", pH4));
        PolicyHolder pH5 = new PolicyHolder();
        pH5 = new PolicyHolder("C0000000005", "KHONG TU QUYNH", "LUNAS", new InsuranceCard("1111111105", "LUNAS", "2025/04/04", pH5));
        PolicyHolder pH6 = new PolicyHolder();
        pH6 = new PolicyHolder("C0000000006", "TRANG PHAP", "LUNAS", new InsuranceCard("1111111106", "LUNAS", "2025/04/04", pH6));
        PolicyHolder pH7 = new PolicyHolder();
        pH7 = new PolicyHolder("C0000000007", "NINH DUONG LAN NGOC", "LUNAS", new InsuranceCard("1111111107", "LUNAS", "2025/04/04", pH7));
        PolicyHolder pH8 = new PolicyHolder();
        pH8 = new PolicyHolder("C0000000008", "HUYEN BABY", "LUNAS", new InsuranceCard("1111111108", "LUNAS", "2025/04/04", pH8));
        PolicyHolder pH9 = new PolicyHolder();
        pH9 = new PolicyHolder("C0000000009", "DIEP LAM ANH", "LUNAS", new InsuranceCard("1111111109", "LUNAS", "2025/04/04", pH9));
        PolicyHolder pH10 = new PolicyHolder();
        pH10 = new PolicyHolder("C0000000010", "SHINYU", "PLEDIS ENT", new InsuranceCard("1111111110", "PLEDIS ENT", "2025/04/04", pH10));
        PolicyHolder pH11 = new PolicyHolder();
        pH11 = new PolicyHolder("C0000000011", "LEE JENO", "SM ENT", new InsuranceCard("1111111111", "SM ENT", "2025/04/04", pH11));
        PolicyHolder pH12 = new PolicyHolder();
        pH12 = new PolicyHolder("C0000000012", "NA JAEMIN", "SM ENT", new InsuranceCard("1111111112", "SM ENT", "2025/04/04", pH12));
        PolicyHolder pH13 = new PolicyHolder();
        pH13 = new PolicyHolder("C0000000013", "MONO", "MTP ENT", new InsuranceCard("1111111113", "MTP ENT", "2025/04/04", pH13));
        PolicyHolder pH14 = new PolicyHolder();
        pH14 = new PolicyHolder("C0000000014", "SON TUNG MTP", "MTP ENT", new InsuranceCard("1111111114", "MTP ENT", "2025/04/04", pH14));
        PolicyHolder pH15 = new PolicyHolder();
        pH15 = new PolicyHolder("C0000000015", "KAY TRAN", "MTP ENT", new InsuranceCard("1111111115", "MTP ENT", "2025/04/04", pH15));

        Claim claim1pH1 = new Claim("F1000000001", "1111111101", 65.99, "Done", "2024/04/06", "2024/04/06", new ReceiverBankingInfo("VISA", "JANG WONYOUNG", "1515152323"), pH1);
        Claim claim2pH1 = new Claim("F1000000002", "1111111101", 66.99, "Processing", "2024/04/06", "2024/04/06", new ReceiverBankingInfo("Shinhan Bank", "JANG WONYOUNG", "1515152222"), pH1);
        Claim claim1pH5 = new Claim("F5000000001", "1111111105", 70.88, "New", "2024/04/06", "2024/04/06", new ReceiverBankingInfo("VISA", "KHONG TU QUYNH", "9819191919"), pH5);
        Claim claim2pH5 = new Claim("F5000000002", "1111111105", 26.46, "New", "2024/04/06", "2024/04/06", new ReceiverBankingInfo("SACOMBANK", "KHONG TU QUYNH", "2345673456"), pH5);
        Claim claim3pH5 = new Claim("F5000000003", "1111111105", 43.00, "Processing", "2024/04/06", "2024/04/06", new ReceiverBankingInfo("EXIMBANK", "KHONG TU QUYNH", "2345673456"), pH5);
        pH1.add(claim1pH1); claims.add(claim1pH1);

        policyHolders.add(pH1); policyHolders.add(pH2); policyHolders.add(pH3); policyHolders.add(pH4); policyHolders.add(pH5);
        policyHolders.add(pH6); policyHolders.add(pH7); policyHolders.add(pH8); policyHolders.add(pH9); policyHolders.add(pH10);
        policyHolders.add(pH11); policyHolders.add(pH12); policyHolders.add(pH13); policyHolders.add(pH14); policyHolders.add(pH15);

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
                    System.out.println("Policy Holders written to the file successfully.");
                } catch (IOException e) {
                    System.out.println("An error occurred while writing to the file.");
                    e.printStackTrace();
                }
                System.out.println("PolicyHolder.txt created successfully: " + file.getAbsolutePath());
            } else {
                System.out.println("PolicyHolder.txt already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating PolicyHolder.txt.");
            e.printStackTrace();
        }

        //pH1.add(new Claim("F0000000001", "1111111101", 65.99, "Done", "2024/04/06", "2024/04/06", new ReceiverBankingInfo("VISA", "JANG WONYOUNG", "1515152323")));
        String filePath1 = "Claim.txt";
        File file1 = new File(filePath1);
        String claimID, cardID, status, examDate, claimDate, bankName, fullNameInBank, bankNumber;

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
                    System.out.println("Claims written to the file successfully.");
                } catch (IOException e) {
                    System.out.println("An error occurred while writing to the Claim.txt.");
                    e.printStackTrace();
                }
                System.out.println("Claim.txt created successfully: " + file.getAbsolutePath());
            } else {
                System.out.println("Claim.txt already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while Claim.txt.");
            e.printStackTrace();
        }

/*        ReceiverBankingInfo bankingInfo1pH1 = new ReceiverBankingInfo();
        Claim claim1pH1 = new Claim();
        Generator.createClaim(claim1pH1, pH1, bankingInfo1pH1);
        pH1.add(claim1pH1);
        System.out.println(pH1);

        Dependent dPd1 = new Dependent();
        Generator.createDependent(dPd1, pH1);
        pH1.addDependent(dPd1);
        System.out.println(pH1);

        pH1.deleteDependent(dPd1);
        System.out.println(pH1);*/

/*        ReceiverBankingInfo bankingInfo2pH1 = new ReceiverBankingInfo();
        Claim claim2pH1 = new Claim();
        ClaimGenerator.createClaim(claim2pH1, pH1, bankingInfo2pH1);
        pH1.add(claim2pH1);
        System.out.println(pH1);*/

/*        pH1.update(claim1pH1);
        pH1.update(claim1pH1);
        pH1.update(claim1pH1);
        System.out.println(pH1);*/
        //System.out.println(pH1.getOne(claim1pH1.getClaimID()));

/*        pH1.delete(claim1pH1);
        System.out.println(pH1);*/
    }
}
