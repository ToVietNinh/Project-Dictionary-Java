package ProjectManagerOOP01;

public class DictionaryCommandline extends DictionaryManagement{
    static DictionaryCommandline dicComLine = new DictionaryCommandline();
    public static void showAllWords(){
        int index = 1;
        System.out.println("No" + "   " + "|"+"English" + "          |" + "  Vietnamese");
        for(int i=0; i<dicComLine.qty; i++){
            System.out.println(index + "   " + "|"+dicComLine.getWordArrayList().get(i).getWord_target()
                    + "          |" + dicComLine.getWordArrayList().get(i).getWord_explain());
            ;
        }
        System.out.println("...");

    }
    public static void dictionaryBasic(){
        insertFromCommandline();
        showAllWords();
    }
    public static void main(String [] args) throws Exception{
        dictionaryBasic();
    }
}
