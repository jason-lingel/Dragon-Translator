/**
 * Created by greenman on 3/4/16.
 */
public class ListNode {

    protected Phrase [] phrases = new Phrase[10];

    protected String category;

    protected String getCategory(){return category;}

    protected ListNode next;

    protected ListNode getNext(){return next;}

    ListNode(){

        category = null;
        next = null;
        for(int i=0; i<10; ++i)
            phrases[i]= new Phrase();
    }

    ListNode(String cat){

        category = cat;
        next = null;
        for(int i=0; i<10; ++i)
            phrases[i]= new Phrase();
    }

    public void addToList(Phrase inc){

        for(int i = 0; i<10; ++i){
            if(phrases[i].getEnglish() == null) {
                phrases[i] = inc;
                return;
            }
        }
    }
    public void connect(String cat){
        this.next = new ListNode(cat);

    }


    public void display_all(){

        System.out.println(category);
        for(int i = 0; i<10;++i){
            if(phrases[i].getEnglish() == null)
                return;
            phrases[i].display();
        }
    }
}
