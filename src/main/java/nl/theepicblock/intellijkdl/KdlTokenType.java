package nl.theepicblock.intellijkdl;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class KdlTokenType extends IElementType {
    public KdlTokenType(@NonNls @NotNull String debugName) {
        super(debugName, KdlLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "KdlTokenType"+super.toString();
    }
}
