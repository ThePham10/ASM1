public class Test {
    public static void main(String[] args) {
        Customer cus1 = new Customer();
        ClaimGenerator.createCustomer(cus1);
        System.out.println(cus1.toString());
        System.out.println(cus1.getInsuranceCard().getExpirationDate());
    }
}
