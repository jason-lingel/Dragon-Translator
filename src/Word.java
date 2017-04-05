
/**
 * Created by greenman on 3/3/16.
 */
public class Word {

    Word(String engIn, String dragIn){

        english = engIn;

        dragon = dragIn;



    }

    Word(){

        english = null;
        dragon = null;
    }

    protected String english;

    protected String dragon;




    public String getEnglish(){return english;}

    public String getDragon() {return dragon;}

    public void display(){

        System.out.print("English: " );
        System.out.println(english);

        System.out.print("Dragon: " );
        System.out.println(dragon);
       System.out.println("\n");
    }


}
