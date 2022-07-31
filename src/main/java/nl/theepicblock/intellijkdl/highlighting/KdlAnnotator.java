package nl.theepicblock.intellijkdl.highlighting;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import nl.theepicblock.intellijkdl.psi.KdlIdentifier;
import nl.theepicblock.intellijkdl.psi.KdlNode_;
import nl.theepicblock.intellijkdl.psi.KdlProp;
import nl.theepicblock.intellijkdl.psi.KdlType;
import org.jetbrains.annotations.NotNull;

// Sets some conditional highlights
// Such as node names or type annotations
public class KdlAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof KdlIdentifier) {
            if (element.getParent() instanceof KdlType) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION).textAttributes(KdlSyntaxHighlighter.TYPE_SPECIFIER).create();
            } else if (element.getParent() instanceof KdlProp) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION).textAttributes(KdlSyntaxHighlighter.PROPERTY_KEY).create();
            }
        }
    }
}
