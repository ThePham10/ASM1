public class Test {
    public static void main(String[] args) {
        PolicyHolder pH1 = new PolicyHolder();
        pH1 = new PolicyHolder("C0000000001", "JANG WONYOUNG", new InsuranceCard("1111111101", pH1, "STARSHIP ENT", "2025/04/04"), "STARSHIP ENT");

        PolicyHolder pH2 = new PolicyHolder();
        pH2 = new PolicyHolder("C0000000002", "LEE HYUNSEO", new InsuranceCard("1111111102", pH2, "STARSHIP ENT", "2025/04/04"), "STARSHIP ENT");

        PolicyHolder pH3 = new PolicyHolder();
        pH3 = new PolicyHolder("C0000000003", "KIM MINJEONG", new InsuranceCard("1111111103", pH3, "SM ENT", "2025/04/04"), "SM ENT");

        PolicyHolder pH4 = new PolicyHolder();
        pH4 = new PolicyHolder("C0000000004", "AERI UCHINAGA", new InsuranceCard("1111111104", pH4, "SM ENT", "2025/04/04"), "SM ENT");

        PolicyHolder pH5 = new PolicyHolder();
        pH5 = new PolicyHolder("C0000000005", "KHONG TU QUYNH", new InsuranceCard("1111111105", pH5, "LUNAS", "2025/04/04"), "LUNAS");

        PolicyHolder pH6 = new PolicyHolder();
        pH6 = new PolicyHolder("C0000000006", "TRANG PHAP", new InsuranceCard("1111111106", pH6, "LUNAS", "2025/04/04"), "LUNAS");

        PolicyHolder pH7 = new PolicyHolder();
        pH7 = new PolicyHolder("C0000000007", "NINH DUONG LAN NGOC", new InsuranceCard("1111111107", pH7, "LUNAS", "2025/04/04"), "LUNAS");

        PolicyHolder pH8 = new PolicyHolder();
        pH8 = new PolicyHolder("C0000000008", "HUYEN BABY", new InsuranceCard("1111111108", pH8, "LUNAS", "2025/04/04"), "LUNAS");

        PolicyHolder pH9 = new PolicyHolder();
        pH9 = new PolicyHolder("C0000000009", "DIEP LAM ANH", new InsuranceCard("1111111109", pH9, "LUNAS", "2025/04/04"), "LUNAS");

        PolicyHolder pH10 = new PolicyHolder();
        pH10 = new PolicyHolder("C0000000010", "SHINYU", new InsuranceCard("1111111110", pH10, "PLEDIS ENT", "2025/04/04"), "PLEDIS ENT");

        PolicyHolder pH11 = new PolicyHolder();
        pH11 = new PolicyHolder("C0000000011", "LEE JENO", new InsuranceCard("1111111111", pH11, "SM ENT", "2025/04/04"), "SM ENT");

        PolicyHolder pH12 = new PolicyHolder();
        pH12 = new PolicyHolder("C0000000012", "NA JAEMIN", new InsuranceCard("1111111112", pH12, "SM ENT", "2025/04/04"), "SM ENT");

        PolicyHolder pH13 = new PolicyHolder();
        pH13 = new PolicyHolder("C0000000013", "NOO PHUOC THINH", new InsuranceCard("1111111113", pH13, "NOOPT", "2025/04/04"), "NPT");

        PolicyHolder pH14 = new PolicyHolder();
        pH14 = new PolicyHolder("C00000000014", "SON TUNG MTP", new InsuranceCard("1111111114", pH1, "MTP ENT", "2025/04/04"), "MTP ENT");

        PolicyHolder pH15 = new PolicyHolder();
        pH15 = new PolicyHolder("C0000000015", "KAY TRAN", new InsuranceCard("1111111115", pH1, "MTP ENT", "2025/04/04"), "MTP ENT");

        System.out.println(pH1); System.out.println(pH2); System.out.println(pH3); System.out.println(pH4); System.out.println(pH5);
        System.out.println(pH6); System.out.println(pH7); System.out.println(pH8); System.out.println(pH9); System.out.println(pH10);
        System.out.println(pH11); System.out.println(pH12); System.out.println(pH13); System.out.println(pH14); System.out.println(pH15);

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
