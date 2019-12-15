import java.io.IOException;

public class mainClass {

    public static void main(String[] args)
    {
        try{
            EinleseTool ET1 = new EinleseTool();
            Markov_Chain chain = new Markov_Chain("der",10,ET1.getWoerter());
            System.out.println(chain.getSatz());
        }
        catch (IOException e)
        {
            System.out.println("Es gab eine Exception beim Einlesen der Textdatei");
        }

    }

}
