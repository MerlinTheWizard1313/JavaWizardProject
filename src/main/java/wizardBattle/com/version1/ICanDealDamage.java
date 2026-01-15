package wizardBattle.com.version1;

public interface ICanDealDamage {
    default int damageCalc(Wizard target, AttackSpell spell){
        if (target.getCurrentStatus().equals("Invisible")){
            return 0;
        }else {
            return (int) Math.max(Math.floor(Math.random() * spell.getPower()) + (0.2 * spell.getPower()) - target.getDefence(),0);
        }
    }
}
