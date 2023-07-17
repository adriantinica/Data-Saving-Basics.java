import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
        fw.flush();
        fw.close();

        

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();  
        String [] cols = line.trim().split(",");
         

        for (String col : cols) {
            System.out.println(col);
        }

        String productName = cols[0];
        int productPrice = Integer.parseInt(cols[1]);
        

        //HW1: Diff between .parseInt() and valueOf() methods;

        //.parseInt() method returns a primitive integer data converted from String;
        //.valueOf() method returns an Integer object wich contains a value of type String;




        //HW2;
        //      create the Product class;
        // while reading the data from the first line
        // put it in a object type Product;
        
        //output using toString;

        Product product1 = new Product(productName, productPrice);
        System.out.println(product1);




    

    }
}