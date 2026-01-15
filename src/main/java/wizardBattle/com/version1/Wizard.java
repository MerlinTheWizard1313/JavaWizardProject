package wizardBattle.com.version1;

public class Wizard {
    private String name;
    private boolean hasSpellBook = false;
    private SpellBook spellBook;
    private int health;
    private int defence;
    private String currentStatus = "None";

    public Wizard(String name,int health, int defence){
        setName(name);
        setHealth(health);
        setDefence(defence);
        setSpellBook();
    }

    public Wizard(String name, boolean hasSpellBook, SpellBook spellBook, int health, int defence) {
        setName(name);
        setHasSpellBook(hasSpellBook);
        setSpellBook(spellBook);
        setHealth(health);
        setDefence(defence);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasSpellBook() {
        return hasSpellBook;
    }

    private void setHasSpellBook(boolean hasSpellBook) {
        this.hasSpellBook = hasSpellBook;
    }

    public SpellBook getSpellBook() throws SpellBookNotFoundException {
        if (!isHasSpellBook()){
            throw new SpellBookNotFoundException(getName());
        }
        return spellBook;
    }

    public void setSpellBook(){
        this.spellBook = null;
        setHasSpellBook(false);
    }

    public void setSpellBook(SpellBook spellBook) {
        this.spellBook = spellBook;
        setHasSpellBook(true);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void changeHealth(int damageOrHealing){
        setHealth(getHealth() + damageOrHealing);
        if (getHealth() <= 0){
            setHealth(0);
        }
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public void castSpell(int spellIndex, Wizard target) throws SpellBookNotFoundException, SpellIndexOutOfBoundsException, SpellBookHasNoSpellsException {
        System.out.println(getSpellBook().getSpell(spellIndex).cast(this,spellIndex,target));
    }

    @Override
    public String toString() {
        return "com.version1.demo.Wizard{" +
                "name='" + name + '\'' +
                ", hasSpellBook=" + hasSpellBook +
                ", spellBook=" + spellBook.toString() +
                '}';
    }
}
