package customDataType;

import domainObject.Category;
import io.cucumber.java.ParameterType;

public class CategoryCustomParamType {
    @ParameterType(".*")
    public static Category category(String category) {
        return new Category(category);
    }


}
