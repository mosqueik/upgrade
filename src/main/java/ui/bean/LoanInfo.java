package ui.bean;

public class LoanInfo {
    private String loanAmount;
    private String loanPurpose;

    public LoanInfo(){
        this.loanAmount = "2000";
        this.loanPurpose = "CREDIT_CARD";
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public String getLoanPurpose() {
        return loanPurpose;
    }
}
