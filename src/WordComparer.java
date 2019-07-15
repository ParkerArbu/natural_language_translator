import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordComparer {

    private Scanner questionScanner;
    private final String seperator = " ";
    private final String englishDictionary = "src/english_words.txt";
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

        TextParse.init(inputFile);
        TextParse.init(englishDictionary);

        String line = "";
        while(!line.equals("End Of File")){
            line = questionScanner.nextLine();
            if(!line.equals("End Of File")) {
                System.out.println(line);

                System.out.println();

                String[] parsedLine = inputParser(line);
                for (String word : parsedLine) {
                    System.out.println(TextParse.readerAndWriter(englishDictionary, word));
                }
            }
        }
    }

    private String[] inputParser(String line){
        return line.split(seperator);
    }

}
