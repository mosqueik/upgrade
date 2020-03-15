package api.dto;

public class LoansInReview {
    public static String PERSONAL_LOAN_TYPE = "PERSONAL_LOAN";

    private Integer id;
    private String uuid;
    private String status;
    private String productType;
    private String sourceSystem;
    private Boolean hasOpenBackendCounter;
    private String purpose;
    private String createDate;
    private Object postIssuanceStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LoansInReview withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public LoansInReview withUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LoansInReview withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public LoansInReview withProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public LoansInReview withSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
        return this;
    }

    public Boolean getHasOpenBackendCounter() {
        return hasOpenBackendCounter;
    }

    public void setHasOpenBackendCounter(Boolean hasOpenBackendCounter) {
        this.hasOpenBackendCounter = hasOpenBackendCounter;
    }

    public LoansInReview withHasOpenBackendCounter(Boolean hasOpenBackendCounter) {
        this.hasOpenBackendCounter = hasOpenBackendCounter;
        return this;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public LoansInReview withPurpose(String purpose) {
        this.purpose = purpose;
        return this;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public LoansInReview withCreateDate(String createDate) {
        this.createDate = createDate;
        return this;
    }

    public Object getPostIssuanceStatus() {
        return postIssuanceStatus;
    }

    public void setPostIssuanceStatus(Object postIssuanceStatus) {
        this.postIssuanceStatus = postIssuanceStatus;
    }

    public LoansInReview withPostIssuanceStatus(Object postIssuanceStatus) {
        this.postIssuanceStatus = postIssuanceStatus;
        return this;
    }
}
