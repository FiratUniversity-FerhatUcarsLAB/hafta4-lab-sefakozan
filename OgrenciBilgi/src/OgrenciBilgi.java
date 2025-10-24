 /*
  * Ad Soyad: Muhammet Sefa KOZAN
  * Ogrenci No: 250541057
  * Tarih: 24/10/2025
  * Aciklama: Ogrenci Bilgi
  */

 import java.util.Scanner;

 public class OgrenciBilgi {
     public static void main(String[] args) {
         // Scanner nesnesi olusturuldu
         Scanner scanner = new Scanner(System.in);

         System.out.print("=== OGRENCI BILGI SISTEMI ===\n");

         System.out.print("Adinizi girin: ");
         String ad = scanner.nextLine();

         System.out.print("Soyadinizi girin: ");
         String soyad = scanner.nextLine();

         System.out.print("Ogrenci numaraniz: ");
         int ogrNo = scanner.nextInt();

         System.out.print("Yasiniz: ");
         int yas = scanner.nextInt();

         System.out.print("GPA (0.00-4.00): ");
         double gpa = scanner.nextDouble();

         // Not: Scanner.close() cagrisi System.in'i de kapatir.
         // Bu yüzden program boyunca sadece en sonda bir kez kullanilmalidir.
         // Birden fazla close() cagrisi hata verir!
         scanner.close();

         // Ogrencinin basarili olup olmadigi kontrol edilir
         // Basarili olma durumu gpa 2'den buyuk ve esitse olur
         String durum;
         if(gpa >= 2)
         {
             durum = "Basarili Ogrenci";
         }
         else{
             durum = "Basarisiz Ogrenci";
         }

         System.out.print("\n=== OGRENCI BILGI SISTEMI ===\n");
         System.out.printf("Ad Soyad: %s %s\n", ad, soyad);
         System.out.printf("Ogrenci No: %d\n", ogrNo);
         System.out.printf("Yas: %d\n", yas);
         System.out.printf("GPA: %.2f\n", gpa);
         System.out.printf("Durum: %s\n", durum);
     }
 }
