package nl.theepicblock.intellijkdl.typing;

import com.intellij.codeInsight.editorActions.EnterHandler;
import com.intellij.codeInsight.editorActions.enter.EnterBetweenBracesDelegate;
import com.intellij.lang.Language;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import nl.theepicblock.intellijkdl.psi.KdlStartnodeWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class KdlEnterBetweenBracesDelegate extends EnterBetweenBracesDelegate {
    @Override
    public boolean bracesAreInTheSameElement(@NotNull PsiFile file, @NotNull Editor editor, int lBraceOffset, int rBraceOffset) {
        return false;
    }



    @Override
    protected void formatAtOffset(@NotNull PsiFile file, @NotNull Editor editor, int offset, @Nullable Language language) {
        EnterHandler.adjustLineIndentNoCommit(language,
                editor.getDocument(),
                editor,
                offset);
    }
}
