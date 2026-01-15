package wizardBattle.com.version1;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;

@Suite
@SelectClasses({
        AttackSpellTest.class,
        HealingSpellTest.class,
        SpellBookTest.class,
        UtilitySpellTest.class,
        WizardTest.class
})
public class TestSuiteRunner {
}
