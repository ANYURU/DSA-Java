package task2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Enumeration;

public class task2 {
    public static void main(String[]args) throws IOException{
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        System.out.println("Enter the file path.");
        String fileName = scanner2.nextLine();
        String filePath = "./" + fileName;

        BufferedReader br = readFileToBuffer(filePath);
        String singleString = textToString(br);
        String [] words = singleString.split("\\W+");
        // System.out.println(Arrays.toString(words));

        // Populating the Hash table.
        Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
        for(int i = 0; i < words.length; i++) {
            int key =  stringHash(words[i]);
            String value = words[i];
            hashtable.put( key, value);
        }
    
        // Continuously prompting the user for input.
        // If the input is "The program stops running."
        while(true) {
            System.out.println("\nWhich word would you like to find? Enter 'q' to quit.");
            String input = scanner1.nextLine();

            if(input.equals("q")) {
                break;
            } else {
                int searchedKey = stringHash(input);
                if(hashtable.containsKey(searchedKey) == true) {
                    System.out.println("The word " + input + " exists in the file " + fileName + "\n");
                } else {
                    System.out.println("The word " + input + " is not found in " + fileName + "\n");
                }

            }
        }

        scanner1.close();
        scanner2.close();
        
        // String fileName = "./story.txt";
        


        
    }

    private static BufferedReader readFileToBuffer(String fileName) throws FileNotFoundException{
        BufferedReader buffer = new BufferedReader(new FileReader(fileName));
        return buffer;
    }

    private static String textToString(BufferedReader buffer) throws IOException {
        StringBuilder stringText = new StringBuilder();
        String line;
        while((line = buffer.readLine()) !=  null) {
            stringText.append(line);
        }

        return stringText.toString();
    }

    private static int stringHash( String characters){
        int hash = 0;
        for(int i = 0; i < characters.length(); i++){
            hash = (hash << 5) - hash + characters.charAt(i);
        }

        return hash;
    }
    
}
