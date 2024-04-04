public class Test {
    public static void main(String[] args) {
        PolicyHolder pH1 = new PolicyHolder();
        pH1 = new PolicyHolder("C0000000001", "Thanh The", new InsuranceCard("1111111111", pH1, "RMIT", "2025/04/25"), "RMIT");
        System.out.println(pH1);

        ReceiverBankingInfo bankingInfo1pH1 = new ReceiverBankingInfo();
        Claim claim1pH1 = new Claim();
        ClaimGenerator.createClaim(claim1pH1, pH1, bankingInfo1pH1);
        pH1.addClaim(claim1pH1);
        System.out.println(pH1);

/*        ReceiverBankingInfo bankingInfo2pH1 = new ReceiverBankingInfo();
        Claim claim2pH1 = new Claim();
        ClaimGenerator.createClaim(claim2pH1, pH1, bankingInfo2pH1);
        pH1.addClaim(claim2pH1);

        System.out.println(pH1);*/
    }
}
