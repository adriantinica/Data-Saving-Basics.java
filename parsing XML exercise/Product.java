import org.w3c.dom.Element;

public class Product {

    private Element productName;
    private Element productPrice;
    
    public Product(Element productName, Element productPrice) {
        this.productName = productName;
        this.productPrice =productPrice;
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
        return "Product [productName=" + productName.getTextContent().trim() + ", productPrice=" + productPrice.getTextContent().trim() +  "]";
    }




    

    

    
}
