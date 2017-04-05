/**
 * Created by greenman on 3/1/16.
 */
public class Phrase  {

    protected String english;

    protected String dragon;

    Phrase(String eng, String fore){

        english = eng;
        dragon = fore;
    }

    Phrase(){
        english = null;
        dragon = null;
    }
    public void display(){

        System.out.print("English: ");
        System.out.println(english);
        System.out.print("Dragon: ");
        System.out.println(dragon);
        System.out.println("");
    }

    public String getEnglish(){return english;}

}
