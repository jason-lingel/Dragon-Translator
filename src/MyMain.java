/**
 * Jason Lingel
 * CS 202
 * Program 4.
 */
//import com.sun.org.apache.xpath.internal.operations.String;


import java.io.*;
import java.util.Scanner;
public class MyMain{

    public static void main(String[] args)throws IOException {
        BST wordTree = new BST();

        LLL list = new LLL();


        Scanner in = new Scanner(System.in);
        list.loadList();
        //list.display_all();

        wordTree.loadTree();
        wordTree.balanceTree();
        // wordTree.display();
        int select =0;
        while(select != 3) {
            select=0;
        System.out.println("Welcome to the Dragon Translator!");
        System.out.println("1. Words");
        System.out.println("2. Phrases");
        System.out.println("3. Exit");

        select = in.nextInt();

            switch (select) {

                case 1:
                    words(wordTree);
                    break;
                case 2:
                    phrases(list);
                    break;
            }
        }

    }

    public static void words(BST worldTree){
        Scanner in = new Scanner(System.in);
        int select = 0;
        while(select!=3) {
            select = 0;
        System.out.println("1. Search");
        System.out.println("2. Display all");
        System.out.println("3. Back");
        select = in.nextInt();

            switch (select) {

                case 1:
                    search(worldTree);
                    break;
                case 2:
                    worldTree.display();

            }
        }


    }
    public static void search(BST worldTree){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a term to search for");

        String eng = in.nextLine();

        worldTree.retrieve(eng);


    }

    public static void phrases(LLL list){

        Scanner in = new Scanner(System.in);
        int select =0;
        while(select!= 3) {
            select = 0;
        System.out.println("1. View categories");
        System.out.println("2. list all");
        System.out.println("3. back");
            select = in.nextInt();

            switch (select) {

                case 1:
                    categories(list);
                    break;
                case 2:
                    list.display_all();
            }
        }

    }

    private static void categories(LLL list){
        Scanner in = new Scanner(System.in);
        list.display_cats();
        System.out.println("Select a category to display (not the number)");

        String cat = in.nextLine();
        list.display(cat);
    }

}
