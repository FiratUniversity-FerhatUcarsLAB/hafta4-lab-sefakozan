/*
 * Ad Soyad: Muhammet Sefa KOZAN
 * Ogrenci No: 250541057
 * Tarih: 24/10/2025
 * Aciklama: Maas Hesaplama
 *
 * Calisanin kisisel bilgileri, brut maasi, mesai saatleri gibi verileri alir ve
 * gelirler, kesintiler, net maas ile birlikte istatistiksel analizler yaparak formatli bir bordro ciktisi uretir.
 */

/*
 *         // %-30s  --> %s ile yazdırır, sola hizalı şekilde sağa boşluk
 *         // %30s   --> %s ile yazdırır, sağa hizalı şekilde sola boşluk
 *         // %7.3f  --> 3.14159   --> Çıktı: [  3.141] 7 karakter (. dahili)
 *         // %-30.3f  --> 3.14159   --> Çıktı: [3.141`25 boşluk`] (. dahil)
 *         // %.3s   --> Merhaba   --> Çıktı: [Mer] ilk 3 karakter
 *         // %05d   --> 42        --> Çıktı: 00042
 *         // %,d    --> 1234567   --> 1,234,567
 *         // %+d    --> 42        --> +42
 */

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MaasHesap {
    public static void main(String[] args) {
        // Scanner nesnesi olusturuldu
        Scanner scanner = new Scanner(System.in);

        System.out.print("Adiniz: ");
        String ad = scanner.nextLine();

        System.out.print("Soyadiniz: ");
        String soyad = scanner.nextLine();

        System.out.print("Aylik Brut Maas (TL): ");
        double brutMaas = scanner.nextDouble();

        System.out.print("Haftalik Calisma Saati: ");
        int calismaSaati = scanner.nextInt();

        System.out.print("Haftalik Mesai Saati: ");
        int mesaiSaati = scanner.nextInt();

        // ------- HESAPLAMALAR YAPILIR -------
        // Gelirler
        double mesaiUcreti = (brutMaas / 160) * calismaSaati * 1.5;
        double toplamGelir = brutMaas + mesaiUcreti;

        // Kesintiler
        final double SGK_ORANI = 0.14;
        final double GELIR_VERGISI_ORANI = 0.15;
        final double DAMGA_VERGISI_ORANI = 0.00759;

        double sgk = toplamGelir * SGK_ORANI;
        double gelirVergisi = toplamGelir * GELIR_VERGISI_ORANI;
        double damgaVergisi = toplamGelir * DAMGA_VERGISI_ORANI;
        double toplamKesinti = sgk + gelirVergisi + damgaVergisi;

        // Net Maas
        double netMaas = toplamGelir - toplamKesinti;

        // Istatistikler
        double kesintiOrani = (toplamKesinti / toplamGelir) * 100;
        double saatlikNetKazanc = netMaas / 176; // 22 gün × 8 saat= 176 saat/ay
        double gunlukNetKazanc = netMaas / 22;

        // ------- TABLO YAZDIRILIR -------
        System.out.println("\n" + "=".repeat(45));
        System.out.printf("%15s MAAS BORDROSU\n"," ");
        System.out.println("=".repeat(45));
        System.out.printf("Calisan: %s %s\n", ad, soyad);

        // Tarih formatli sekilde yazdirilir
        LocalDateTime simdikiZaman = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.printf("Tarih: %s\n", simdikiZaman.format(formatter));

        System.out.println("\nGELIRLER:");
        System.out.printf("   Brut Maas %-16s: %.2f TL\n", " ", brutMaas);
        System.out.printf("   Mesai Ucreti (%d saat) %-3s: %.2f  TL\n", mesaiSaati, " ", mesaiUcreti);
        System.out.println("-".repeat(45));
        System.out.printf("   TOPLAM GELIR %-13s: %.2f TL\n", " ", toplamGelir);

        System.out.println("\nKESINTILER:");
        System.out.printf("   SGK Kesintisi (14.0%%) %-4s: %.2f  TL\n", " ", sgk);
        System.out.printf("   Gelir Vergisi (15.0%%) %-4s: %.2f  TL\n", " ", gelirVergisi);
        System.out.printf("   Damga Vergisi (0.8%%) %-5s: %.2f   TL\n", " ", damgaVergisi);
        System.out.println("-".repeat(45));
        System.out.printf("   TOPLAM KESINTI %-11s: %.2f  TL\n", " ", toplamKesinti);
        System.out.printf("NET MAAS %-20s: %.2f TL\n", " ", netMaas);

        System.out.println("\nISTATISTIKLER:");
        System.out.printf("   Kesinti Oranı (%%) %-8s: %.2f%%\n", " ", kesintiOrani);
        System.out.printf("   Saatlik Net Kazanc %-7s: %.2f    TL\n", " ", saatlikNetKazanc);
        System.out.printf("   Gunluk Net Kazanc %-8s: %.2f   TL\n", " ", gunlukNetKazanc);

        System.out.println("\n" + "=".repeat(45));

        // Not: Scanner.close() cagrisi System.in'i de kapatir.
        // Bu yüzden program boyunca sadece en sonda bir kez kullanilmalidir.
        // Birden fazla close() cagrisi hata verir!
        scanner.close();
    }
}