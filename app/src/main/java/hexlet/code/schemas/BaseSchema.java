package hexlet.code.schemas;

public class BaseSchema<T> {
    protected boolean required;

    public BaseSchema(boolean notNull) {
        this.required = notNull;

    }

    /**
     * Добавляет в схему ограничение, которое не позволяет использовать null в качестве значения.
     * При переопределении важно сохранить совместимость с базовой логикой валидации.
     * @return текущая схема с обновлённым правилом required
     */
    public BaseSchema<T> required() {
        this.required = true;
        return this;
    }
    /**
     * Проверяет данные после настройки схемы валидации.
     * Метод может быть переопределен для добавления специфической логики валидации.
     * @param value проверяемое значение
     * @return текущая схема с обновлённым правилом required
     */
    public boolean isValid(T value) {
        if (value == null) {
            return !required;
        }
        return true;
    }

}
