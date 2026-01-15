package wizardBattle.com.version1;

public class IllegalHealingAmountException extends IllegalArgumentException {
    public IllegalHealingAmountException() {
        super("Healing must be a positive integer value");
    }
}
