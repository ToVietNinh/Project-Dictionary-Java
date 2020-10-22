package sample;
public class Word {
    private String word_target;
    private String word_explain;

    public Word(){

    }
    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    public static void add(Word word) {
        Word.add(word);
    }

    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public void splitWord(String str){
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == ':'){
                this.word_target = str.substring(0,i);
                this.word_explain = str.substring(i+1);
                break;
            }
        }
    }
}
