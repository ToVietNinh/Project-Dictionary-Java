package sample;
import java.io.IOException;
import java.util.Formatter;

public class DictionaryCommandline extends DictionaryManagement {
    public DictionaryCommandline() {

    }

    static DictionaryCommandline dictCommand = new DictionaryCommandline();
    static Dictionary dict = new Dictionary();

    public static void showAllWords() {
        if(dictCommand.require.equalsIgnoreCase("e")) return;
        int index = 1;
        try{
            Formatter formatter = new Formatter();
            formatter.format("%-12s|%-35s|%-35s", "No", "English", "Vietnamese");
            System.out.println(formatter);
            for (int i = 0; i<dictCommand.wordFromFile.length; i++) {
                formatter = new Formatter();
                formatter.format("%-12s|%-35s|%-35s", i, dictCommand.wordFromFile[i].getWord_target()
                        , dictCommand.wordFromFile[i].getWord_explain());
                System.out.println(formatter);
            }
        }catch (NullPointerException e){
            System.out.println(e);
        }
        System.out.println("...");

    }

    public static void dictionaryBasic() {
        //DictionaryManagement.insertFromCommandline();
        //showAllWords();
    }
    public static void dictionaryAdvance() throws IOException {
        DictionaryManagement.insertFromFile();
        DictionaryManagement.dictionaryLookup();
        showAllWords();
    }

}
