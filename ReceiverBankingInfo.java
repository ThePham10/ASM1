public class ReceiverBankingInfo {
    private String bank;
    private String name;
    private String number;

    public ReceiverBankingInfo() {
        this.bank = "default";
        this.name = "default";
        this.number = "default";
    }

    public ReceiverBankingInfo(String bank, String name, String number) {
        this.bank = bank;
        this.name = name;
        this.number = number;
    }
}
