import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EinleseTool {

    List<Wort> Woerter = new LinkedList<>();

    public EinleseTool() throws IOException
    {
        lese_ein();
    }

    public void lese_ein() throws  IOException
    {
        BufferedReader b1 = new BufferedReader(new FileReader("kleineTextdatei.txt"));

        String zeile1;
        String zeile2="a";
        boolean added;
        zeile1 = b1.readLine();

        while(!(zeile1.equals("") && zeile2.equals("")))
        {
            zeile2 = zeile1;
            zeile1 = b1.readLine();
            if(zeile1.equals(""))
            {
                zeile2 = b1.readLine();
                zeile1 = b1.readLine();
            }
            added = false;
            for (Wort w : Woerter)
            {
                if (zeile2.equals(w.getAnzeige()))
                {
                    Wort tmp = new Wort(zeile1);
                    w.addNachfolger(tmp);
                    added = true;
                }
            }
            if(!added)
            {
                Wort tmp = new Wort(zeile2);
                Woerter.add(tmp);
            }
        }
    }

    public List<Wort> getWoerter()
    {
        return Woerter;
    }
}
