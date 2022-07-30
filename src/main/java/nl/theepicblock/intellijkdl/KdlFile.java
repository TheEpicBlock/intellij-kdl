package nl.theepicblock.intellijkdl;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class KdlFile extends PsiFileBase {
    protected KdlFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, KdlLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return KdlFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Kdl File";
    }
}
