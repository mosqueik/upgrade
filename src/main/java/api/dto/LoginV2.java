package api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginV2 {
    private String firstName;
    private Integer userId;
    private String userUuid;
    private List<Object> loanApplications = null;
    private List<LoansInReview> loansInReview = null;

    public String getFirstName() {
        return firstName;
    }

    public LoginV2 setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public LoginV2 setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public LoginV2 setUserUuid(String userUuid) {
        this.userUuid = userUuid;
        return this;
    }

    public List<Object> getLoanApplications() {
        return loanApplications;
    }

    public LoginV2 setLoanApplications(List<Object> loanApplications) {
        this.loanApplications = loanApplications;
        return this;
    }

    public List<LoansInReview> getLoansInReview() {
        return loansInReview;
    }

    public LoginV2 setLoansInReview(List<LoansInReview> loansInReview) {
        this.loansInReview = loansInReview;
        return this;
    }
}


