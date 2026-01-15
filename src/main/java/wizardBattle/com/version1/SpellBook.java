package wizardBattle.com.version1;

import java.util.ArrayList;

public class SpellBook{
    private ArrayList<Spell> spells;
    private String bookName;

    public SpellBook(ArrayList<Spell> spells, String bookName) {
        setSpells(spells);
        setBookName(bookName);
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }

    public String getSpellsString() {
        StringBuilder spellString = new StringBuilder();
        for (Spell s : spells){
            spellString.append(s.getName()).append(", ");
        }
        spellString.delete(spellString.lastIndexOf(","),spellString.lastIndexOf(" "));
        return spellString.toString();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Spell getSpell(int spellIndex) throws SpellIndexOutOfBoundsException, SpellBookHasNoSpellsException {
        if(getSpellCount() == 0) {
            throw new SpellBookHasNoSpellsException(getBookName());
        } else if (spellIndex >= getSpellCount()){
            throw new SpellIndexOutOfBoundsException();
        }else {
            return spells.get(spellIndex);
        }
    }

    public void writeSpell(Spell s){
        spells.add(s);
        System.out.println(s.getName() + " added successfully!");
    }

    public void removeSpell(String name){
        this.spells.removeIf(s -> s.getName().equals(name));
    }

    public int getSpellCount(){
        return this.spells.size();
    }

    @Override
    public String toString() {
        return "com.version1.demo.SpellBook{" +
                "spells=" + getSpells() +
                ", bookName='" + getBookName() + '\'' +
                '}';
    }
}
