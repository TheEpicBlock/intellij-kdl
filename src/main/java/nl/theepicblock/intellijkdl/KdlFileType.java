package nl.theepicblock.intellijkdl;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class KdlFileType extends LanguageFileType {
    public static final KdlFileType INSTANCE = new KdlFileType();

    private KdlFileType() {
        super(KdlLanguage.INSTANCE);
    }

    @Override
    public @NonNls @NotNull String getName() {
        return "Kdl";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "Kdl document language";
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return "kdl";
    }

    @Override
    public @Nullable Icon getIcon() {
        return KdlIcons.FILE;
    }
}
