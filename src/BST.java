import java.io.*;
import java.util.Scanner;

/**
 * Created by greenman on 3/1/16.
 */
public class BST {

    protected Node root = null;
    protected int traversed = 0;
    protected int depth = 0;
    protected int total =0;

    public int addNode(Node current){

        if(root == null){
           // root = new Node();
            root = current;

        return ++total;
        }



        int c = current.getEnglish().compareToIgnoreCase(root.getEnglish());
        if(c < 0)
           traversed += addNode(root.getLeft(), current);

        if (c > 0)
            traversed += addNode(root.getRight(), current);

        if (traversed > depth)
            depth = balanceTree();

        return depth;
    }

    private int addNode(Node top, Node current){

        int L =1, R=1;
        if(top == null) {
            top = new Node();
            top = current;
            ++total;
            return 1;
        }

        int c = current.getEnglish().compareToIgnoreCase(root.getEnglish());
        if(c < 0)
            L += addNode(top.getLeft(), current);


        else if(c > 0)
            R +=  addNode(top.getRight(), current);


        if(L > R)
            return L;
        else return R;


    }

    public void insertNode(Node current){
        if(root == null){
           // root = new Node();
            root = current;

            ++total;
            return ;
        }


        int c = current.getEnglish().compareToIgnoreCase(root.getEnglish());
        if(c < 0) {
            if (root.getLeft() == null) {
                root.setLeft(current);
                ++total;
                return;
            }
            else {
                insertNode(root.getLeft(), current);
                return;
            }
        }


        if(c > 0) {
            if(root.getRight() == null) {
                root.setRight(current);
                ++total;

            }
            else {
                insertNode(root.getRight(), current);

            }
        }
    }

    public void insertNode(Node top, Node current){

        if(top == null) {
            top = current;

            ++total;
            return;
        }



        int c = current.getEnglish().compareToIgnoreCase(root.getEnglish());
        if(c < 0) {
            if (top.getLeft() == null) {
                top.setLeft(current);
                ++total;
                return;
            }
            else {
                insertNode(top.getLeft(), current);
                return;
            }
        }

        if(c > 0) {
            if(top.getRight()==null) {
                top.setRight(current);
                ++total;

            }
            else {
                insertNode(top.getRight(), current);

            }
        }
    }


    public int balanceTree(){

        Node ghost = new Node();
        ghost.setRight(root);
        int size;
        int increment;
        size = straighten(ghost);
        double d = Math.ceil(Math.log(size+1));
        int i =(int) (Math.pow(2, d));
        int count = (size+1 ) - i;
        rebuild(ghost, count);
        increment = size  - count;
        while(increment > 1){

            rebuild(ghost, increment/2);
            increment = increment/2;
        }
        root = ghost.getRight();
        return findDepth();
        //return findDepth();


    }

    private int findDepth(){
        int d = 0;
        int l = 0;
        int r = 0;
        if(root == null)
            return 0;
        l =findDepth(root.getLeft());
        r = findDepth(root.getRight());

        if(l>r)
            return l;
        else
            return r;

    }

    private int findDepth(Node top){
        int l= 1;
        int r=1;
        if(top == null)
            return 0;
        l += findDepth(top.getLeft());
        r += findDepth(top.getRight());

        if(l>r)
            return l;
        else
            return r;

    }

    private int straighten(Node ghost){

        Node tail, rem, temp;
        int count = 0;

        tail = ghost;
        rem = tail.getRight();

        while(rem != null){

            if(rem.getLeft() == null){
                tail = rem;
                rem = rem.getRight();
                ++count;
            }
            else
            {
                temp = rem.getLeft();
                rem.setLeft(temp.getRight());
                temp.setRight(rem);
                rem = temp;
                tail.setRight(temp);

            }
        }

        return count;
    }

    public void rebuild(Node ghost, int count){

        Node parent, child;


        parent = ghost;

        for(int i=0; i < count; ++i) {
           // if(parent.getRight() == null)
           //     parent.setRightNew();
            child = parent.getRight();
           // if(child.getRight() == null)
            //    child.setRightNew();
            parent.setRight(child.getRight());
           // if(parent.getRight() == null)
            //    parent.setRightNew();
            parent = parent.getRight();
           // if(parent.getLeft() == null)
            //    parent.setLeftNew();
            child.setRight(parent.getLeft());
            parent.setLeft(child);
        }

    }

    public void removeAll(){

        removeBranch(root.getRight());
        removeBranch(root.getLeft());
        root.setLeft(null);
        root.setRight(null);

    }

    public void removeBranch(Node top){

        if(top == null)
            return;
        removeBranch(top.getRight());
        removeBranch(top.getLeft());

        top.setLeft(null);
        top.setRight(null);
        return;
    }

    public void display(){

        if(root == null)
            return;
        display(root.getLeft());
        root.display();
        display(root.getRight());

    }

    public void display(Node top){

        if(top == null)
            return;
        display(top.getLeft());
        top.display();
        display(top.getRight());



    }
    public void retrieve(String eng){
        int c = eng.compareToIgnoreCase(root.getEnglish());
        if(c==0)
            root.display();
        if(c > 0)
            retrieve(root.getLeft(), eng);
        if(c<0)
            retrieve(root.getRight(), eng);

    }

    public void retrieve(Node current, String eng){
        if(current==null){
            System.out.println("No match");
            return;
        }
        int c = eng.compareToIgnoreCase(current.getEnglish());
        if(c==0)
            current.display();
        if(c > 0)
            retrieve(current.getLeft(), eng);
        if(c<0)
            retrieve(current.getRight(), eng);
    }

    public void loadTree()throws IOException{

        File inFile=new File("words.txt");
        Scanner in=new Scanner(inFile);

        in.useDelimiter("[,\n]");
        String eng;
        String drag;
        Node word;

        while(in.hasNext()){

            eng=in.next();
            if(eng == "\n")
                break;
            drag=in.next();

            word=new Node(eng,drag);

            insertNode(word);

            in.hasNext();

        }

        in.close();
    }

}





