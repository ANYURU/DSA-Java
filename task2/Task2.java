package task2;

import java.io.FileReader;
import java.io.IOException;
//import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Hashtable;

public class Task2 {
    public static void main(String[]args) throws IOException{
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        // Enter the filename.
        // The file should be placed in the same directory as the program.
        System.out.println("Enter the filename.");
        String fileName = scanner2.nextLine();
        String filePath = "./" + fileName;

        // File preprocessing; 
        // 1. => Read the file contents into a single string.
        // 2. => Split the single string into an array of characters while ommiting symbols.
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
    }
    
    // Reading the file contents into a buffer and returning the buffer.
    private static BufferedReader readFileToBuffer(String fileName) throws FileNotFoundException{
        BufferedReader buffer = new BufferedReader(new FileReader(fileName));
        return buffer;
    }

    // Converting the buffer into a single string.
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
