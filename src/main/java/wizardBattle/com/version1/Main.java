package wizardBattle.com.version1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SpellBookNotFoundException, SpellBookHasNoSpellsException {
        Scanner sc = new Scanner(System.in);
        SpellBook sb = createSpellBook();
        Wizard merlin = createWizard(sb,"Merlin",100,40);
        Wizard morgana = createWizard(sb,"Morgana",250,5);
        Wizard[] wizards = {merlin, morgana};
        Wizard chronicus = new Wizard("chronicus", 1,2);
        ArrayList<Spell> emptyList = new ArrayList<>();
        SpellBook sb2 = new SpellBook(emptyList,"emptyBook");
        chronicus.setSpellBook(sb2);
        chronicus.castSpell(0,merlin);
        new HealingSpell("poison","death",-1);
        boolean battleHappening = true;
        while(battleHappening){
            battleHappening = battleTurn(sc,merlin,wizards);
            if (battleHappening){
                battleHappening = battleTurn(sc,morgana,wizards);
            }
        }
    }

    public static void spellValidation(Wizard caster, String userEntry, Wizard target) throws SpellBookNotFoundException, SpellBookHasNoSpellsException {
        int i = 0;
        boolean spellCast = false;
        for (Spell s: caster.getSpellBook().getSpells()){
            if(s.getName().toLowerCase().equals(userEntry) || Integer.toString(i).equals(userEntry)){
                caster.castSpell(i,target);
                spellCast = true;
            }
            i+=1;
        }
        if (!spellCast){
            System.out.println("You failed to cast a spell!");
        }
    }

    public static SpellBook createSpellBook(){
        AttackSpell s1 = new AttackSpell("Missile","Fire", 0,100);
        UtilitySpell s2 = new UtilitySpell("Invisibility","Light", 10,"Invisible");
        HealingSpell s3 = new HealingSpell("Repairo", "Life", 0, "None",30);
        ArrayList<Spell> spells = new ArrayList<>();
        spells.add(s1);
        spells.add(s2);
        spells.add(s3);
        return new SpellBook(spells,"Farus Stupendus");
    }

    public static Wizard createWizard(SpellBook spellBook, String name, int health, int defence) {
        Wizard w = new Wizard(name,health,defence);
        w.setSpellBook(spellBook);
        return w;
    }

    public static boolean battleTurn(Scanner sc, Wizard caster, Wizard[] wizardArray) throws SpellBookNotFoundException, SpellBookHasNoSpellsException {
        System.out.println(caster.getName() + ", choose a spell to cast: " + caster.getSpellBook().getSpellsString());
        String spellChoice = sc.nextLine().toLowerCase();
        System.out.println(caster.getName() + ", choose a target: " + wizardArray[0].getName() + ", " + wizardArray[1].getName());
        String targetChoice = sc.nextLine().toLowerCase();
        if(wizardArray[0].getName().toLowerCase().equals(targetChoice) || targetChoice.equals("0")){
            spellValidation(caster,spellChoice,wizardArray[0]);
        } else {
            spellValidation(caster,spellChoice,wizardArray[1]);
        }
        Wizard tempW;
        if (wizardArray[0].getHealth() == 0){
            System.out.println(wizardArray[1].getName() + " has won the battle! He reigns victorious!");
            return false;
        } else if(wizardArray[1].getHealth() == 0){
            System.out.println(wizardArray[0].getName() + " has won the battle! He reigns victorious!");
            return false;
        } else {
            if(wizardArray[0].getName().toLowerCase().equals(targetChoice) || targetChoice.equals("0")){
                tempW = wizardArray[0];
            } else {
                tempW = wizardArray[1];
            }
            System.out.println(tempW.getName() + "'s Health: " + tempW.getHealth());
            return true;
        }
    }
}
