package wizardBattle.com.version1;

import javax.persistence.*;

@Entity
public abstract class Spell implements ICastable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="spell_id")
    private int id;
    @Column(name="spell_name")
    private String name;
    @Column(name="element")
    private String element;
    @Column(name="duration")
    private double duration;

    public Spell(){}

    public Spell(String name, String element) {
        setName(name);
        setElement(element);
        setDuration(0);
    }

    public Spell(String name, String element, double duration) {
        setName(name);
        setElement(element);
        setDuration(duration);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        if (duration >= 0) {
            this.duration = duration;
        } else {
            throw new IllegalArgumentException("Duration must be between 0 and 3600 seconds");
        }
    }

    public abstract String cast(Wizard caster, int spellIndex, Wizard target);

    public abstract String castString(Wizard target);

    @Override
    public String toString() {
        return "com.version1.demo.Spell{" +
                "name='" + name + '\'' +
                ", element='" + element + '\'' +
                ", duration=" + duration +
                '}';
    }
}
