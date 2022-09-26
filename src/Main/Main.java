package Main;

import apple.laf.JRSUIConstants;
import sun.jvm.hotspot.debugger.posix.elf.ELFException;
import sun.swing.StringUIClientPropertyKey;

import java.util.Date;
import java.util.Scanner;

import static dat.Dat.*;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String str = "";

        boolean prov1 = true;
        do
        {
            System.out.println("Ukucajte Datum(DD.MM.YYYY)");
            str = sc.nextLine();
            if(str.split("\\.").length==3)
            {
                prov1 = false;
            }
            if (!prov1)
            {
                try {
                    if((Integer.parseInt((str.split("\\."))[0]) >= 1 && Integer.parseInt((str.split("\\."))[0]) <= maxD((Integer.parseInt((str.split("\\."))[1])), (Integer.parseInt((str.split("\\."))[2])%4==0 && !(Integer.parseInt((str.split("\\."))[2])%400==0)))))
                    {
                        if (!(Integer.parseInt((str.split("\\."))[1]) >= 1 && Integer.parseInt((str.split("\\."))[1]) <= 12))
                        {
                            prov1 = true;
                        }
                    }
                    else {prov1 = true;}
                }
                catch (Exception e)
                {
                    System.out.println("Unosite samo brojeve");
                }
            }
            if (prov1)
                System.out.println("Unesite pravilan datum");
        }
        while (prov1);

        int br = Integer.parseInt((str.split("\\."))[0]) % 7;
        if (Mes(Integer.parseInt((str.split("\\."))[1]))==-1)
            System.out.println("Nepravilan unos");
        else
            br += Mes(Integer.parseInt((str.split("\\."))[1]));
        int god = Integer.parseInt((str.split("\\."))[2]) - 2000;

        while(god < 0)
        {
            god+=400;
        }
        br += (god + ((god - (god % 4)) / 4) - ((god - (god % 100)) / 100) + ((god - (god % 400)) / 400));


        if ((Integer.parseInt((str.split("\\."))[1]) == 1 || Integer.parseInt((str.split("\\."))[1]) == 2) && Integer.parseInt((str.split("\\."))[2])%4==0 && !(Integer.parseInt((str.split("\\."))[2])%400==0))
        {
            br -= 1;
        }
        System.out.println(Wkd(br));

        int o = 1 - ((br-(Integer.parseInt((str.split("\\."))[0])%7))%7);
        int br1 = 0;
        int md = maxD(Integer.parseInt((str.split("\\."))[1]), (Integer.parseInt((str.split("\\."))[2])%4==0 && !(Integer.parseInt((str.split("\\."))[2])%400==0)));
        int b = Integer.parseInt((str.split("\\."))[0]);

        System.out.println(" Pon Uto Sre Cet Pet Sub Ned");
        for(int i = o; i <= md; i++)
        {
            String a = "";
            if (i == b)
            {
                if ((a + i).length() == 1)
                {
                    System.out.print(" ["+i + "]");br1++;
                }
                else if ((a + i).length() == 2)
                {
                    System.out.print("["+i + "]");br1++;
                }
                if(br1 == 7)
                {
                    br1 = 0;
                    System.out.println("");
                }
            }
            else
            {
                if(i <= 0)
                {
                    System.out.print("    ");br1++;
                }
                else if ((a + i).length() == 1)
                {
                    System.out.print("  "+i + " ");br1++;
                }
                else if ((a + i).length() == 2)
                {
                    System.out.print(" "+i + " ");br1++;
                }
                if(br1 == 7)
                {
                    br1 = 0;
                    System.out.println("");
                }
            }
        }
    }
}
