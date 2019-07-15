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

        TextParse.init(inputFile);
        TextParse.init(dictionary);

        String line = "";
        while(!line.equals("End Of File")){
            line = questionScanner.nextLine();
            if(!line.equals("End Of File")) {
                System.out.println(line);

                System.out.println();

                String[] parsedLine = inputParser(line);
                for (String word : parsedLine) {
                    int lineNumberTemp = TextParse.readerAndWriter(dictionary, word);
                    String[] spanishWords = spanishParser(lineNumberTemp);
                    for(String spanishWord : spanishWords){
                        System.out.print(spanishWord + ", ");
                    }
                    System.out.println();
                }
            }
        }
    }

    private String[] spanishParser(int lineNumber){
        String line = "";
        int lineNumberTemp = 1;
        while(!line.equals("End Of File")){
            line = questionScanner.nextLine();
            line = line.substring(1);
            if(!line.equals("End Of File") && lineNumberTemp == lineNumber){
                return line.split("/");
            }
            else{
                ++lineNumber;
            }
        }
        String[] error = {"broken", "don't trigger"};
        return error;
    }

    private String[] inputParser(String line){
        return line.split(seperator);
    }

}
