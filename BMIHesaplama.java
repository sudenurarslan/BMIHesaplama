import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BMIHesaplama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Boyunuzu metre cinsinden girin (örn: 1.75): ");
        double boy = scanner.nextDouble();

        System.out.print("Kilonuzu kilogram cinsinden girin: ");
        double kilo = scanner.nextDouble();

        double bmi = kilo / (boy * boy);
        String durum;

        if (bmi < 18.5) {
            durum = "Zayıf";
        } else if (bmi < 24.9) {
            durum = "Normal";
        } else if (bmi < 29.9) {
            durum = "Kilolu";
        } else {
            durum = "Obez";
        }

        System.out.printf("Vücut Kitle İndeksiniz: %.2f - Durum: %s\n", bmi, durum);

        try (FileWriter writer = new FileWriter("bmi_sonuclar.txt", true)) {
            writer.write(String.format("Boy: %.2f, Kilo: %.2f, BMI: %.2f, Durum: %s\n", boy, kilo, bmi, durum));
        } catch (IOException e) {
            System.out.println("Dosya yazma hatası: " + e.getMessage());
        }

        scanner.close();
    }
}

