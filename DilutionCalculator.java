import java.util.Scanner;



public class DilutionCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose your language / Válassz nyelvet: ");
        System.out.println("1 - English");
        System.out.println("2 - Magyar");
        int language = scanner.nextInt();

        switch (language) {
            case 1:
                runProgram("English");
                break;
            case 2:
                runProgram("Magyar");
                break;
            default:
                System.out.println("Invalid option. Exiting program.");
        }
    }

    public static void runProgram(String language) {
        Scanner scanner = new Scanner(System.in);

        if (language.equals("English")) {
            System.out.println("Enter the container capacity in milliliters (ml): ");
        } else if (language.equals("Magyar")) {
            System.out.println("Add meg az edény űrtartalmát milliliterben (ml): ");
        }
        int capacity = scanner.nextInt();

        if (language.equals("English")) {
            System.out.println("Enter the dilution ratio (e.g., 1:2 or 1:800): ");
        } else if (language.equals("Magyar")) {
            System.out.println("Add meg a hígítási arányt (pl.: 1:2 vagy 1:800): ");
        }
        String ratio = scanner.next();

        calculateDilution(capacity, ratio, language);
    }

    public static void calculateDilution(int capacity, String ratio, String language) {
        String[] parts = ratio.split(":");

        try {
            int ratioFirst = Integer.parseInt(parts[0]);
            int ratioSecond = Integer.parseInt(parts[1]);

            // Számítás és kerekítés egész számra
            int chemicalAmount = Math.round((capacity / (float) (ratioFirst + ratioSecond)) * ratioFirst);
            int waterAmount = capacity - chemicalAmount;

            if (language.equals("English")) {
                System.out.println("Chemical needed: " + chemicalAmount + " ml");
                System.out.println(" needed: " + waterAmount + " ml");
                System.out.println("Diluent needed: " + waterAmount + " ml");
            } else if (language.equals("Magyar")) {
                System.out.println("Szükséges vegyszer: " + chemicalAmount + " ml");
                System.out.println("Szükséges higító: " + waterAmount + " ml");
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            if (language.equals("English")) {
                System.out.println("Invalid ratio format! Please use '1:2' or similar.");
            } else if (language.equals("Magyar")) {
                System.out.println("Érvénytelen arány formátum! Használj például '1:2'-t.");
            }
        }
    }
}