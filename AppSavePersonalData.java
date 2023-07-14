import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


// HW1: add the possibility to store name, last name, age and rating;

// HW2:  when the app starts, ask the user if he wants the application to forget his name,
//       if answer is "yes", delete the file;



public class AppSavePersonalData{
    public static void main(String[] args) throws IOException {
        
        Scanner in = new Scanner(System.in);

        System.out.println("Please, introduce your data below !!!");
        System.out.print("What's your firstname?: ");
        String firstName = in.next();
        System.out.print("What's your lastname?: ");
        String lastName = in.next();
        System.out.print("How old are you ?: ");
        Integer age = in.nextInt();
        System.out.print("What's is your rating?: ");
        Double rating = in.nextDouble();
        String ratingString = Double.toString(rating);
        System.out.print("Do you want to save your data? YES/NO: ");
        String consent = in.next();
        
        // greating the user;
        System.out.println(" Hello " + firstName +" "+ lastName +" !!!" );
        
        // prepare the file: 

        File file = new File("name.text");
        if (file.exists() && consent.equals("YES")) {
            System.out.println( " > file found ");
            System.out.println("Your DATA will be keeped !!!");
            FileWriter fw = new FileWriter(file);
             
            //put the data's/write into file:
            fw.write(firstName + " ");  
            fw.write(lastName + " ");
            fw.write(age + " ");
            fw.write(ratingString);
            fw.flush();
            fw.close();
           
        } else  {
            
            
            if (consent.equals("YES")) {
                System.out.println( " > file is not found ");
                file.createNewFile();
                System.out.println("File created !!!");
                FileWriter fw = new FileWriter(file);
             
                //put the data's/write into file:
                fw.write(firstName + " ");  
                fw.write(lastName + " ");
                fw.write(age + " ");
                fw.write(ratingString);
                fw.flush();
                fw.close();
        

            } else if (consent.equals("NO")) {
                file.delete();
                System.out.println("The file with your data was deleted");

            }
        }

        
        


    }



}