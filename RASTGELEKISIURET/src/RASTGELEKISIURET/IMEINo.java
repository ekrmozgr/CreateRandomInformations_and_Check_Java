/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RASTGELEKISIURET;

import static RASTGELEKISIURET.Rastgele.*;

/**
 *
 * @author ekrem
 */
public class IMEINo {
    public static long imei_olustur()
    {
        int[] ilk_iki ={10,30,33,35,44,45,49,50,51,52,53,54,86,91,98,99};      
        long ilk_ondort = ilk_iki[randomPositiveInt(ilk_iki.length)];
        String basamaklar = "";
        int len = 2;
        long sayi_gecici = 0;
        while(true)
        {
            while(basamaklar.length() != 6)
            {
            sayi_gecici = randomPositiveLong(999999L)+1;
            basamaklar = Long.toString(sayi_gecici);
            }
        len = basamaklar.length() + len;
        for(int b = 0;b < basamaklar.length();b++)
        {
            ilk_ondort *= 10;
            if(b == basamaklar.length()-1)
            {
                ilk_ondort += sayi_gecici;
            }
        }
        if(len == 14)
            {
                break;
            }
        }
        int sum = 0; 
        long temp = ilk_ondort;
        for (int i = len; i >= 1; i--) 
        { 
            int d = (int)(temp % 10); 

            if (i % 2 == 0) 
                d = 2 * d; 

            sum += sumDig(d); 
            temp = temp / 10; 
        } 
        int onbesinci_rakam = 0;
        while(sum % 10 != 0)
        {
            sum++;
            onbesinci_rakam++;
        }
        long imei_no = ilk_ondort * 10 + onbesinci_rakam;
        return imei_no;
    }
    
    public static int sumDig(int n) 
    { 
        int a = 0; 
        while (n > 0) 
        { 
            a = a + n % 10; 
            n = n / 10; 
        } 
        return a; 
    } 
    
    public static boolean isValidIMEI(long n) 
    { 
        String s = Long.toString(n); 
        int len = s.length(); 
  
        if (len != 15) 
            return false; 
  
        int sum = 0; 
        for (int i = len; i >= 1; i--) 
        { 
            int d = (int)(n % 10); 

            if (i % 2 == 0) 
                d = 2 * d; 
  
            sum += sumDig(d); 
            n = n / 10; 
        } 
  
        return (sum % 10 == 0); 
    } 
}
