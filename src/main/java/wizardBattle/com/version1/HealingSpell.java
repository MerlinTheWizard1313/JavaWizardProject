package wizardBattle.com.version1;

import javax.persistence.*;

@Entity
public class HealingSpell extends UtilitySpell implements IHealing{
    @Column(name="healing_amount")
    private int healingAmount;

    public HealingSpell(String name, String element, int healingAmount) {
        super(name, element);
        setHealingAmount(healingAmount);
    }

    public HealingSpell(String name, String element, String statusApplied, int healingAmount) {
        super(name, element, statusApplied);
        setHealingAmount(healingAmount);
    }

    public HealingSpell(String name, String element, double duration, String statusApplied, int healingAmount) {
        super(name, element, duration, statusApplied);
        setHealingAmount(healingAmount);
    }

    public HealingSpell() {
        super();
    }

    public int getHealingAmount() {
        return this.healingAmount;
    }

    public void setHealingAmount(int healingAmount) throws IllegalHealingAmountException {
        if (healingAmount >= 0){
            this.healingAmount = healingAmount;
        } else {
            throw new IllegalHealingAmountException();
        }
    }

    public void heal(Wizard target){
        target.changeHealth(getHealingAmount());
    }

    @Override
    public String cast(Wizard caster, int spellIndex, Wizard target) {
        heal(target);
        if(!this.getStatusApplied().equals("None")){
            target.setCurrentStatus(this.getStatusApplied());
        }
        return caster.getName() + this.castString(target);
    }

    @Override
    public String castString(Wizard target) {
        if (getDuration() != 0){
            return " casted " + getElement() + " " + getName() + " for " + getDuration() + " seconds!\nIt healed for " + getHealingAmount() + " health.\n" + target.getName() + "'s Health: " + target.getHealth() + "\nApplied " + getStatusApplied() + " to " + target.getName();
        } else {
            return " casted " + getElement() + " " + getName() + "!\nIt healed for " + getHealingAmount() + " health.\n" + target.getName() + "'s Health: " + target.getHealth();
        }
    }
}
