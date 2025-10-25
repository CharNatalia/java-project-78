package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();
    protected boolean required = false;


    /**
     * Добавляет в схему ограничение, которое не позволяет использовать null в качестве значения.
     * При переопределении важно сохранить совместимость с базовой логикой валидации.
     * @return текущая схема с обновлённым правилом required
     */
    public BaseSchema<T> required() {
        required = true;
        return this;
    }

    public final void addCheck(String checkName, Predicate<T> check) {
        checks.put(checkName, check);
    }

    public final boolean isValid(T value) {
        if (value == null && required) {
            return false;
        }

        if (value == null) {
            return true;
        }

        for (var set : checks.entrySet()) {
            var check = set.getValue();
            if (!check.test(value)) {
                return false;
            }
        }


        return true;
    }

}
