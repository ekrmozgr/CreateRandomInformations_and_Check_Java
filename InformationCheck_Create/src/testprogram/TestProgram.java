/**
*
*   Ekrem Ozgur G181210070 -- Ömer Sercan Kandemir G140910013 
*   @since  04.04.2020 	
* <p>
*   TestProgram.java
* </p>
*/

package testprogram;
import RASTGELEKISIURET.Kisi;
import java.io.IOException;
import java.util.Scanner;

public class TestProgram {

    static void Yazdir()
    {     
        System.out.println("1- Rastgele Kisi Uret");
        System.out.println("2- Uretilmis Dosya Kontrol Et");
        System.out.println("3- Cikis");
        System.out.print("Secim : ");
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        boolean kontrol = true;
        Kisi[] kisiler;
        Scanner giris = new Scanner(System.in);
        int secim;
        Yazdir();
        secim=giris.nextInt();
        while(kontrol){
  
        switch(secim)
        {
            case 1:
                System.out.print("Kac Kisi : ");
                int kisi_sayisi = giris.nextInt();
                kisiler = new Kisi[kisi_sayisi];
                for(int i = 0;i< kisi_sayisi;i++)
                {   
                    kisiler[i] = new Kisi();                   
                    kisiler[i].txt_Yazdir();
                }
                Yazdir();
                secim = giris.nextInt();
                break;
            case 2 :
                Kisi.txt_Oku();
                Yazdir();
                secim = giris.nextInt();
                break;
            case 3 :
                kontrol = false;
                break;
            default:
                Yazdir();
                secim = giris.nextInt();
                break;
        }
        
        }
        giris.close();
    }
    
}
