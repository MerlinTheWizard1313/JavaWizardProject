package wizardBattle.com.version1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class HealingSpellTest {
    HealingSpell a = new HealingSpell("Minor Healing","Life",25);
    HealingSpell a2 = new HealingSpell("Healing","Life","None",100);
    HealingSpell a3 = new HealingSpell("Regeneration","Life",20,"Regeneration",50);
    Wizard w = new Wizard("merlin",100,100);
    Wizard w2 = new Wizard("morgana",100,100);

    @BeforeEach
    void setUp() {
        w.setHealth(100);
        w2.setHealth(100);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void R001_setHealingAmount_T001() {
        a.setHealingAmount(10);
        assertEquals(10,a.getHealingAmount());
    }

    @Test
    void R001_setHealingAmount_T002() {
        Throwable throwable =  assertThrows(Throwable.class, () -> a.setHealingAmount(-10));
        assertEquals(IllegalHealingAmountException.class, throwable.getClass());
    }

    @Test
    void R002_heal_T001() {
        a.heal(w);
        assertEquals(125,w.getHealth());
    }

    @Test
    void R002_heal_T002() {
        a2.heal(w);
        assertEquals(200,w.getHealth());
    }

    @Test
    void R002_heal_T003() {
        a3.heal(w);
        assertEquals(150,w.getHealth());
    }

    @Test
    void R003_cast_T001() {
        String c = a.cast(w,0,w2);
        boolean b = c.contains(w.getName()) && c.contains(a.castString(w2));
        assertTrue(b);
    }

    @Test
    void R003_cast_T002() {
        String c = a2.cast(w,0,w2);
        boolean b = c.contains(w.getName()) && c.contains(a2.castString(w2));
        assertTrue(b);
    }

    @Test
    void R004_castString_T001() {
        String b = a.castString(w);
        System.out.println(b);
        assertEquals(" casted Life Minor Healing!\nIt healed for 25 health.\nmerlin's Health: 100",b);
    }

    @Test
    void R004_castString_T002() {
        String b = a2.castString(w);
        System.out.println(b);
        assertEquals(" casted Life Healing!\nIt healed for 100 health.\nmerlin's Health: 100",b);
    }

    @Test
    void R004_castString_T003() {
        String b = a3.castString(w);
        System.out.println(b);
        assertEquals(" casted Life Regeneration for 20.0 seconds!\nIt healed for 50 health.\nmerlin's Health: 100\nApplied Regeneration to merlin",b);
    }
}