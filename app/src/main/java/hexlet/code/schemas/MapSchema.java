package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map<String, String>> {
    public MapSchema sizeof(Integer size) {
        Predicate<Map<String, String>> sizeofMap = map -> size == map.size();
        addCheck("sizeOfMap", sizeofMap);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> mapSchema) {
        Predicate<Map<String, String>> shape = map -> {
            if (mapSchema != null && !map.isEmpty()) {
                for (var entry : map.entrySet()) {
                    var key = entry.getKey();
                    var value = entry.getValue();
                    BaseSchema<String> schema = mapSchema.get(key);
                    if (schema != null && !schema.isValid(value)) {
                        return false;
                    }
                }
            }
            return true;
        };
        addCheck("shape", shape);
        return this;
    }

}
