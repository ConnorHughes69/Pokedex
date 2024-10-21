import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class reading {  // Changed the class name
    private File myFile;

    // Constructor that takes the file name
    public reading(String fileName) {
        this.myFile = new File(fileName);
    }

    // Create a scanner for the file
    private Scanner createScanner() {
        Scanner tempScanner = null;
        
        try {
            tempScanner = new Scanner(myFile);
        } catch (FileNotFoundException error) {
            System.out.println("File not found.");
        }
        
        return tempScanner;
    }

    // Count the number of lines in the file
    private int countFileLines() {
        Scanner tempScanner = createScanner();
        int count = 0;
        while (tempScanner.hasNextLine()) {
            tempScanner.nextLine();
            count++;
        }
        tempScanner.close(); // Close the scanner
        return count;
    }

    // Convert the file contents to a string array
    public String[] toStringArray() {
        Scanner reading = createScanner();
        int numLines = countFileLines();
        
        String[] arr = new String[numLines];
        
        for (int i = 0; i < numLines; i++) {
            arr[i] = reading.nextLine();
        }
        
        reading.close(); // Close the scanner
        return arr;
    }
}