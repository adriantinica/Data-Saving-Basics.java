
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class App {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        
        // Preparing document in memory !!!

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder  dBuilder = dbFactory.newDocumentBuilder();
        List<Product> productsList = new ArrayList<>();

        Product product1 = new Product("Salad", new Money(100, "MDL"));
        Product product2 = new Product("Calzone", new Money(50, "MDL"));
        Product product3 = new Product("Juice", new Money(15, "MDL"));

        productsList.add(product1);
        productsList.add(product2);
        productsList.add(product3);

        // print the  <productsList>  in the terminal....
        for (Product product : productsList) {
            System.out.println(product);
        }

         //Empty DOC in memory
        Document document =  dBuilder.newDocument();

        // Create a root element "products" to hold all "product" elements
        Element productsElement = document.createElement("products");
        document.appendChild(productsElement);


        for (Product productX : productsList) {

            // Fill the DOC :
        
            Element product = document.createElement("product");
            productsElement.appendChild(product);

            Element name = document.createElement("name");
            name.setTextContent(productX.getName());
            product.appendChild(name);
            Element price = document.createElement("price");
            product.appendChild(price);
            Element amount = document.createElement("amount");
            amount.setTextContent(String.valueOf(productX.getPrice().getAmount()));  // CONVERT int to String
            price.appendChild(amount);
            Element currency = document.createElement("currency");
            currency.setTextContent(productX.getPrice().getCurrency());
            price.appendChild(currency);

          
        }
        
        
        
        
        //TRANSFORMIN & SAVING IT TO FILE AS STRING

        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer t = tFactory.newTransformer();

        //pretty print
        t.setOutputProperty(OutputKeys.INDENT,"yes");

        Source src = new DOMSource(document);

        Result result = new StreamResult(new File("product.xml"));
        t.transform(src,result);


      // HW1: Let's say we save the product data in a Product Object
      // HW2: Create a list of products ----> xml DOM  -----> XML file.....




        

        




         


    }
}