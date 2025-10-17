import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<DnDCharacter> characters = new ArrayList<>();
        PromptCreateCharacters(characters);
        printCharacters(characters);
    }

    private static void PromptCreateCharacters(ArrayList<DnDCharacter> characters) {
        Tools.printToConsole("how many characters do you wish to add?", true);
        int characterCount = input.nextInt();
        input.nextLine();

        for (int n = 0; n < characterCount; n++) {
            String name;
            int strength;
            int intelligence;
            int charisma;

            Tools.printToConsole("Please enter the name of character #" + (n + 1), true);
            System.out.print("Name: ");
            name = input.nextLine();

            Tools.printToConsole("Enter " + name + "'s strength level.");
            System.out.print("Strength: ");
            strength = input.nextInt();

            Tools.printToConsole("Enter " + name + "'s intelligence level.");
            System.out.print("Intelligence: ");
            intelligence = input.nextInt();

            Tools.printToConsole("Enter " + name + "'s charisma level.");
            System.out.print("Charisma: ");
            charisma = input.nextInt();
            input.nextLine();

            characters.add(new DnDCharacter(name, strength, intelligence, charisma));
        }
    }

    private static void printCharacters(ArrayList<DnDCharacter> characters) {
        Tools.titlePrinter("CHARACTERS", true);
        for (DnDCharacter character : characters) {
            Tools.printToConsole("\n" + character.getName());
            Tools.printToConsole("Strength: " + character.getStrength());
            Tools.printToConsole("Intelligence: " + character.getIntelligence());
            Tools.printToConsole("Charisma: " + character.getCharisma());
        }
    }
}