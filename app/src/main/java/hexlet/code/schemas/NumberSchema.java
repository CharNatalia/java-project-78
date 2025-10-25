package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
    }

    public NumberSchema positive() {
        Predicate<Integer> positive = v -> v > 0;
        addCheck("positive", positive);
        return this;
    }

    public NumberSchema range(int min, int max) {
        Predicate<Integer> range = v -> v >= min && v <= max;
        addCheck("range", range);
        return this;
    }

}
