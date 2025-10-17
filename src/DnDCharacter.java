public class DnDCharacter {
    private String name;
    private int strength;
    private int intelligence;
    private int charisma;

    public DnDCharacter(String name, int strength, int intelligence, int charisma) {
        this.name = name;
        this.strength = strength;
        this.intelligence = intelligence;
        this.charisma = charisma;
    }

    public String getName(){
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getCharisma() {
        return charisma;
    }
}
