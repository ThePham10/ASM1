/*
 @author <Pham Thanh The - S3981133>
*/

public class ReceiverBankingInfo {
    private String bank;
    private String name;
    private String bankNumber;

    public ReceiverBankingInfo() {
        this.bank = "default";
        this.name = "default";
        this.bankNumber = "default";
    }

    public ReceiverBankingInfo(String bank, String name, String bankingNumber) {
        this.bank = bank;
        this.name = name;
        this.bankNumber = bankingNumber;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    @Override
    public String toString() {
        return  "Bank: " + bank +
                ", Name: " + name +
                ", bankingNumber: " + bankNumber;
    }

    public void setBank() {
    }
}
