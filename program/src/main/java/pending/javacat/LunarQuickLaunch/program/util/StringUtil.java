package pending.javacat.LunarQuickLaunch.program.util;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StringUtil {

    @Contract(pure = true)
    public static @NotNull String encloseString(String original, String enclosing) {
        return enclosing + original + enclosing;
    }
}
