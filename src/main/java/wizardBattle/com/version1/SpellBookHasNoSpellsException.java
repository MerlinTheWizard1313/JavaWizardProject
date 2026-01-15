package wizardBattle.com.version1;

public class SpellBookHasNoSpellsException extends Exception {
    public SpellBookHasNoSpellsException(String spellBook) {
        super(spellBook + " has no spells to cast");
    }
}
