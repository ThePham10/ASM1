import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 @author <Pham Thanh The - S3981133>
*/

public class SampleObjects {
    public static void main(String[] args) throws IOException {
        List<PolicyHolder> policyHolders = new ArrayList<>();
        List<Claim> claims = new ArrayList<>();
        List<Dependent> dependents = new ArrayList<>();

        PolicyHolder pH1 = new PolicyHolder();
        pH1 = new PolicyHolder("C0000000001", "JANG WONYOUNG", "STARSHIP ENT", new InsuranceCard("1000000001", "STARSHIP ENT", Generator.generateExpirationDate(), pH1));
        PolicyHolder pH2 = new PolicyHolder();
        pH2 = new PolicyHolder("C0000000002", "LEE HYUNSEO", "STARSHIP ENT", new InsuranceCard("1000000002", "STARSHIP ENT", Generator.generateExpirationDate(), pH2));
        PolicyHolder pH3 = new PolicyHolder();
        pH3 = new PolicyHolder("C0000000003", "KIM MINJEONG", "SM ENT", new InsuranceCard("1000000003", "SM ENT", Generator.generateExpirationDate(), pH3));
        PolicyHolder pH4 = new PolicyHolder();
        pH4 = new PolicyHolder("C0000000004", "AERI UCHINAGA", "SM ENT", new InsuranceCard("1000000004", "SM ENT", Generator.generateExpirationDate(), pH4));
        PolicyHolder pH5 = new PolicyHolder();
        pH5 = new PolicyHolder("C0000000005", "KHONG TU QUYNH", "LUNAS", new InsuranceCard("1000000005", "LUNAS", Generator.generateExpirationDate(), pH5));
        PolicyHolder pH6 = new PolicyHolder();
        pH6 = new PolicyHolder("C0000000006", "TRANG PHAP", "LUNAS", new InsuranceCard("1000000006", "LUNAS", Generator.generateExpirationDate(), pH6));
        PolicyHolder pH7 = new PolicyHolder();
        pH7 = new PolicyHolder("C0000000007", "NINH DUONG LAN NGOC", "LUNAS", new InsuranceCard("1000000007", "LUNAS", Generator.generateExpirationDate(), pH7));
        PolicyHolder pH8 = new PolicyHolder();
        pH8 = new PolicyHolder("C0000000008", "HUYEN BABY", "LUNAS", new InsuranceCard("1000000008", "LUNAS", Generator.generateExpirationDate(), pH8));
        PolicyHolder pH9 = new PolicyHolder();
        pH9 = new PolicyHolder("C0000000009", "DIEP LAM ANH", "LUNAS", new InsuranceCard("1000000009", "LUNAS", Generator.generateExpirationDate(), pH9));
        PolicyHolder pH10 = new PolicyHolder();
        pH10 = new PolicyHolder("C0000000010", "SHINYU", "PLEDIS ENT", new InsuranceCard("1000000010", "PLEDIS ENT", Generator.generateExpirationDate(), pH10));
        PolicyHolder pH11 = new PolicyHolder();
        pH11 = new PolicyHolder("C0000000011", "LEE JENO", "SM ENT", new InsuranceCard("1000000011", "SM ENT", Generator.generateExpirationDate(), pH11));
        PolicyHolder pH12 = new PolicyHolder();
        pH12 = new PolicyHolder("C0000000012", "NA JAEMIN", "SM ENT", new InsuranceCard("1000000012", "SM ENT", Generator.generateExpirationDate(), pH12));
        PolicyHolder pH13 = new PolicyHolder();
        pH13 = new PolicyHolder("C0000000013", "MONO", "MTP ENT", new InsuranceCard("1000000013", "MTP ENT", Generator.generateExpirationDate(), pH13));
        PolicyHolder pH14 = new PolicyHolder();
        pH14 = new PolicyHolder("C0000000014", "SON TUNG MTP", "MTP ENT", new InsuranceCard("1000000014", "MTP ENT", Generator.generateExpirationDate(), pH14));
        PolicyHolder pH15 = new PolicyHolder();
        pH15 = new PolicyHolder("C0000000015", "KAY TRAN", "MTP ENT", new InsuranceCard("1000000015", "MTP ENT", Generator.generateExpirationDate(), pH15));

        Dependent dP1 = new Dependent();
        dP1 = new Dependent("C1000000001", "FUBAO", new InsuranceCard("1100000001", "STARSHIP ENT", Generator.generateExpirationDate(), dP1), "JANG WONYOUNG", pH1);
        Dependent dP2 = new Dependent();
        dP2 = new Dependent("C1000000002", "AIBAO", new InsuranceCard("1100000002", "STARSHIP ENT", Generator.generateExpirationDate(), dP2), "JANG WONYOUNG", pH1);
        Dependent dP3 = new Dependent();
        dP3 = new Dependent("C1000000003", "LEBAO", new InsuranceCard("1100000003", "STARSHIP ENT", Generator.generateExpirationDate(), dP3), "JANG WONYOUNG", pH1);
        Dependent dP4 = new Dependent();
        dP4 = new Dependent("C5000000001", "HUIBAO", new InsuranceCard("1500000001", "STARSHIP ENT", Generator.generateExpirationDate(), dP4), "KHONG TU QUYNH", pH5);
        Dependent dP5 = new Dependent();
        dP5 = new Dependent("C5000000002", "RUIBAO", new InsuranceCard("1500000002", "STARSHIP ENT", Generator.generateExpirationDate(), dP5), "KHONG TU QUYNH", pH5);

        pH1.addDependent(dP1); pH1.addDependent(dP2); pH1.addDependent(dP3);
        pH5.addDependent(dP4); pH5.addDependent(dP5);

        dependents.add(dP1); dependents.add(dP2); dependents.add(dP3); dependents.add(dP4); dependents.add(dP5);

        Claim claim1pH1 = new Claim("F1000000001", "1000000001", 65.99, "Done", Generator.generateDate(), Generator.generateDate(), new ReceiverBankingInfo("VISA", "JANG WONYOUNG", "1515152323"), pH1);
        Claim claim2pH1 = new Claim("F1000000002", "1000000001", 66.99, "Processing", Generator.generateDate(), Generator.generateDate(), new ReceiverBankingInfo("Shinhan Bank", "JANG WONYOUNG", "1515152222"), pH1);
        Claim claim1pH5 = new Claim("F5000000001", "1000000005", 70.88, "New", Generator.generateDate(), Generator.generateDate(), new ReceiverBankingInfo("VISA", "KHONG TU QUYNH", "9819191919"), pH5);
        Claim claim2pH5 = new Claim("F5000000002", "1000000005", 26.46, "New", Generator.generateDate(), Generator.generateDate(), new ReceiverBankingInfo("SACOMBANK", "KHONG TU QUYNH", "2345673456"), pH5);
        Claim claim3pH5 = new Claim("F5000000003", "1000000005", 43.00, "Processing", Generator.generateDate(), Generator.generateDate(), new ReceiverBankingInfo("EXIMBANK", "KHONG TU QUYNH", "2345673456"), pH5);

        Claim claim1dP1 = new Claim("F1100000001", "1100000001", 99.99, "Done", Generator.generateDate(), Generator.generateDate(), new ReceiverBankingInfo("AGRIBANK", "FUBAO", "1234567898"), dP1);
        Claim claim2dP1 = new Claim("F1100000002", "1100000001", 88.88, "Done", Generator.generateDate(), Generator.generateDate(), new ReceiverBankingInfo("MB BANK", "FUBAO", "9876543212"), dP1);

        pH1.add(claim1pH1); pH1.add(claim2pH1);
        pH5.add(claim1pH5); pH5.add(claim2pH5); pH5.add(claim3pH5);
        claims.add(claim1pH1);  claims.add(claim2pH1);  claims.add(claim1pH5);
        claims.add(claim2pH5);  claims.add(claim3pH5);

        dP1.add(claim1dP1); dP1.add(claim2dP1);
        claims.add(claim1dP1); claims.add(claim2dP1);

        policyHolders.add(pH1); policyHolders.add(pH2); policyHolders.add(pH3); policyHolders.add(pH4); policyHolders.add(pH5);
        policyHolders.add(pH6); policyHolders.add(pH7); policyHolders.add(pH8); policyHolders.add(pH9); policyHolders.add(pH10);
        policyHolders.add(pH11); policyHolders.add(pH12); policyHolders.add(pH13); policyHolders.add(pH14); policyHolders.add(pH15);

        fileWriting.writePolicyHolderIntoFile(policyHolders);
        fileWriting.writeClaimIntoFile(claims);
        fileWriting.writeDependentIntoFile(dependents);
    }
}
