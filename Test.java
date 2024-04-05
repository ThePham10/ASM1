import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        List<PolicyHolder> policyHolders = new ArrayList<>();
        List<InsuranceCard> insuranceCards = new ArrayList<>();

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

        policyHolders.add(pH1); policyHolders.add(pH2); policyHolders.add(pH3); policyHolders.add(pH4); policyHolders.add(pH5);
        policyHolders.add(pH6); policyHolders.add(pH7); policyHolders.add(pH8); policyHolders.add(pH9); policyHolders.add(pH10);
        policyHolders.add(pH11); policyHolders.add(pH12); policyHolders.add(pH13); policyHolders.add(pH14); policyHolders.add(pH15);

        try {
            // Create the file
            boolean isFileCreated = file.createNewFile();

            if (isFileCreated) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    for (PolicyHolder policyHolder : policyHolders) {
                        writer.write(policyHolder.getCustomerID() + "\t" +
                                policyHolder.getFullName() + "\t" +
                                policyHolder.getPolicyOwner() + "\t" +
                                policyHolder.getInsuranceCard().getInsuranceCardID() + "\t" +
                                policyHolder.getInsuranceCard().getExpirationDate());
                        writer.newLine();
                    }
                    System.out.println("Values written to the file successfully.");
                } catch (IOException e) {
                    System.out.println("An error occurred while writing to the file.");
                    e.printStackTrace();
                }
                System.out.println("File created successfully: " + file.getAbsolutePath());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }


        /*System.out.println(pH1); System.out.println(pH2); System.out.println(pH3); System.out.println(pH4); System.out.println(pH5);
        System.out.println(pH6); System.out.println(pH7); System.out.println(pH8); System.out.println(pH9); System.out.println(pH10);
        System.out.println(pH11); System.out.println(pH12); System.out.println(pH13); System.out.println(pH14); System.out.println(pH15);*/

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
