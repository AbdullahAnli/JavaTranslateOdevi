import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Translate {
    public static void main(String[] args) {
        Map<String, String> Sozluk = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Abdullah Anlı\\Desktop\\english-turkish.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Sozluk.put(parts[0].toLowerCase(), parts[1]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner input = new Scanner(System.in);
        String kelime;
        while (true) {
            System.out.print(" (Çıkmak için 'exit')\nÇevirmek istediğiniz kelimeyi girin :  ");
            kelime = input.nextLine().toLowerCase();

            if (kelime.equals("exit")) {
                break;
            }

            if (Sozluk.containsKey(kelime)) {
                System.out.println("Çevirisi: " + Sozluk.get(kelime));
            } else {
                System.out.println("kelime bulunamadı.");
            }
        }
        input.close();
    }
}