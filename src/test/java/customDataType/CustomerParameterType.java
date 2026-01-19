package customDataType;

import domainObject.Product;
import io.cucumber.java.ParameterType;

public class CustomerParameterType {
    @ParameterType(".*")
    public Product product(String name){
        return new Product(name);
    }
}
