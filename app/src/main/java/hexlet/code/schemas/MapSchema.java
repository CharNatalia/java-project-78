package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<String, String>> {
    private Integer sizeofMap;
    private Map<String, BaseSchema<String>> schemas;

    public MapSchema() {
        super(false);
        sizeofMap = null;
    }

    public MapSchema sizeof(Integer size) {
        sizeofMap = size;
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> mapSchema) {
        schemas = mapSchema;
        return this;
    }

    @Override
    public boolean isValid(Map<String, String> map) {
        if (!super.isValid(map)) {
            return false;
        }

        if (map == null) {
            return true;
        }

        if (schemas != null && !map.isEmpty()) {
            for (var entry : map.entrySet()) {
                var key = entry.getKey();
                var value = entry.getValue();
                BaseSchema<String> schema = schemas.get(key);
                if (schema != null && !schema.isValid(value)) {
                    return false;
                }
            }
        }


        return sizeofMap == null || sizeofMap == map.size();
    }
}
