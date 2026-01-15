package wizardBattle.com.version1;

import javax.persistence.*;

@Entity
public class HealingSpell extends Spell implements IHealing{
    @Column(name="healing_amount")
    private int healingAmount;
    @ManyToOne
    @JoinColumn(name = "utility_spell_id")
    private UtilitySpell us;

    public HealingSpell(String name, String element, UtilitySpell us, int healingAmount) {
        super(name, element,us.getDuration());
        setHealingAmount(healingAmount);
        this.us = us;
    }

    public HealingSpell() {
        super();
    }

    public UtilitySpell getUs() {
        return us;
    }

    public void setUs(UtilitySpell us) {
        this.us = us;
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
        if(!us.getStatusApplied().equals("None")){
            target.setCurrentStatus(us.getStatusApplied());
        }
        return caster.getName() + this.castString(target);
    }

    @Override
    public String castString(Wizard target) {
        if (getDuration() != 0){
            return " casted " + getElement() + " " + getName() + " for " + getDuration() + " seconds!\nIt healed for " + getHealingAmount() + " health.\n" + target.getName() + "'s Health: " + target.getHealth() + "\nApplied " + us.getStatusApplied() + " to " + target.getName();
        } else {
            return " casted " + getElement() + " " + getName() + "!\nIt healed for " + getHealingAmount() + " health.\n" + target.getName() + "'s Health: " + target.getHealth();
        }
    }
}
