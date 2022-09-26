package dat;

import apple.laf.JRSUIConstants;

public class Dat
{
    public static int Mes(int m)
    {
        if(m == 1 || m == 10)
        {
            return 6;
        }
        else if(m == 4 || m == 7)
        {
            return 5;
        }
        else if(m == 9 || m == 12)
        {
            return 4;
        }
        else if(m == 6)
        {
            return 3;
        }
        else if(m == 2 || m == 3 || m == 11)
        {
            return 2;
        }
        else if(m == 8)
        {
            return 1;
        }
        else if(m == 5)
        {
            return 0;
        }
        else return -1;
    }

    public static String Wkd(int d)
    {
        int a = d%7;
        if (a < 0)
            a += 7;

        switch (a)
        {
            case 0:
                return "Nedelja";
            case 1:
                return "Ponedeljak";
            case 2:
                return "Utorak";
            case 3:
                return "Sreda";
            case 4:
                return "Cetvrtak";
            case 5:
                return "Petak";
            case 6:
                return "Subota";
        }
        return "-1";
    }

    public static int maxD (int d,boolean prov)
    {
        int a = 0;
        int b = 1;
        if (d == 1 || d == 3 || d == 5 || d == 7 || d == 8 || d == 10 || d == 12)
            b = 3;
        else if (d == 4 || d == 6 || d == 9 || d == 11)
            b = 1;
        else if (d == 2 && !prov)
            b = 2;
        else if (d == 2)
            b = 4;


        switch (b)
        {
            case 1:
                a = 30;
                break;
            case 2:
                a = 28;
                break;
            case 3:
                a = 31;
                break;
            case 4:
                a = 29;
                break;
        }
        return a;
    }
}
