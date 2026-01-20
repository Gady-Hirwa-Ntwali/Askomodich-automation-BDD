package customDataType;

import domainObject.RegisterCredentials;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;

import java.util.Map;

public class RegisterCustomParameterType {

    @DataTableType
    public RegisterCredentials getRegisterCridentials(Map<String, String> cridentials) {
        return new RegisterCredentials(cridentials.get("username"), cridentials.get("password"), cridentials.get("email"));
    }
}
