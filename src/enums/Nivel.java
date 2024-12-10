package enums;

public enum Nivel {
    I, II, III, IV, V, VI, VII, VIII;

    public static Nivel fromString(String value) {
        try {
            return Nivel.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Nível inválido: " + value);
        }
    }
}
