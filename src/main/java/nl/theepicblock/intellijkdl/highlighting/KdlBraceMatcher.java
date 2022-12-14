package nl.theepicblock.intellijkdl.highlighting;

import com.intellij.json.JsonElementTypes;
import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import nl.theepicblock.intellijkdl.psi.KdlTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class KdlBraceMatcher implements PairedBraceMatcher {
    private static final BracePair[] PAIRS = {
        new BracePair(KdlTypes.STARTNODE, KdlTypes.ENDNODE, true),
        new BracePair(KdlTypes.STARTTYPE, KdlTypes.ENDTYPE, true)
    };

    @Override
    public BracePair @NotNull [] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }

}
