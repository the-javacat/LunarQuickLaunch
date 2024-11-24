package pending.javacat.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public enum StringManager {
    INSTANCE;

    @Contract(pure = true)
    public @NotNull String encloseString(String original, String enclosing) {
        return enclosing + original + enclosing;
    }
}
