import java.io.Writer;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class TextParse {
    private final String inputFileName = "src/input.txt";

    private Scanner questionScanner;
    {
        try {
            questionScanner = new Scanner(new File(inputFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TextParse();
    }

    private TextParse(){

        init();

        readerAndWriter();
    }

    private void readerAndWriter(){
        String line = "";
        do{
            line = questionScanner.nextLine();
            System.out.println(line);
        }while(!line.equals("End Of File"));
    }

    private void init(){
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
