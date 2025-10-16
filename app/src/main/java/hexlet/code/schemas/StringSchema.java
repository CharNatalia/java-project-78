package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    private int minLength;
    private String contains;

    @Override
    public StringSchema required() {
        super.required();
        return this;
    }

    public StringSchema() {
        super(false);
        minLength = 0;
        contains = null;
    }

    public StringSchema minLength(int value) {
        minLength = value;
        return this;
    }

    public StringSchema contains(String str) {
        contains = str;
        return this;
    }

    @Override
    public boolean isValid(String string) {
        if (!super.isValid(string)) {
            return false;
        }

        if (string == null) {
            return true;
        }

        if (notNull && minLength == 0) {
            minLength(1);
        }

        if (string.length() < minLength) {
            return false;
        }

        return contains == null || string.contains(contains);
    }

}
