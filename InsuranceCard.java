import java.util.Date;

public class InsuranceCard {
    private double insuranceCardID;
    private String cardHolder;
    private String policyOwner;
    private Date expirationDate;


    public InsuranceCard() {
        this.insuranceCardID = 0;
        this.cardHolder = "default";
        this.policyOwner = "default";
    }

    public InsuranceCard(double insuranceCardID, String cardHolder, String policyOwner) {
        this.insuranceCardID = insuranceCardID;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
    }

    public double getInsuranceCardID() { return insuranceCardID; }

    public String getCardHolder() { return cardHolder; }

    public String getPolicyOwner() { return policyOwner; }
}
