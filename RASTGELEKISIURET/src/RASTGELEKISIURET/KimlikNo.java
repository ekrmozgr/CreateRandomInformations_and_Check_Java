/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RASTGELEKISIURET;

import static RASTGELEKISIURET.Rastgele.randomPositiveInt;

/**
 *
 * @author ekrem
 */
public class KimlikNo {
    private final long TC_No;
    public KimlikNo()
    {
        TC_No = rastgele_tc_uret();
    }
    private long rastgele_tc_uret()
    {
        long tc = 0;
        int ilk_dokuz = 0;
        while(true)
        {
        ilk_dokuz = randomPositiveInt(999999999) + 1;
        String kontrol = Integer.toString(ilk_dokuz);
        int len = kontrol.length();
        if(len == 9)
        {
            break;
        }
        }
        int[] intTab = String.valueOf(ilk_dokuz).chars().map(Character::getNumericValue).toArray();
        int onuncu_rakam = (((intTab[0]+intTab[2]+intTab[4]+intTab[6]+intTab[8]) * 7) - (intTab[1]+intTab[3]+intTab[5]+intTab[7])) % 10;
        int onbirinci_rakam = (intTab[0] + intTab[1] + intTab[2] + intTab[3] + intTab[4] + intTab[5] + intTab[6] + intTab[7] + intTab[8] + onuncu_rakam) % 10;
        for( int i=0; i < intTab.length; i++){
        tc*=10;
        tc+=intTab[i];
        if(i == intTab.length -1)
        {
            tc*=10;
            tc+=onuncu_rakam;
            tc*=10;
            tc+=onbirinci_rakam;
        }
        }
        return tc;
    }
    public static boolean isValidTC(long TC)
    {   int[] intTab = String.valueOf(TC).chars().map(Character::getNumericValue).toArray();
        if(intTab.length != 11)
        {
            return false;
        }
        int sum1 = 0;
        int sum2 = 0;
        if(intTab[0] == 0)
        {
            return false;
        }
        for (int i = 0; i < 9; i++) 
        { 
            if (i % 2 == 0) 
                sum1 += intTab[i]; 
            else
                sum2 += intTab[i];            
        } 
        int onuncu_hane = (sum1 * 7 - sum2) % 10;
        if(onuncu_hane != intTab[9])
        {
            return false;
        }
        int onbirinci_hane = (sum1 + sum2 + onuncu_hane) % 10;
        return onbirinci_hane == intTab[10];
    }
    public long tc_dondur()
    {
        return TC_No;
    }
}
