package wizardBattle.com.version1;

import javax.persistence.*;

@Entity
public class Wizard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="wizard_id")
    private int id;
    @Column(name="wizard_name")
    private String name;
    @Column(name="has_spellbook")
    private boolean hasSpellBook = false;
    @ManyToOne
    @JoinColumn(name = "wizards_spellbook")
    private SpellBook spellBook;
    @Column(name="health")
    private int health;
    @Column(name="defence")
    private int defence;
    @Column(name="status")
    private String currentStatus = "None";

    public Wizard(){}

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
