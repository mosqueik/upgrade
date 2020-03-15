package api.dto;

public class RequestPayload {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public RequestPayload setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RequestPayload setPassword(String password) {
        this.password = password;
        return this;
    }
}
