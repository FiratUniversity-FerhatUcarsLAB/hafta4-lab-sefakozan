 /*
  * Ad Soyad: Muhammet Sefa KOZAN
  * Ogrenci No: 250541057
  * Tarih: 24/10/2025
  * Aciklama: Geometrik Hesaplama
  *
  * Kullanicidan bir yaricap (r) alir ve bu degere gore
  * daire ve kure ile ilgili geometrik hesaplamalari yaparak sonuclari formatli sekilde ekrana yazdirir.
  */

 import java.util.Scanner;

 public class GeometrikHesap {
    public static void main(String[] args) {
        // Scanner nesnesi olusturuldu
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== GEOMETRIK HESAPLAYICI ===");
        System.out.print("Yaricapi giriniz: ");
        int r = scanner.nextInt();

        // Hesaplamalar
        final double PI = 3.14159;
        double daireAlani = PI * Math.pow(r, 2);
        double daireCevresi = 2 * PI * r;
        double daireCapi = 2 * r;
        double kureHacmi = (4.0/3) * PI * Math.pow(r,3);
        double kureYuzeyAlani = 4 * PI * Math.pow(r, 2);

        // Bosluklar formatli yazdirildi
        System.out.println("\nSONUCLAR: ");
        System.out.println("-".repeat(15));
        System.out.printf("Daire Alani %-8s: %.2f  cm^2\n", " ", daireAlani);
        System.out.printf("Daire Cevresi %-6s: %.2f  cm\n", " ", daireCevresi);
        System.out.printf("Daire Capi %-9s: %.2f  cm\n", " ", daireCapi);
        System.out.printf("Kure Hacmi %-9s: %.2f cm^3\n", " ", kureHacmi);
        System.out.printf("Kure Yuzey Alani %-3s: %.2f cm^2\n", " ", kureYuzeyAlani);

        // Not: Scanner.close() cagrisi System.in'i de kapatir.
        scanner.close();
    }
}
