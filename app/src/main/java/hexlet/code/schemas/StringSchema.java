package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {
    private Predicate<String> minLength;
    private Predicate<String> contains;

    @Override
    public StringSchema required() {
        super.required();
        minLength(1);
        return this;
    }

    public StringSchema minLength(int min) {
        minLength = v -> v.length() > min;
        addCheck("minLength", minLength);
        return this;
    }

    public StringSchema contains(String str) {
        if (str != null) {
            contains = v -> v.contains(str);
            addCheck("contains", contains);
        }
        return this;
    }
}
