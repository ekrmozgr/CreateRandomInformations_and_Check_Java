/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RASTGELEKISIURET;

import static RASTGELEKISIURET.IMEINo.imei_olustur;
import static RASTGELEKISIURET.Rastgele.randomPositiveInt;

/**
 *
 * @author ekrem
 */
public class Telefon {
    private final long imeiNo;
    private final String telNo;
    public Telefon()
    {
        imeiNo = imei_olustur();
        telNo = "0" + telNoBaslangic()+ Integer.toString(telNoDevami());
    }
    
    private String telNoBaslangic()
    {
        String [] kodlar = {"501","505","506","507","551","552","553","554","555","559","530","531","532","533","534","535","536","537"
                            ,"538","539","561","540","541","542","543","544","545","546","547","548","549"};
        int random_sayi = randomPositiveInt(kodlar.length);
        return kodlar[random_sayi];
    }
    private int telNoDevami()
    {
        int random_tel = 0;
        while(true)
        {
        random_tel = randomPositiveInt(9999999) + 1;
        String kontrol = Integer.toString(random_tel);
        int len = kontrol.length();
        if(len == 7)
        {
            break;
        }
        }
        return random_tel;
    }
    protected long imei_dondur()
    {
        return imeiNo;
    }
    protected String telNo_dondur()
    {
        return telNo;
    }
}
