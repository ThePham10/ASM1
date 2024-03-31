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
    }

    public Claim(String claimID, String cardID, double amount, String status) {
        this.claimID = claimID;
        this.cardID = cardID;
        this.amount = amount;
        this.status = status;
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
}
