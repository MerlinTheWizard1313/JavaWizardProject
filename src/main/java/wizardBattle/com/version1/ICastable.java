package wizardBattle.com.version1;

public interface ICastable {
     String castString(Wizard target);
     String cast(Wizard caster, int spellIndex, Wizard target);
}
