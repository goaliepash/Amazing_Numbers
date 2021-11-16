package numbers;

/**
 * Класс-перечисление для свойств "невероятных" чисел.
 *
 * @author Иванов Павел Александрович
 */
public enum Property {

    EVEN("even"),
    ODD("odd"),
    BUZZ("buzz"),
    DUCK("duck"),
    PALINDROMIC("palindromic"),
    GAPFUL("gapful"),
    SPY("spy"),
    SQUARE("square"),
    SUNNY("sunny"),
    JUMPING("jumping"),
    HAPPY("happy"),
    SAD("sad");

    private final String description;

    Property(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
