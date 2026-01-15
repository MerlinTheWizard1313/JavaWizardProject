package wizardBattle.com.version1;

public class AttackSpell extends Spell implements ICanDealDamage{
    private int power;

    public AttackSpell(String name, String element, int power) {
        super(name, element);
        this.power = power;
    }

    public AttackSpell(String name, String element, double duration, int power) {
        super(name, element, duration);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) throws IllegalArgumentException {
        if (power >= 0) {
            this.power = power;
        } else {
            throw new IllegalArgumentException("Power must be 0 or higher");
        }
    }

    @Override
    public String cast(Wizard caster, int spellIndex, Wizard target) {
        int damageDealt = damageCalc(target,this);
        String fullCastString;
        if (damageDealt == 0){
            fullCastString = caster.getName() + this.castString(target) + damageDealt + " damage! They were " + target.getCurrentStatus();
        }else{
            target.changeHealth(-damageDealt);
            fullCastString = getName() + this.castString(target) + damageDealt + " damage!";
        }
        return fullCastString;
    }

    @Override
    public String castString(Wizard target) {
        if (getDuration() != 0){
            return " casted level " + getPower() + " " + getElement() + " " + getName() + " for " + getDuration() + " seconds!\nAttacked " + target.getName() + " for ";
        } else {
            return " casted level " + getPower() + " " + getElement() + " " + getName() + "!\nAttacked " + target.getName() + " for ";
        }
    }
}
