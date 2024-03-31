public class ReceiverBankingInfo {
    private String bank;
    private String name;
    private String bankingNumber;

    public ReceiverBankingInfo() {
        this.bank = "default";
        this.name = "default";
        this.bankingNumber = "default";
    }

    public ReceiverBankingInfo(String bank, String name, String bankingNumber) {
        this.bank = bank;
        this.name = name;
        this.bankingNumber = bankingNumber;
    }
}
