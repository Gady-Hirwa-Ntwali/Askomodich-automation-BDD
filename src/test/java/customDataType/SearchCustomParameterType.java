package customDataType;

import domainObject.SearchProduct;
import io.cucumber.java.ParameterType;

import java.util.Map;

public class SearchCustomParameterType {
    @ParameterType(".*")
    public SearchProduct searchProduct(String searchProduct) {
        return new SearchProduct(searchProduct);
    }
}
