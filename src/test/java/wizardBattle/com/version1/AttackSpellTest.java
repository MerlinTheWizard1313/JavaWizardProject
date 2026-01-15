package wizardBattle.com.version1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AttackSpellTest {
    AttackSpell a = new AttackSpell("Fireball","Fire",100);
    AttackSpell a2 = new AttackSpell("Icicle","Ice",20,50);
    Wizard w = new Wizard("merlin",100,100);
    Wizard w2 = new Wizard("morgana",100,100);

    @BeforeAll
    static void before(){
        System.out.println("AttackSpellTest Running");
    }

    @BeforeEach
    void setUp(){
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void R001_setPower_T001() {
        a.setPower(50);
        assertEquals(50,a.getPower());
    }

    @Test
    void R001_setPower_T002() {
        Throwable throwable =  assertThrows(Throwable.class, () -> a.setPower(-1));
        assertEquals(IllegalArgumentException.class, throwable.getClass());
    }

    @Test
    void R002_cast_T001() {
        String c = a.cast(w,0,w2);
        boolean b = c.contains(w.getName()) && c.contains(a.castString(w2)) && c.contains(" damage! They were ") && c.contains(w2.getCurrentStatus());
        assertTrue(b);
    }

    @Test
    void R002_cast_T002() {
        String c = a2.cast(w,0,w2);
        boolean b = c.contains(w.getName()) && c.contains(a2.castString(w2)) && c.contains(" damage!");
        assertTrue(b);
    }

    @Test
    void R003_damageCalc_T001(){
        int damageDealt = a.damageCalc(w2,a);
        boolean damageCheck = damageDealt >= 0 && damageDealt <= 20;
        assertTrue(damageCheck);
    }

    @Test
    void R003_damageCalc_T002(){
        int damageDealt = a2.damageCalc(w2,a2);
        boolean damageCheck = damageDealt == 0;
        assertTrue(damageCheck);
    }

    @Test
    void R004_castString_T001() {
        String b = a.castString(w);
        assertEquals(" casted level 100 Fire Fireball!\nAttacked merlin for ",b);
    }

    @Test
    void R004_castString_T002() {
        String b = a2.castString(w);
        assertEquals(" casted level 50 Ice Icicle for 20.0 seconds!\nAttacked merlin for ",b);
    }
}