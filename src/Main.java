import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<DnDCharacter> characters = new ArrayList<>();
        PromptCreateCharacters(characters);
        printCharacters(characters);

        // TEST :)

        while (true){
            Tools.printToConsole("""
                
                
                Do you want to train a stat?
                1... yes
                2... no
                """);
            int userInput = input.nextInt();
            if (userInput == 1) {
                promptTrainCharacter(characters);
            } else {
                return;
            }
        }

    }

    private static void promptTrainCharacter(ArrayList<DnDCharacter> characters) {
        int counter = 0;
        Tools.printToConsole("Which character do you want to train?\n", true);
        for (DnDCharacter character : characters) {
            counter++;
            Tools.printToConsole(counter + ": " + character.getName());
        }

        System.out.print("\n\nChoice: ");
        int characterIndex = (input.nextInt() - 1);

        DnDCharacter chosenCharacter = characters.get(characterIndex);
        Tools.printToConsole("Player " + chosenCharacter.getName() + " has been chosen!\n" +
                "Which stat would you like to train?", true);
        Tools.printToConsole("""
                1... Strength
                2... Intelligence
                3... Charisma
                """);
        int userInput = input.nextInt();

        if (userInput == 1){
            Tools.printToConsole("You chose to train strength for " + chosenCharacter.getName() + ".\n");
            characters.get(characterIndex).trainStrength();
            Tools.waitForUser(input);

            printCharacters(characters);
        } else if (userInput == 2) {
            Tools.printToConsole("You chose to train intelligence for " + chosenCharacter.getName() + ".\n");
            characters.get(characterIndex).trainIntelligence();
            Tools.waitForUser(input);

            printCharacters(characters);
        } else if (userInput == 3) {
            Tools.printToConsole("You chose to train charisma for " + chosenCharacter.getName() + ".\n");
            characters.get(characterIndex).trainCharisma();
            Tools.waitForUser(input);

            printCharacters(characters);
        }
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