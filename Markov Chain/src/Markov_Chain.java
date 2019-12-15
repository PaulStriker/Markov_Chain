import java.util.List;

public class Markov_Chain {

    String Satz;
    Wort letztesWort;
    List<Wort> Woerter;
    public Markov_Chain(String Startwort, int Länge,List<Wort> Dictionary)
    {
        Woerter = Dictionary;
        Satz = Startwort;
        for(Wort w: Woerter)
        {
            if(w.getAnzeige().equals(Startwort))
            {
               letztesWort = w;
               break;
            }
        }
        for(int i=0; i < Länge-1;i++)
        {
            erweitereSatz();
        }
    }

    public void erweitereSatz()
    {
        Wort tmp = getNextWord(letztesWort);
        Satz = Satz + " " + tmp.getAnzeige();
        letztesWort = tmp;
    }

    public Wort getNextWord(Wort Ende)
    {
        double r = Math.random();
        double sum_of_probs = 0.0;
        int gesamtzahlVorkommen = Ende.getSummeNachfolger();
        for(int i = 0; i < Ende.Pointer; i++ )
        {
            String[] a = Ende.getNachfolger()[i];
            int itmp = Integer.parseInt(a[1]);
            double dtmp = (double) itmp / gesamtzahlVorkommen;
            sum_of_probs = sum_of_probs + dtmp;
            if(sum_of_probs > r)
            {
                Wort tmp;
                for(Wort w : Woerter)
                {
                    if(w.getAnzeige().equals(a[0]))
                    {
                        return w;
                    }
                }
            }
        }
        return Woerter.get(0);
    }

    public String getSatz(){return Satz;}
}
