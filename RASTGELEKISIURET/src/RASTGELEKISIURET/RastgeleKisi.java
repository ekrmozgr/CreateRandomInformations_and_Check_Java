/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RASTGELEKISIURET;
import static RASTGELEKISIURET.Rastgele.randomPositiveInt;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author ekrem
 */
public class RastgeleKisi {
    public static String isim_soyisim_sec()
    {
        String tmp = null;
        String icerik = "random_isimler.txt";
        File dosya = new File(icerik);
        
        if(dosya.exists())
        {
            try{
            Scanner _icerik = new Scanner(dosya);
            int kisi = randomPositiveInt(3000) + 1;
            for(int i = 0;i< kisi;i++)
            {
                tmp = _icerik.nextLine();
            }          
            _icerik.close();
            }
            catch(FileNotFoundException FNFE)
            {
            }
        }
      return tmp;
    }
    public static int yas_sec()
    {
        int yas = randomPositiveInt(99) + 1;
        return yas;
    }
}
