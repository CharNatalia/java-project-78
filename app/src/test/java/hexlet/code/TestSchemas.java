package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TestSchemas {
    Validator v = new Validator();

    @Test
    public void testString() {
        var schema = v.string();
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));

        assertTrue(schema.contains("wh").isValid("what does the fox say"));
        assertTrue(schema.contains("what").isValid("what does the fox say"));
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));

        assertFalse(schema.isValid("what does the fox say"));

        var schema1 = v.string();
        assertTrue(schema1.minLength(10).minLength(4).isValid("Hexlet")); // true

    }

    @Test
    public void testNumber() {

        var schema = v.number();

        assertTrue(schema.isValid(5)); // true

// Пока не вызван метод required(), null считается валидным
        assertTrue(schema.isValid(null)); // true
        assertTrue(schema.positive().isValid(null)); // true

        schema.required();

        assertFalse(schema.isValid(null)); // false
        assertTrue(schema.isValid(10)); // true

// Потому что ранее мы вызвали метод positive()
        assertFalse(schema.isValid(-10)); // false
//  Ноль — не положительное число
        assertFalse(schema.isValid(0)); // false

        schema.range(5, 10);

        assertTrue(schema.isValid(5)); // true
        assertTrue(schema.isValid(10)); // true
        assertFalse(schema.isValid(4)); // false
        assertFalse(schema.isValid(11)); // false
    }

    @Test
    public void testMap() {
        var schema = v.map();

        assertTrue(schema.isValid(null)); // true
        System.out.println(schema.isValid(null)); // true

        schema.required();

        assertFalse(schema.isValid(null)); // false
        System.out.println(schema.isValid(null)); // false
        assertTrue(schema.isValid(new HashMap<>())); // true
        System.out.println(schema.isValid(new HashMap<>())); // true
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data)); // true
        System.out.println(schema.isValid(data)); // true

        schema.sizeof(2);

        assertFalse(schema.isValid(data));  // false
        System.out.println(schema.isValid(data));  // false
        data.put("key2", "value2");
        assertTrue(schema.isValid(data)); // true
        System.out.println(schema.isValid(data)); // true
    }
}
