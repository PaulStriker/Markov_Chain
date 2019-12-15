public class Wort {
    String [][] Nachfolger;
    String Anzeige;
    int Pointer;

    public Wort(String Wort)
    {
        Anzeige = Wort;
        Pointer = 0;
        Nachfolger = new String[50][2];
    }

    public void addNachfolger(Wort nachfolger)
    {
        boolean nachfolgerGefunden = false;
        for(int i = 0; i < Pointer;i++)
        {
            String[] a = Nachfolger[i];
           if(nachfolger.getAnzeige().equals(a[0]))
            {
                String tmp = a[1];
                int Vorkommen = Integer.parseInt(tmp);
                Vorkommen++;
                a[1] = ""+Vorkommen;
                nachfolgerGefunden = true;
                break;
            }
        }
        if(!nachfolgerGefunden)
        {
            String[] tmp = new String[2];
            tmp[0] = nachfolger.getAnzeige();
            tmp[1] = ""+1;
            if(Pointer == Nachfolger.length-1)
            {
                arrayVergrößern();
            }
            Nachfolger[Pointer] = tmp;
            Pointer++;
        }
    }

    public String getAnzeige(){return Anzeige;}
    public String[][] getNachfolger() { return Nachfolger;}
    public int getSummeNachfolger()
    {
        int zaehler = 0;
        for(int i =0;i< Pointer;i++)
        {
            zaehler += Integer.parseInt(Nachfolger[i][1]);
        }
        return zaehler;
    }

    public void arrayVergrößern()
    {
        int i;
        int j = 0;
        String[][] tmp = new String[Pointer+50][2];
        for(String[] a : Nachfolger)
        {
            i = 0;
            for(String s : a)
            {
               tmp[j][i] = s;
               i++;
            }
            j++;
        }
    }

}
