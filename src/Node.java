/**
 * Created by greenman on 3/1/16.
 */
public class Node extends Word{

    protected Node left;
    protected Node right;

    Node(){

        left = null;
        right = null;
    }



    Node(String engIn, String dragIn){

        super(engIn,dragIn);
        left = null;
        right = null;

    }

    public Node getLeft() {return left;}
    public Node getRight() {return right;}
    public void setRight(Node other){
        this.right = other;
    }
    public void setRightNew(){
        this.right = new Node();
    }
    public void setLeftNew(){
        this.left = new Node();
    }
    public void setLeft(Node other){
        this.left = other;
    }



}
