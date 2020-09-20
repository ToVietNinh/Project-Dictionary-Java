package ProjectManagerOOP01;

import java.util.ArrayList;
import java.util.Scanner;

class DictionaryManagement extends Dictionary{
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Word> wordArrayList = new ArrayList<Word>();
    public static int qty;
    static DictionaryManagement dicManagement = new DictionaryManagement();
    public static void insertFromCommandline(){
        System.out.println("Nhap vao ban phim so luong tu vung (Word): ");
        qty = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<qty; i++){
            String eng = sc.nextLine();
            System.out.println();
            dicManagement.getWordArrayList().get(i).setWord_target(eng);
            String vin = sc.nextLine();
            dicManagement.getWordArrayList().get(i).setWord_explain(eng);
            System.out.println();
        }
    }


}
