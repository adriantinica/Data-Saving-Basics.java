import org.w3c.dom.Element;

public class Product {

    private Element productName;
    private Element productPrice;
    
    public Product(Element productName2, Element productPrice2) {
        this.productName = productName2;
        this.productPrice =productPrice2;
    }

    public Element getProductName() {
        return productName;
    }

    public void setProductName(Element productName) {
        this.productName = productName;
    }

    public Element getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Element productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product [productName=" + productName + ", productPrice=" + productPrice + "]";
    }


    

    

    
}