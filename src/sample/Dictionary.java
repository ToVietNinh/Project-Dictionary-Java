package sample;
import java.util.ArrayList;

public class Dictionary{

    public ArrayList <Word> wordArrayList = new ArrayList<Word>();

    public Dictionary() {
    }

    public Dictionary(ArrayList<Word> wordArrayList) {
        this.setWordArrayList(wordArrayList);
    }

    public ArrayList<Word> getWordArrayList() {
        return wordArrayList;
    }

    public void setWordArrayList(Word word) {
        this.setWordArrayList(getWordArrayList());
    }

    public void setWordArrayList(ArrayList<Word> wordArrayList) {
        this.wordArrayList = wordArrayList;
    }
}
