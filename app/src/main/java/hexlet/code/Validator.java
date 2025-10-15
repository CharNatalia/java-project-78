package hexlet.code;

import hexlet.code.schemas.StringSchema;

public class Validator {
    StringSchema schema;


    public StringSchema string() {
        schema = new StringSchema();
        return schema;
    }

}
