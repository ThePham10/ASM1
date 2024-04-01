public class Test {
    public static void main(String[] args) {
        Customer cus1 = new Customer();
        ClaimGenerator.createCustomer(cus1);
        System.out.println(cus1.toString());
        Claim claimCus1 = new Claim();
        ClaimGenerator.createClaim(claimCus1, cus1);
        cus1.addClaim(claimCus1);
        System.out.println(cus1.toString());
    }
}
