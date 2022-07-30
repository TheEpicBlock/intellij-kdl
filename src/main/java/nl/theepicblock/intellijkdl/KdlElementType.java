package nl.theepicblock.intellijkdl;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class KdlElementType extends IElementType {
    public KdlElementType(@NonNls @NotNull String debugName) {
        super(debugName, KdlLanguage.INSTANCE);
    }
}
