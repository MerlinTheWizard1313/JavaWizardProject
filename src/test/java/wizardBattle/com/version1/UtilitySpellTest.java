package wizardBattle.com.version1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class UtilitySpellTest {
    UtilitySpell a = new UtilitySpell("Utility1","Fire","Burn");
    UtilitySpell a2 = new UtilitySpell("Utility2","Nature",10,"Poison");
    UtilitySpell a3 = new UtilitySpell("Utility3","Light","Blindness");
    UtilitySpell a4 = new UtilitySpell("Utility4","None","None");
    Wizard w = new Wizard("merlin",100,100);
    Wizard w2 = new Wizard("morgana",100,100);

    @BeforeAll
    static void before(){
        System.out.println("UtilitySpellTest Running");
    }

    @BeforeEach
    void setUp() {
        w.setCurrentStatus("None");
        w2.setCurrentStatus("None");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void R001_setStatusApplied_T001() {
        a3.setStatusApplied();
        assertEquals("None",a3.getStatusApplied());
    }

    @Test
    void R001_setStatusApplied_T002() {
        a3.setStatusApplied("Blindness");
        assertEquals("Blindness",a3.getStatusApplied());
    }

    @Test
    void R002_cast_T001() {
        String c = a.cast(w,0,w2);
        boolean b = c.contains(w.getName()) && c.contains("Burn");
        assertTrue(b);
    }

    @Test
    void R002_cast_T002() {
        String c = a2.cast(w,0,w2);
        boolean b = c.contains(w.getName()) && c.contains("Poison") && c.contains("10.0");
        assertTrue(b);
    }

    @Test
    void R003_castString_T001() {
        String b = a.castString(w);
        System.out.println(b);
        assertEquals(" casted Fire Utility1!\nApplied Burn to merlin",b);
    }

    @Test
    void R003_castString_T002() {
        String b = a2.castString(w);
        System.out.println(b);
        assertEquals(" casted Nature Utility2 for 10.0 seconds!\nApplied Poison to merlin",b);
    }

    @Test
    void R003_castString_T003() {
        String b = a4.castString(w);
        System.out.println(b);
        assertEquals(" casted None Utility4!", b);
    }
}