package hexlet.code.schemas;

public class BaseSchema<T> {
    protected boolean required;

    public BaseSchema(boolean notNull) {
        this.required = notNull;

    }

    public BaseSchema<T> required() {
        this.required = true;
        return this;
    }

    public boolean isValid(T value) {
        if (value == null) {
            return !required;
        }
        return true;
    }

}
