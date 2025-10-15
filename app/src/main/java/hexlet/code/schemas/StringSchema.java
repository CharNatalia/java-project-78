package hexlet.code.schemas;

public class StringSchema {
    private boolean notNull;
    private int minLength;
    private String contains;

//    public StringSchema() {
//        notNull = false;
//        minLength = 0;
//        contains = null;
//    }

    public boolean getNotNull() {
        return notNull;
    }

    public int getMinLength() {
        return minLength;
    }

    public String getContains() {
        return contains;
    }

    public StringSchema required() {
        this.notNull = true;
        this.minLength(1);
        return this;
    }

    public StringSchema minLength(int value) {
        minLength = value;
        return this;
    }

    public StringSchema contains(String str) {
        contains = str;
        return this;
    }

    public boolean isValid(Object obj) {
        if (obj == null) {
            return !notNull;
        }

        if (!(obj instanceof String string)) {
            return false;
        }

        if (string.length() < minLength) {
            return false;
        }

        return contains == null || string.contains(contains);
    }

}
