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
            String Line;
            while ((Line = reader.readLine()) != null) {
                String[] parts = Line.split(",");
                Sozluk.put(parts[0].toLowerCase(), parts[1]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner input = new Scanner(System.in);
        String Kelime;
        while (true) {
            System.out.print(" (Çıkmak için 'exit')\nÇevirmek istediğiniz kelimeyi girin :  ");
            Kelime = input.nextLine().toLowerCase();

            if (Kelime.equals("exit")) {
                break;
            }

            if (Sozluk.containsKey(Kelime)) {
                System.out.println("Çevirisi: " + Sozluk.get(Kelime));
            } else {
                System.out.println("Kelime bulunamadı.");
            }
        }
    }
}
