package domainObject;

public class SearchProduct {
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public SearchProduct(String productName) {
        this.productName = productName;
    }

    private String productName;
}
