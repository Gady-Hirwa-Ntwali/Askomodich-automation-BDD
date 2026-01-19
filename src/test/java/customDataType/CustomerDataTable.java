package customDataType;

import domainObject.BillingDetails;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CustomerDataTable {
    @DataTableType
    public BillingDetails customerType(Map<String, String> entry) {
        return new BillingDetails(entry.get("firstName"),
                entry.get("lastName"),
                entry.get("country"),
                entry.get("address"),
                entry.get("city"),
                entry.get("state"),
                entry.get("zipcode"),
                entry.get("email"));
    }
}
