package domainObject;

public class LoginCridentials{

    private String email;

    public LoginCridentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
