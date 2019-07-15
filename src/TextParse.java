import java.io.Writer;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class TextParse {

    public static void readerAndWriter(final String inputFileName, final String compareString){
        Scanner questionScanner;
        int lineNumber = 1;
        try {
            questionScanner = new Scanner(new File(inputFileName));
            String line = "";
            do{
                line = questionScanner.nextLine();
                System.out.println(line + " at line " + lineNumber);
                ++lineNumber;
            }while(!line.equals("End Of File"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void init(final String inputFileName){
        Writer out;
        try {
            out = new FileWriter(inputFileName, true);
            out.write('\n' + "End Of File" + '\n'); //Write the string to the file
            out.flush();
            out.close(); //Close the file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
