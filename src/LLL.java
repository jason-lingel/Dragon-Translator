import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by greenman on 3/4/16.
 */
public class LLL {

    protected ListNode head;

    public void addCategory(String cat){
        if(head == null)
            head = new ListNode(cat);
        else
            addCategory(head.getNext(), cat);
    }

    private void addCategory(ListNode current, String cat){
        if(current == null)
            current = new ListNode(cat);
        else
            addCategory(current.getNext(), cat);
    }

    public void addPhrase(String cat, String eng, String drag){
        if(head == null)
             head = new ListNode(cat);
        ListNode current = findCategory(head, cat);
        Phrase inc = new Phrase(eng, drag);
        current.addToList(inc);


    }

    private ListNode findCategory(ListNode current, String cat){
        if(current == null) {
            current = new ListNode(cat);
            return current;
        }
        int c = cat.compareToIgnoreCase(current.getCategory());
        if(c==0)
            return current;
        if(current.getNext() == null)
            current.connect(cat);
        return findCategory(current.getNext(), cat);


    }

    public void loadList()throws IOException {
        File inFile = new File("phrases.txt");
        Scanner in = new Scanner(inFile);

        in.useDelimiter("[,\n]");

        String cat, eng, drag;
        Phrase phrase;

        while(in.hasNext()){

            cat = in.next();
            if(cat == "\n")
                break;
            if(cat == "")
                break;
            eng = in.next();
            drag = in.next();
            addPhrase(cat, eng, drag);
            in.hasNext();
        }
        in.close();
    }

    public void display_cats(){
        if(head == null){
            System.out.println("empty list");
            return;
        }

         display_cats(head);

    }

    public void display_cats(ListNode current){

        if(current == null)
            return;


        System.out.println(current.getCategory());
        display_cats(current.getNext());



    }
    public void display(String cat){
        if(head==null)
            return;
        if(cat.compareToIgnoreCase(head.getCategory())==0)
            head.display_all();
        else
            display(head.getNext(), cat);
    }

    private void display(ListNode current, String cat){
        if(current ==  null)
            return;
        if(cat.compareToIgnoreCase(current.getCategory())==0) {
            current.display_all();
            return;
        }
        display(current.getNext(), cat);
    }

    public void display_all(){
        if(head == null)
            return;
        head.display_all();
        display_all(head.getNext());



    }

    private void display_all(ListNode current){
        if(current == null)
            return;
        current.display_all();
        display_all(current.getNext());
    }
}
