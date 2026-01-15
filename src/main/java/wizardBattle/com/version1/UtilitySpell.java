package wizardBattle.com.version1;

import javax.persistence.*;

@Entity
public class UtilitySpell extends Spell {
    @Column(name="status_applied")
    private String statusApplied;

    public UtilitySpell(String name, String element) {
        super(name, element);
        setStatusApplied();
    }

    public UtilitySpell(String name, String element, String statusApplied) {
        super(name, element);
        setStatusApplied(statusApplied);
    }

    public UtilitySpell(String name, String element, double duration, String statusApplied) {
        super(name, element, duration);
        setStatusApplied(statusApplied);
    }

    public UtilitySpell() {}

    public String getStatusApplied() {
        return statusApplied;
    }

    public void setStatusApplied() {
        this.statusApplied = "None";
    }

    public void setStatusApplied(String statusApplied) {
        this.statusApplied = statusApplied;
    }

    @Override
    public String cast(Wizard caster, int spellIndex, Wizard target) {
        if(!this.getStatusApplied().equals("None")){
            target.setCurrentStatus(this.getStatusApplied());
        }
        return caster.getName() + this.castString(target);
    }

    @Override
    public String castString(Wizard target) {
        if (getDuration() != 0){
            return " casted " + getElement() + " " + getName() + " for " + getDuration() + " seconds!\nApplied " + getStatusApplied() + " to " + target.getName();
        } else {
            return " casted " + getElement() + " " + getName() + "!";
        }
    }
}
