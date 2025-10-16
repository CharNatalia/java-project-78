package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {
    private boolean positive;
    private int minRange;
    private int maxRange;

    public NumberSchema() {
        super(false);
        positive = false;
        minRange = Integer.MIN_VALUE;
        maxRange = Integer.MAX_VALUE;
    }

    public NumberSchema positive() {
        positive = true;
        return this;
    }

    public NumberSchema range(int min, int max) {
        minRange = min;
        maxRange = max;
        return this;
    }

    @Override
    public boolean isValid(Integer number) {
        if (!super.isValid(number)) {
            return false;
        }

        if (number == null) {
            return true;
        }
        if (number <= 0 && positive) {
            return false;
        }

        return number >= minRange && number <= maxRange;
    }
}
