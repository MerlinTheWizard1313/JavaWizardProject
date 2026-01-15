package wizardBattle.com.version1;

public class SpellBookNotFoundException extends Exception {
    public SpellBookNotFoundException(String name) {
        super(name + " has no spellbook");
    }
}
