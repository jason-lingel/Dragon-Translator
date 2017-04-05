/**
 * Created by greenman on 3/11/16.
 */
public class TravelGuide {

    protected String title;

    protected String description;

    TravelGuide(){
        title = null;
        description = null;
    }

    public void display(){
        System.out.println(title);
        System.out.println("/n");
        System.out.println(description);
        System.out.println("/n");
    }
}
