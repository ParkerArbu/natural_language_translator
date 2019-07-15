import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordComparer {

    private Scanner questionScanner;
    private Scanner questionScanner2;
    private final String seperator = " ";
    private final String dictionary = "src/english_words.txt";
    private final String inputFile = "src/input.txt";

    public static void main(String[] args){
        new WordComparer();
    }

    private WordComparer(){
        try {
            questionScanner = new Scanner(new File(inputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            questionScanner2 = new Scanner(new File(dictionary));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = "";
        assert questionScanner != null;
        while(questionScanner.hasNextLine()){
            line = questionScanner.nextLine();
            System.out.println(line);

            System.out.println();

            String[] parsedLine = inputParser(line);
            for (String word : parsedLine) {
                int lineNumberTemp = readerAndWriter(dictionary, word);
                System.out.println(lineNumberTemp);
                if(lineNumberTemp == -1){
                    System.out.println("Invalid English Word");
                }
                else {
                    String[] spanishWords = spanishParser(lineNumberTemp);
                    for(String spanishWord : spanishWords){
                        System.out.print(spanishWord + ", ");
                    }
                    System.out.println();
                }
            }

        }
    }

    private int readerAndWriter(final String inputFileName, final String compareString){
        Scanner questionScanner;
        int lineNumber = 1;
        try {
            questionScanner = new Scanner(new File(inputFileName));
            String line = "";
            while(questionScanner.hasNextLine()){
                line = questionScanner.nextLine();
                String[] newLine = line.split(",");
                //System.out.println(line + " at line " + lineNumber);
                if(newLine[0].equals(compareString)){
                    return lineNumber;
                }
                ++lineNumber;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private String[] spanishParser(int lineNumber){
        String[] line;
        int lineNumberTemp = 1;
        while(questionScanner2.hasNextLine()){
            line = questionScanner2.nextLine().split(",");
            if(line.length < 2){
                System.out.println("No spanish word found");
                return new String[]{"No translation found"};
            }
            else {
                String spanish = line[1];
                if (lineNumberTemp < lineNumber) {
                    System.out.println(lineNumber + " , " + lineNumberTemp);
                    ++lineNumberTemp;
                } else {
                    System.out.println("Works");
                    return spanish.split("/");
                }
            }
        }
        return new String[]{"broken", "don't trigger"};
    }

    private String[] inputParser(String line){
        return line.split(seperator);
    }

}
