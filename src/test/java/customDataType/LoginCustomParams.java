package customDataType;

import domainObject.LoginCridentials;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import org.junit.runners.Parameterized;

import java.util.Map;

public class LoginCustomParams {
    @DataTableType
    public LoginCridentials loginCridentials(Map<String, String> cridentials) {
        return new LoginCridentials(cridentials.get("email"), cridentials.get("password"));
    }
}
