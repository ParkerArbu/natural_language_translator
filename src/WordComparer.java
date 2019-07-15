

public class WordComparer {

    private TextParse parser;
    private final String englishDictionary = "src/english_words.txt";
    private final String inputFile = "src/input.txt";

    public static void main(String[] args){
        new WordComparer();
    }

    private WordComparer(){
        TextParse.init(inputFile);


        System.out.println();

        TextParse.init(englishDictionary);
        TextParse.readerAndWriter(englishDictionary, "");
    }

}
