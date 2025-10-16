package hexlet.code.schemas;

public class BaseSchema<T> {
    protected boolean notNull;

    public BaseSchema(boolean notNull) {
        this.notNull = notNull;
    }

    public BaseSchema<T> required() {
        this.notNull = true;
        return this;
    }

    public boolean isValid(T value) {
        if (value == null) {
            return !notNull;
        }
        return true;
    }

}
