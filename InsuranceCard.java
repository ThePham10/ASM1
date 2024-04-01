public class InsuranceCard {
    private String insuranceCardID;
    private Customer cardHolder;
    private String policyOwner;
    private String expirationDate;


    public InsuranceCard() {
        this.insuranceCardID = "default";
        this.policyOwner = "default";
        this.expirationDate = "default";
    }

    public InsuranceCard(String insuranceCardID, Customer cardHolder, String policyOwner, String expirationDate) {
        this.insuranceCardID = insuranceCardID;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }

    public String generateCardID () {
        StringBuilder stringBuilder3 = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int randomNumber = (int) (Math.random() * 10);
            stringBuilder3.append(randomNumber);
        }
        return stringBuilder3.toString();
    }

    public String getInsuranceCardID() { return insuranceCardID; }

    public Customer getCardHolder() { return cardHolder; }

    public String getPolicyOwner() { return policyOwner; }

    public void setInsuranceCardID(String insuranceCardID) {this.insuranceCardID = insuranceCardID; }

    public void setCardHolder(Customer cardHolder) { this.cardHolder = cardHolder; }

    public void setPolicyOwner(String policyOwner) { this.policyOwner = policyOwner; }

    public void setExpirationDate(String expirationDate) { this.expirationDate = expirationDate; }
}
