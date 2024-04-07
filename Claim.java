/*
 @author <Pham Thanh The - S3981133>
*/

public class Claim {
    private String claimID;
    private Customer insuredPerson;
    private String cardID;
    private double amount;
    private String status;
    private String examDate;
    private String claimDate;
    private String documentList;
    private ReceiverBankingInfo bankingInfo;

    public Claim() {
        this.claimID = "default";
        this.cardID = "default";
        this.amount = 0;
        this.status = "default";
        this.examDate = "default";
        this.claimDate = "default";
    }

    public Claim(String claimID, String cardID, double amount, String status,
                 String examDate, String claimDate, ReceiverBankingInfo bankingInfo, Customer insuredPerson) {
        this.claimID = claimID;
        this.cardID = cardID;
        this.amount = amount;
        this.status = status;
        this.examDate = examDate;
        this.claimDate = claimDate;
        this.bankingInfo = bankingInfo;
        this.insuredPerson = insuredPerson;
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


    public ReceiverBankingInfo getBankingInfo() {
        return bankingInfo;
    }

    public void setBankingInfo(ReceiverBankingInfo bankingInfo) { this.bankingInfo = bankingInfo; }
    public void setBankName(String bankName) { this.bankingInfo.setBank(bankName); }
    public void setNameInBank(String nameInBank) { this.bankingInfo.setName(nameInBank); }
    public void setBankNumber(String bankNumber) { this.bankingInfo.setBankNumber(bankNumber); }

    @Override
    public String toString() {
        return  "\nClaimID: " + claimID +
                ", InsuredPerson: " + insuredPerson.getFullName() +
                ", CardID: " + cardID +
                ", Amount:" + amount +
                ", Status: " + status +
                ", ExamDate: " + examDate +
                ", ClaimDate: " + claimDate +
                ", ReceiverBankingInfo: " + bankingInfo + "\n";
    }
}
