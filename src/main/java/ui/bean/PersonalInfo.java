package ui.bean;

import org.apache.commons.lang3.RandomStringUtils;

public class PersonalInfo {
    private boolean isJoint;
    private String fname;
    private String lname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String dobDay;
    private String dobMonth;
    private String dobYear;
    private String income;
    private String additionalIncome;
    private String email;
    private String password;

    public PersonalInfo(){
        this.isJoint = false;
        this.fname = RandomStringUtils.randomAlphabetic(9);
        this.lname = RandomStringUtils.randomAlphabetic(9);
        this.street = "600 Guerrero Street";
        this.city = "San Francisco";
        this.state = "CA";
        this.zip = "94110";
        this.dobDay = "08";
        this.dobMonth = "09";
        this.dobYear = "1978";
        this.income = "122000";
        this.additionalIncome = "8000";
    }

    public boolean isJoint() {
        return isJoint;
    }

    public void setJoint(boolean joint) {
        isJoint = joint;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getDobDay() {
        return dobDay;
    }

    public void setDobDay(String dobDay) {
        this.dobDay = dobDay;
    }

    public String getDobMonth() {
        return dobMonth;
    }

    public void setDobMonth(String dobMonth) {
        this.dobMonth = dobMonth;
    }

    public String getDobYear() {
        return dobYear;
    }

    public void setDobYear(String dobYear) {
        this.dobYear = dobYear;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getAdditionalIncome() {
        return additionalIncome;
    }

    public void setAdditionalIncome(String additionalIncome) {
        this.additionalIncome = additionalIncome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
