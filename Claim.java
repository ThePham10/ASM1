import java.util.List;

public class Claim {
    private String claimID;
    private Customer insuredPerson;
    private String cardID;
    private double amount;
    private String status;
    private String examDate;
    private String claimDate;
    private List<Document> documentList;
    private ReceiverBankingInfo receiverBankingInfo;

    public Claim() {
        this.claimID = "default";
        this.cardID = "default";
        this.amount = 0;
        this.status = "default";
        this.examDate = "default";
        this.claimDate = "default";
    }

    public Claim(String claimID, Customer insuredPerson, String cardID, double amount, String status, String examDate) {
        this.claimID = claimID;
        this.insuredPerson = insuredPerson;
        this.cardID = cardID;
        this.amount = amount;
        this.status = status;
        this.examDate = "default";
    }

    public Claim(String claimID, Customer insuredPerson, String cardID, double amount, String status, String examDate, String claimDate) {
        this.claimID = claimID;
        this.insuredPerson = insuredPerson;
        this.cardID = cardID;
        this.amount = amount;
        this.status = status;
        this.examDate = "default";
        this.claimDate = "default";
    }

    public void setStatus(String status) {
        String[] statuses = {"New", "Processing", "Done"};
        boolean statusChecked = false;
        for (String availableStatus:statuses) {
            if (availableStatus.equals(status)) {
                statusChecked = true;
            }
        }
        if (statusChecked) {
            this.status = status;
            statusChecked = true;
        }
    }



    public String generateClaimID () {
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int randomNumber = (int) (Math.random() * 10);
            stringBuilder1.append(randomNumber);
        }
        String randomString = stringBuilder1.toString();
        return "C" + randomString;
    }

    public String getClaimID() {
        return claimID;
    }

    public Customer getInsuredPerson() {
        return insuredPerson;
    }

    public String getCardID() {
        return cardID;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public String getExamDate() {
        return examDate;
    }

    public String getClaimDate() {
        return claimDate;
    }

    public void setClaimID(String claimID) {
        this.claimID = claimID;
    }

    public void setInsuredPerson(Customer insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate;
    }


    public ReceiverBankingInfo getReceiverBankingInfo() {
        return receiverBankingInfo;
    }

    @Override
    public String toString() {
        return  "Claim: " +
                "ClaimID: " + claimID +
                ", InsuredPerson: " + insuredPerson.getFullName() +
                ", CardID: " + cardID +
                ", Amount:" + amount +
                ", Status: " + status +
                ", ExamDate: " + examDate +
                ", ClaimDate: " + claimDate +
                ", ReceiverBankingInfo: " + receiverBankingInfo;
    }
}
