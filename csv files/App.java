import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
       
        File file = new File("document.csv");
        file.createNewFile();
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());
        FileWriter fw = new FileWriter(file);

        fw.write("Salad,25  \n");
        fw.write("Soup,40  \n");
        fw.write("Pizza,100  \n");
        fw.write("Ice cream,15  ");
        
        fw.flush();
        
        

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);


        List<Product> products = new ArrayList<>();

        while (true) {
            String line = br.readLine();  
            if(line == null)break;
            String [] cols = line.trim().split(",");
            String productName = cols[0];
            int productPrice = Integer.parseInt(cols[1]);
            products.add(new Product(productName, productPrice));
        }
        
        for (Product product : products) {
            System.out.println(product);
        }

        
        //for (String col : cols) {
        //    System.out.println(col);
        //}

        
        

        //HW1: Diff between .parseInt() and valueOf() methods;

        //.parseInt() method returns a primitive integer data converted from String;
        //.valueOf() method returns an Integer object wich contains a value of type String;




        //HW2;
        //      create the Product class;
        // while reading the data from the first line
        // put it in a object type Product;
        
        //output using toString;

       



    

    }
}
