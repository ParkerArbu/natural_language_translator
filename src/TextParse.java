import java.io.Writer;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class TextParse {

    public static int readerAndWriter(final String inputFileName, final String compareString){
        Scanner questionScanner;
        int lineNumber = 1;
        try {
            questionScanner = new Scanner(new File(inputFileName));
            String line = "";
            while(!line.equals("End Of File")){
                line = questionScanner.nextLine();
                //System.out.println(line + " at line " + lineNumber);
                if(line.equals(compareString)){
                    return lineNumber;
                }
                ++lineNumber;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
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
