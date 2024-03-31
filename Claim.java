import javax.print.Doc;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Claim {
    private String claimID;
    private Customer insuredPerson;
    private String cardID;
    private double amount;
    private String status;
    private Date examDate;
    SimpleDateFormat examDateFormat = new SimpleDateFormat("MM/dd/YY");
    private Date claimDate;
    SimpleDateFormat claimDateFormat = new SimpleDateFormat("MM/dd/YY");
    private List<Document> documentList;
    private ReceiverBankingInfo receiverBankingInfo;

    public Claim() {
        this.claimID = "default";
        this.cardID = "default";
        this.amount = 0;
        this.status = "default";
        this.examDate = new Date();
        this.claimDate = new Date();
    }

    public Claim(String claimID, String cardID, double amount, String status, Date examDate, Date claimDate) {
        this.claimID = claimID;
        this.cardID = cardID;
        this.amount = amount;
        this.status = status;
        this.examDate = new Date();
        this.claimDate = new Date();
    }

    public boolean setStatus(String status) {
        String[] statuses = {"New", "Processing", "Done"};
        boolean statusChecked = false;
        for (String availableStatus:statuses) {
            if (availableStatus.equals(status)) {
                statusChecked = true;
            }
        }
        if (statusChecked) {
            this.status = status;
            return true;
        }
        return false;
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

    public Date getExamDate() {
        return examDate;
    }

    public SimpleDateFormat getExamDateFormat() {
        return examDateFormat;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public SimpleDateFormat getClaimDateFormat() {
        return claimDateFormat;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public ReceiverBankingInfo getReceiverBankingInfo() {
        return receiverBankingInfo;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "claimID='" + claimID + '\'' +
                ", insuredPerson=" + insuredPerson +
                ", cardID='" + cardID + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", examDate=" + examDate +
                ", examDateFormat=" + examDateFormat +
                ", claimDate=" + claimDate +
                ", claimDateFormat=" + claimDateFormat +
                ", documentList=" + documentList +
                ", receiverBankingInfo=" + receiverBankingInfo +
                '}';
    }
}
