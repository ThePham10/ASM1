public class Test {
    public static void main(String[] args) {
        Customer cus1 = new Customer();
        ReceiverBankingInfo bankingInfoC1Cus1 = new ReceiverBankingInfo();
        ClaimGenerator.createCustomer(cus1);
        System.out.println(cus1.toString());

        Claim claimCus1 = new Claim();
        ClaimGenerator.createClaim(claimCus1, cus1, bankingInfoC1Cus1);
        cus1.addClaim(claimCus1);

/*        Claim claimCus2 = new Claim();
        ClaimGenerator.createClaim(claimCus2, cus1);
        cus1.addClaim(claimCus2);*/

        System.out.println(cus1.toString());
    }
}
