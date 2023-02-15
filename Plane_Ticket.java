import java.util.Scanner;

/*
Java ile mesafeye ve şartlara göre uçak bileti fiyatı hesaplayan programı yapın. Kullanıcıdan Mesafe (KM),
 yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş) bilgilerini alın. Mesafe başına ücret 0,10 TL / km olarak alın.
 İlk olarak uçuşun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki indirimleri uygulayın ;

Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.
Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.

 */
public class Plane_Ticket {
    public static void main(String[] args) {
        float perKm = 0.10f;

        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen gitmek istediğiniz mesafeyi KM cinsinden belirtiniz:");
        int distance = input.nextInt();
        if (distance > 0) {
            System.out.println("Lütfen yolculuk tipinizi 1 veya 2 cinsinden giriniz:");
            System.out.println("1-Tek Yön\n2-Gidiş Dönüş");
        } else {
            System.out.println("Hatalı bir giriş yaptınız!");

        }
        int type = input.nextInt();

        System.out.println("Lütfen yaşınızı giriniz:");
        int age = input.nextInt();


        double total = perKm * distance;

        if (type == 1) {
            System.out.println("Bilet indirimsiz ücreti: " + total + " TL");


        } else if (type == 2) {
            total = (perKm * (distance * 2));
            System.out.println("Bilet indirimsiz ücreti: " + total + " TL");
            System.out.println("%20 Gidiş-Dönüş Kampanyası Uygulanmıştır.\nBilet Fiyatı:" + (total -= (total * (0.2))));


        } else {
            System.out.println("Hatalı bir giriş yaptınız! Seçiminizi 1 veya 2 şeklinde yapmalısınız.");
        }
        double child = (total -= total * (0.5));
        double student = (total -= total * (0.1));
        double old = (total -= total * (0.3));

        if (age > 0) {
            if (age < 12) {
                System.out.println("%50 Çocuk İndirimi uygulanmıştır.\nBilet fiyatı: " + child + " TL");

            } else if (age >= 12 && age <= 24) {
                System.out.println("%10 Öğrenci İndirimi uygulanmıştır.\nBilet fiyatı: " + student + " TL");
            } else if (age >= 65) {
                System.out.println("%30 65 Yaş Üstü İndirimi uygulanmıştır.\nBilet fiyatı: " + old + " TL");
            } else if (age > 24 && age < 65) {
                System.out.println("Bilet fiyatınız: " + total + " TL");
            }

        } else {
            System.out.println("Hatalı bir giriş yaptınız! Tekrar deneyiniz...");
        }

    }
}
