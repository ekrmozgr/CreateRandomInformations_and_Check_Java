/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RASTGELEKISIURET;

import static RASTGELEKISIURET.KimlikNo.*;
import static RASTGELEKISIURET.RastgeleKisi.*;
import static RASTGELEKISIURET.IMEINo.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author ekrem
 */
public class Kisi {
    private final KimlikNo tc;
    private final String isim_soyisim;
    private final int yas;
    private final Telefon telefon;
    public Kisi()
    {
        isim_soyisim = isim_soyisim_sec();
        yas = yas_sec();
        tc = new KimlikNo();
        telefon = new Telefon();
    }
    
    public void txt_Yazdir() throws IOException
    {
        File file = new File("Kisiler.txt");
        if (!file.exists()) {
            file.createNewFile();
        }   
        FileWriter fileWriter = new FileWriter(file,true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(tc.tc_dondur() + " " + isim_soyisim + " " + yas + " " + telefon.telNo_dondur() + " " + "("+ telefon.imei_dondur()+")");
        bWriter.newLine();
        bWriter.close();
    }
    public static void txt_Oku() throws IOException
    {
        int gecerli_tc = 0;
        int gecersiz_tc = 0;
        int gecerli_imei = 0;
        int gecersiz_imei = 0;
        File file = new File("Kisiler.txt");
        if (file.exists()) {
            Scanner _icerik = new Scanner(file);
            int a = 1;
            while(_icerik.hasNext())
            {         
                
                String temp = _icerik.next();
                long _tc = Long.parseLong(temp);
                if(isValidTC(_tc))
                    gecerli_tc++;
                else
                    gecersiz_tc++;
                temp = _icerik.next(); temp = _icerik.next(); temp = _icerik.next(); temp = _icerik.next(); temp = _icerik.next();
                String imei_no = temp.substring(temp.indexOf("(") + 1, temp.indexOf(")"));
                if(isValidIMEI(Long.parseLong(imei_no)))
                    gecerli_imei++;
                else
                {   System.out.println(a);
                    gecersiz_imei++;}
                a++;
            }
            System.out.println("T.C. Kimlik Kontrol");
            System.out.println(gecerli_tc + " Gecerli");
            System.out.println(gecersiz_tc+ " Gecersiz" + "\n");
            System.out.println("IMEI Kontrol");
            System.out.println(gecerli_imei + " Gecerli");
            System.out.println(gecersiz_imei + " Gecersiz"+"\n");
        }
        else
            System.out.println("Dosya bulunamadi ! "+"\n");
    }
}
