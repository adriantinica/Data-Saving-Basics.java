import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class App {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        
        File file = new File("products.xml");
        System.out.println(file.getAbsolutePath());


        // DOM Parser/ + Factory & Builder & Singleton patterns

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(file);

        //###########   trabversing the DOM and extracting DATA    ######################################################

        System.out.println(document.getDoctype());
        System.out.println();

        Element root = document.getDocumentElement();
        NodeList products = root.getElementsByTagName("product");
        Element firstProduct = (Element)products.item(0);
        Element productName = (Element) firstProduct.getElementsByTagName("name").item(0);

        // ##############################################################################################################


        System.out.println(productName.getTextContent().trim());

        //HW1: Extract the price for first product....

        Element productPrice = (Element) firstProduct.getElementsByTagName("price").item(0);
        //System.out.println(productPrice.getTextContent().trim());

        Element priceAmount  = (Element) firstProduct.getElementsByTagName("amount").item(0);
        Element priceCurrency = (Element) firstProduct.getElementsByTagName("currency").item(0);

        System.out.println(priceAmount.getTextContent().trim() );
        System.out.println(priceCurrency.getTextContent().trim() );

        Product product1 = new Product(productName, productPrice );
        System.out.println(product1);

        





    }
}
