package nl.theepicblock.intellijkdl;

import com.intellij.lang.Language;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class KdlLanguage extends Language {
    public static final KdlLanguage INSTANCE = new KdlLanguage();

    protected KdlLanguage() {
        super("kdl");
    }
}
