package sample;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

class DictionaryManagement<n> extends Dictionary{
    public static String require;
    public DictionaryManagement(){

    }
    private static String fileUrl = "F:/DictionaryProject/src/sample/dictionaries.txt";
    private static Scanner sc = new Scanner(System.in);
    public static int qty;
    static Dictionary dict = new Dictionary();
    public static Word wordFromFile[] ;

    static {
        wordFromFile = null;
    }

    static Word a[] = null;


    public static void insertFromCommandline(){
        System.out.println("Nhap vao ban phim so luong tu vung (Word): ");
        qty = sc.nextInt();
        sc.nextLine();
        a = new Word[qty+1];

        for(int i=1; i<=qty; i++){
            a[i] = new Word();
            String eng = sc.nextLine();
            //System.out.println();
            String vin = sc.nextLine();
            /*dict.getWordArrayList().get(i).setWord_target(eng);
            dict.getWordArrayList().get(i).setWord_explain(vin);*/
            //dict.setWordArrayList(new Word(eng,vin));
            a[i].setWord_target(eng.toLowerCase());
            a[i].setWord_explain(vin.toLowerCase());


            System.out.println();
        }
        for(int i=1;i<=qty;i++){
            dict.wordArrayList.add(new Word(a[i].getWord_target(), a[i].getWord_explain()));
        }
    }
    public static void insertFromFile() throws FileNotFoundException {
        File file = new File(fileUrl);
        InputStream inputStream = new FileInputStream(file);

        Scanner scanner = new Scanner(inputStream);
        ArrayList<Word> temp = new ArrayList();
        while(scanner.hasNext()){
            String ws = scanner.nextLine();
            Word word = new Word();
            word.splitWord(ws);
            temp.add(word);
        }
        scanner.close();
        wordFromFile = new Word[temp.size()+100];
        for(int i=0;i<temp.size();i++){
            wordFromFile[i] = new Word();
            wordFromFile[i] = temp.get(i);
        }
    }
    public static void dictionaryLookup(){
        try {
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println("Nhap tu ban muon tra cuu: ");
                String wordFind = sc.nextLine();
                wordFind = wordFind.toLowerCase();
                for(int i=0;i<wordFromFile.length;i++){
                    if(wordFromFile[i].getWord_target().equalsIgnoreCase(wordFind)){
                        System.out.println(wordFromFile[i].getWord_explain());
                        break;
                    }
                }
                System.out.println("Neu muon xem tu dien nhan phim 'y'");
                System.out.println("Neu muon thoat nhan phim 'e'");
                System.out.println("Neu muon tra cuu nhan phim bat ky");
                require = sc.nextLine();
                if(require.equalsIgnoreCase("y") || require.equalsIgnoreCase("e")) break;

            }
        }catch (NullPointerException e){
            System.out.println(e);
        }
    }


}
